package com.craft.coder.hibernate.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "customer")
	@TableGenerator(
			name = "customer", 
			table = "CustomerGenerator",
			pkColumnName = "pKey",
			valueColumnName = "next_value",
			pkColumnValue = "id",
			allocationSize = 30)
	private Long id;

	private String username;

	private String github;

	Customer() {
	}

	public Customer(String username, String github) {
		this.username = username;
		this.github = github;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getGithub() {
		return github;
	}

}
