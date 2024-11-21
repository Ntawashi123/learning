package com.nt.service;
 
import java.time.LocalDate;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
 
import com.nt.entity.Employee;

import com.nt.repo.EmployeeRepository;
import com.nt.util.EmployeeNotFoundException;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired

	private EmployeeRepository repo;
 
	@Override

	public void save(Employee e) {

		repo.save(e);

	}
 
	@Override

	public Employee fetch(int id) throws EmployeeNotFoundException{

		return repo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("No employee with id: "+id));

	}
 
	@Override

	public List<Employee> list() {

		return repo.findAll();

	}
 
	@Override

	public void remove(int id) {

		repo.deleteById(id);

	}
 
	@Override
	public List<Employee> fetchAllKJoinedUtil(LocalDate d) {
		
		
		// TODO Auto-generated method stub
		return repo.findAllHiredBefore(d);
	}
 
	@Override
	public List<Employee> fetchAllJoinedBetween(LocalDate s, LocalDate e) {
		return repo.findAllHiredBetween(s, e);
	}

	@Override
	public List<Employee> fetchAllByjob(String job) {
		// TODO Auto-generated method stub
		return repo.findAllByJob(job);
	}

	@Override
	public List<Employee> fetchAllByname(String name) {
		// TODO Auto-generated method stub
		return repo.findAllByEname(name);
	}
}
 
 