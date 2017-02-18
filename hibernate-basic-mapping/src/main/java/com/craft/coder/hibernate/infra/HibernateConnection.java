package com.craft.coder.hibernate.infra;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		createSessionFactory();
		
		return sessionFactory.openSession();
	}
	
	public static EntityManager getEntityManager() {
		createSessionFactory();
		
		return sessionFactory.createEntityManager();
	}

	private static void createSessionFactory() {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration()
					.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect")
					.setProperty(AvailableSettings.DRIVER, "com.mysql.jdbc.Driver")
				    .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/hibernate-guide-tutorials")
				    .setProperty(AvailableSettings.USER, "root")
				    .setProperty(AvailableSettings.PASS, "")
				    .setProperty(AvailableSettings.HBM2DDL_AUTO, "update")
				    .setProperty(AvailableSettings.SHOW_SQL, "true")
				    .setProperty(AvailableSettings.FORMAT_SQL, "true");
	
			sessionFactory = cfg.buildSessionFactory();
		}
	}
	
	public static void closeFactory() {
		sessionFactory.close();
	}
	
}
