package ma.formations.jpa.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionBuilder {
	private static EntityManagerFactory sessionFactory;
	private static final Logger logger = LogManager.getLogger(SessionBuilder.class);
	private SessionBuilder() {
	}
	public static EntityManagerFactory getSessionFactory() {
		try {
			if (sessionFactory == null)
				sessionFactory=Persistence.createEntityManagerFactory("unite1");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("{}", e);
		}
		return sessionFactory;
	}
}
