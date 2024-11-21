package com.nt.service;

import java.time.LocalDate;
import java.util.List;

import com.nt.entity.Employee;
import com.nt.util.EmployeeNotFoundException;



public interface EmployeeService {

	
	public void save (Employee e) ;
	
	
	
	
	public Employee fetch(int id ) throws EmployeeNotFoundException ;
	
	public List<Employee>list();
	
	public void remove (int id);
	
public List<Employee> fetchAllKJoinedUtil (LocalDate d);
	
	public List<Employee> fetchAllJoinedBetween (LocalDate s, LocalDate e);
	public List<Employee> fetchAllByjob(String job);
	public List<Employee> fetchAllByname(String name);
}
 
	

