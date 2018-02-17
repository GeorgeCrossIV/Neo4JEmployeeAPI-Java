package com.gmc.neo4japi.demo.Employee;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.neo4j.driver.v1.*;
import org.neo4j.driver.internal.spi.Connection;
import org.springframework.stereotype.Service;
import org.neo4j.driver.v1.Values;

@Service
public class EmployeeService {

	private String uri = "bolt://neo4j-gmc.eastus.cloudapp.azure.com:7687";
	private String user = "neo4j";
	private String password = "Pass@word1";
	private Driver driver;
	
	private List<Employee> employees = new ArrayList<>();
			
	public List<Employee> getAllEmployees() {
		int empId;
		String tempEmpId;
		String name;
		
		driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
		
		try (Session session = driver.session()){
			List<Record> employeeList = session.run("MATCH (a:Employee) " +
					"RETURN a.id as id, a.name as name " +
					"LIMIT 25"
					).list();
			
			employees.clear(); 	// remove all existing employees from the list
			
			for (Record record:employeeList) {
				empId = record.get("id").asInt();
				name = record.get("name").asString();
				
				employees.add(new Employee(name, empId));
			}
		}
		catch (Exception e) {
			
		}
		return employees;
	}
	
	public void AddEmployee(Employee employee) {
	
		driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
		
		try (Session session = driver.session()){
			session.run("CREATE (a:Employee {id: $id, name: $name})", 
					Values.parameters("name", employee.getName(), "id", employee.getEmp_Id()));

		}
		catch (Exception e) {
			
		}		
	}
	
	public Employee getEmployee(int emp_Id) {
		return employees.stream().filter(e->e.getEmp_Id() == emp_Id).findFirst().get();
	}
	
	public void deleteEmployee(int emp_Id) {
		employees.removeIf(e->e.getEmp_Id() == emp_Id);
	}	
	
	public void Close() throws Exception{
		driver.close();
	}
}


