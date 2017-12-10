package java9r.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import java9r.dao.com.ProductDAO;
import java9r.entities.com.Product;

/**
 * @author Ravi
 *
 */

@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> findAll() {

		return productDAO.findAll();
	}

	@Override
	public Product findById(long id) {
		return productDAO.findById(id);
	}

	@Override
	public Product findByName(String name) {

		return productDAO.findByName(name);
	}

	@Override
	public void insertProduct(Product product) {
		productDAO.insertProduct(product);

	}

	@Override
	public boolean isProductExist(Product product) {

		return productDAO.isProductExist(product);
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);

	}

	@Override
	public void deleteProductById(long id) {
		productDAO.deleteProductById(id);

	}

	@Override
	public void deleteAllProducts() {
		productDAO.deleteAllProducts();

	}

}
