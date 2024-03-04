package tpjpa;

import java.util.List;

import ma.formations.jpa.service.IService;
import ma.formations.jpa.service.ServiceImpl;
import ma.formations.jpa.service.model.Product;

/**
 * 
 * Tester : getProductsByDesignation
 *
 */
public class Test3 {
	private static final String PRODUCT_DESIGNATION="Camera Sony";

	public static void main(String[] args) {
		IService service = new ServiceImpl();
		List<Product> productsFound=service.getProductsByDesignation(PRODUCT_DESIGNATION);
		productsFound.forEach(System.out::println);
	}
}
