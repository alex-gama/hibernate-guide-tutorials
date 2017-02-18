package com.craft.coder.hibernate.mapping;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
		session.close();
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
	
	@Test
	public void shouldCreateNewEmployeeWithConstructor() throws Exception {
		Session session = HibernateConnection.getSession();
		
		Employee employee = new Employee("Alexandre", "Gama", 30L);
		
		//yes, initializing transaction
		session.getTransaction().begin();
		
		session.save(employee);
		
		//commiting the transaction and flushing the employee in database
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void shouldGetAnEmployeeBasedOnItsId() throws Exception {
		Session session = HibernateConnection.getSession();
		
		Employee employeeFound = session.get(Employee.class, 3L);
		
		assertThat(employeeFound.getFirstName(), equalTo("Alexandre"));
	}
	
}
