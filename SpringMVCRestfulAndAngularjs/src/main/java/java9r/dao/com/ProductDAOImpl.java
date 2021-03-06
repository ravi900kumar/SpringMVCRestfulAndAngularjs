package java9r.dao.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.*;

import java9r.entities.com.Product;

/**
 * @author Ravi
 *
 */

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static List<Product> products;

	static {
		products = productsData();
	}

	@Override
	public List<Product> findAll() {

		return products;
	}

	@Override
	public Product findById(long id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public Product findByName(String name) {
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}

	@Override
	public void insertProduct(Product product) {

		products.add(product);

	}

	@Override
	public boolean isProductExist(Product product) {
		return findByName(product.getName()) != null;
	}

	@Override
	public void updateProduct(Product product) {
		int index = products.indexOf(product);
		products.set(index, product);

	}

	@Override
	public void deleteProductById(long id) {
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if (product.getId() == id) {
				iterator.remove();
			}
		}

	}

	private static List<Product> productsData() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "product 1", 10, 10000, "product description 1", "product1.jpeg"));
		products.add(new Product(2, "product 2", 20, 20000, "product description 2", "product2.jpeg"));
		products.add(new Product(3, "product 3", 30, 30000, "product description 3", "product3.jpeg"));
		products.add(new Product(4, "product 4", 40, 40000, "product description 4", "product4.jpeg"));
		products.add(new Product(5, "product 5", 50, 50000, "product description 5", "product5.jpeg"));
		products.add(new Product(6, "product 6", 60, 60000, "product description 6", "product6.jpeg"));
		products.add(new Product(7, "product 7", 70, 70000, "product description 7", "product7.jpeg"));
		products.add(new Product(8, "product 8", 80, 80000, "product description 8", "product8.jpeg"));

		return products;
	}

	@Override
	public void deleteAllProducts() {
		products.clear();

	}

}
