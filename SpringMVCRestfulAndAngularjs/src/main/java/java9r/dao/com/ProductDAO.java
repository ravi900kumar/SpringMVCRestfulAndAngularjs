package java9r.dao.com;

import java.util.*;

import java9r.entities.com.Product;

/**
 * @author Ravi
 *
 */

public interface ProductDAO {

	public List<Product> findAll();

	Product findById(long id);

	Product findByName(String name);

	void insertProduct(Product product);

	public boolean isProductExist(Product product);

	void updateProduct(Product product);

	void deleteProductById(long id);

	void deleteAllProducts();

}
