package com.masai.bean;

import com.masai.doa.EmployeeImpl;

public class Employee extends EmployeeImpl {
	
	private String username;
	private String password;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Engineer [username=" + username + ", password=" + password + "]";
	}
	
	
	

}
