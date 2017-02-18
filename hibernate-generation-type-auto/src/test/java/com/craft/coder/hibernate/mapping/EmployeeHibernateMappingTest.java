package com.craft.coder.hibernate.mapping;

import org.hibernate.Session;
import org.junit.Test;

import com.craft.coder.hibernate.infra.HibernateConnection;

public class EmployeeHibernateMappingTest {

	@Test
	public void shouldCreateNewEmployeeWithoutIdAnnotation() throws Exception {
		Session session = HibernateConnection.getSession();
		
		Employee employee = new Employee("Alexandre", "Gama", 30L);
		
		session.getTransaction().begin();
		
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
	}
	
}
