package com.craft.coder.hibernate.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Long age;
	
	Employee() {}
	
	public Employee(Long id, String firstName, String lastName, Long age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getAge() {
		return age;
	}

}
