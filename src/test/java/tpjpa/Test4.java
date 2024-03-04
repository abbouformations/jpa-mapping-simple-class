package tpjpa;

import java.util.List;

import ma.formations.jpa.service.IService;
import ma.formations.jpa.service.ServiceImpl;
import ma.formations.jpa.service.model.Product;

/**
 * 
 * Tester : getProdctById et removeProduct
 *
 */
public class Test4 {
	private static final Long PRODUCT_ID = 1l;

	public static void main(String[] args) {
		IService service = new ServiceImpl();
		Product productFound = service.getProdctById(PRODUCT_ID);
		if (productFound != null)
			service.removeProduct(PRODUCT_ID);
		List<Product> productsFound=service.getAllProducts();
		productsFound.forEach(System.out::println); //vérifier que le produit a été bien supprimé.
	}
}
