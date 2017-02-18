package com.craft.coder.hibernate.infra;

import org.hibernate.Session;

public class HibernateConnectionTest {

	public static void main(String[] args) {
		Session session = HibernateConnection.getSession();
		session.close();
		
		HibernateConnection.closeFactory();
	}
	
}
