package com.craft.coder.hibernate.mapping;

import org.hibernate.Session;
import org.junit.Test;

import com.craft.coder.hibernate.infra.HibernateConnection;

public class HibernateGenerationTypeTest {

	@Test
	public void shouldCreateNewEmployeeWithGenerationTypeTable() throws Exception {
		Session session = HibernateConnection.getSession();
		
		Employee employee = new Employee("Alexandre", "Gama", 30L);
		
		session.getTransaction().begin();
		
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void shouldCreateNewCustomerWithGenerationTypeTable() throws Exception {
		Session session = HibernateConnection.getSession();
		
		Customer customer = new Customer("alexandregama", "@alexandregama");
		
		session.getTransaction().begin();
		
		session.save(customer);
		
		session.getTransaction().commit();
		session.close();
	}
	
}
