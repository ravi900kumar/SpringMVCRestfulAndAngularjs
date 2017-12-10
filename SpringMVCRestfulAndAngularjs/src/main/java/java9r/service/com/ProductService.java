package java9r.service.com;

import java.util.List;
import java9r.entities.com.Product;

/**
 * @author Ravi
 *
 */

public interface ProductService {

	public List<Product> findAll();

	Product findById(long id);

	Product findByName(String name);

	void insertProduct(Product product);

	public boolean isProductExist(Product product);

	void updateProduct(Product product);

	void deleteProductById(long id);

	void deleteAllProducts();
}
