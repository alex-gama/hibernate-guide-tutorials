package com.craft.coder.hibernate.mapping;

import org.hibernate.Session;
import org.junit.Test;

import com.craft.coder.hibernate.infra.HibernateConnection;

public class EmployeeHibernateMappingTest {

	@Test
	public void shouldCreateNewEmployeeWithoutTransation() throws Exception {
		Session session = HibernateConnection.getSession();
		
		Employee employee = new Employee();
		employee.setFirstName("Alexandre");
		employee.setLastName("Gama");
		employee.setAge(30l);
		
		session.save(employee);
	}
	
	@Test
	public void shouldCreateNewEmployeeWithTransation() throws Exception {
		Session session = HibernateConnection.getSession();
		
		Employee employee = new Employee();
		employee.setFirstName("Alexandre");
		employee.setLastName("Gama");
		employee.setAge(30l);
		
		//yes, initializing transaction
		session.getTransaction().begin();
		
		session.save(employee);
		
		//commiting the transaction and flushing the employee in database
		session.getTransaction().commit();
		session.close();
	}
	
}
