package com.gmc.neo4japi.demo.Employee;

// Class represents an employee
public class Employee {
	private String name;
	private int emp_Id;	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	public Employee(String name, int emp_Id) {
		super();
		this.name = name;
		this.emp_Id = emp_Id;
	}
	
	public Employee() {
		
	}
}
