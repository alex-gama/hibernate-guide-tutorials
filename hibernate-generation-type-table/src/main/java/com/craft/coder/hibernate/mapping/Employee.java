package com.craft.coder.hibernate.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee")
	@TableGenerator(
			name = "employee",
			table = "EmployeeGenerator",
			pkColumnName = "pKey",
			valueColumnName = "next_value",
			pkColumnValue = "id",
			allocationSize = 30)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Long age;
	
	Employee() {}
	
	public Employee(String firstName, String lastName, Long age) {
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
