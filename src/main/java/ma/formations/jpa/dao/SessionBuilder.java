package ma.formations.jpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionBuilder {
	private static EntityManagerFactory sessionFactory;
	private SessionBuilder() {
		
	}
	public static EntityManagerFactory getSessionFactory() {
		try {
			if (sessionFactory == null)
				sessionFactory=Persistence.createEntityManagerFactory("unite1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
