package ma.formations.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.formations.jpa.dao.SessionBuilder;
import ma.formations.jpa.service.model.Product;

@SuppressWarnings({ "unchecked", "finally" })
public class ServiceImpl implements IService {

	@Override
	public void saveProduct(Product p) {
		EntityManager session = null;
		EntityTransaction tx = null;
		try {
			session = SessionBuilder.getSessionFactory().createEntityManager();
			tx = session.getTransaction();
			tx.begin();
			session.merge(p);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}


	@Override
	public List<Product> getAllProducts() {
		List<Product> result = new ArrayList<Product>();
		EntityManager session = null;
		try {
			session = SessionBuilder.getSessionFactory().createEntityManager();
			result = session.createQuery("select a from Product a").getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			return result;
		}
	}

	@Override
	public void removeProduct(Long id) {
		EntityManager session = null;
		EntityTransaction tx = null;
		try {
			session = SessionBuilder.getSessionFactory().createEntityManager();
			tx = session.getTransaction();
			tx.begin();

			Product p = session.find(Product.class, id);
			if (p != null)
				session.remove(p);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		} 

	}

	@Override
	public Product getProdctById(Long id) {
		Product result = null;
		EntityManager session = null;
		try {
			session = SessionBuilder.getSessionFactory().createEntityManager();
			result = session.find(Product.class,id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			return result;
		}
	}
	
	
	@Override
	public List<Product> getProductsByDesignation(String designation) {
		List<Product> result = new ArrayList<Product>();
		EntityManager session = null;
		try {
			session = SessionBuilder.getSessionFactory().createEntityManager();
			Query requete=session.createQuery("select p from Product p where p.designation like :d");
			requete.setParameter("d","%"+designation+"%");
			result=requete.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			return result;
		}
	}

}
