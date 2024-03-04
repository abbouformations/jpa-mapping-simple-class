package tpjpa;

import java.util.List;

import ma.formations.jpa.service.IService;
import ma.formations.jpa.service.ServiceImpl;
import ma.formations.jpa.service.model.Product;

/**
 * 
 * Tester : saveProduct pour modifier un article existant
 *
 */
public class Test2 {

	//produit avec l'idnetifiant 2 existe déja au niveau de la table.
	private static final Long PRODUCT_ID = 2l; 
	// produit avec l'idnetifiant 2 existe déja au niveau de la table.
	private static final String NOUVELLE_DESIGNATION = "PC HP i7 NOUVELLE GENERATION"; 

	public static void main(String[] args) {
		IService service = new ServiceImpl();
		Product product = new Product(NOUVELLE_DESIGNATION);
		product.setIdentifiant(PRODUCT_ID);
		service.saveProduct(product);
		List<Product> products = service.getAllProducts();
		products.forEach(System.out::println);
	}
}
