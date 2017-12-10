package java9r.controller.com;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java9r.entities.com.Product;
import java9r.service.com.ProductService;

/**
 * @author Ravi
 *
 */

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productService;

	/**
	 * 
	 * Retrieve All Products
	 */
	@RequestMapping(value = "/all/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> product = productService.findAll();
		if (product.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

	/**
	 * 
	 * Retrieve Single Product
	 */
	@RequestMapping(value = "/findone/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
		System.out.println("Fetching Product with id " + id);
		Product product = productService.findById(id);
		if (product == null) {
			System.out.println("Product with id " + id + " not found");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	/**
	 * 
	 * Retrieve Single Product By Name
	 */
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable("name") String name) {
		System.out.println("Fetching Product with id " + name);
		Product product = productService.findByName(name);
		if (product == null) {
			System.out.println("Product with id " + name + " not found");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	/**
	 * 
	 * Create a Product
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Product " + product.getName());

		if (productService.isProductExist(product)) {
			System.out.println("A Product with name " + product.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		productService.insertProduct(product);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/all/{id}").buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * 
	 * Update a Product
	 */
	@RequestMapping(value = "/update/", method = RequestMethod.POST)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		System.out.println("Updating Product " + product.getId());

		Product currentProduct = productService.findById(product.getId());

		if (currentProduct == null) {
			System.out.println("Product with id " + product.getId() + " not found");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		currentProduct.setName(product.getName());
		currentProduct.setPrice(product.getPrice());
		currentProduct.setQuantity(product.getQuantity());
		currentProduct.setPhoto(product.getPhoto());
		currentProduct.setDescription(product.getDescription());

		productService.updateProduct(currentProduct);
		return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
	}

	/**
	 * 
	 * Delete a Product
	 */
	// @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting Product with id " + id);

		Product product = productService.findById(id);
		if (product == null) {
			System.out.println("Unable to delete. Product with id " + id + " not found");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		productService.deleteProductById(id);
		;
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}

	/**
	 * 
	 * Delete All Product
	 */
	@RequestMapping(value = "/all/", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteAllProducts() {
		System.out.println("Deleting All Products");

		productService.deleteAllProducts();
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}

}
