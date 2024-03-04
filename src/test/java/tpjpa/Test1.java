package tpjpa;

import java.util.List;

import ma.formations.jpa.service.IService;
import ma.formations.jpa.service.ServiceImpl;
import ma.formations.jpa.service.model.Product;

/**
 * 
 * Tester : saveProduct (pour créer un nouveau produit) et getAllProducts
 *
 */
public class Test1 {

	public static void main(String[] args) {
		IService service = new ServiceImpl();
		service.saveProduct(new Product("TV 32P SONY"));
		service.saveProduct(new Product("PC HP i7"));
		service.saveProduct(new Product("Camera Sony"));
		service.saveProduct(new Product("Camera Sony type2"));
		service.saveProduct(new Product("Camera Sony type3"));

		List<Product> products = service.getAllProducts();
		products.forEach(System.out::println);
	}
}
