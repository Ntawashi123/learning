package com.nt.rest;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.nt.entity.Employee;
import com.nt.service.EmployeeService;
import com.nt.util.EmployeeNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
@RestController
@RequestMapping("Employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
    @PostMapping(value = "/save",consumes="application/json")
    public String save(@RequestBody Employee e) {
    	service.save(e);
        return "Employee saved";
    }
    @GetMapping(value="/fetch{id}",produces="application/json")
    public Employee fetch(int id) throws EmployeeNotFoundException {
        return service.fetch(id);
    }
    @ExceptionHandler(value=EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleException(EmployeeNotFoundException ex){
    	return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
    
    
    @GetMapping(value="/list",produces="application/json")
    public List<Employee> list() {
        return service.list();
    }
    @DeleteMapping("/remove")
    public String delete(int id) {
    	service.remove(id);
    	return "Employee deleted";
    }
    
    @GetMapping(value="/listbyjob",produces="application/json")
    public List<Employee> listByJob(String job){
    	return service.fetchAllByjob(job);
    }
    
    @GetMapping(value="/listbyname",produces="application/json")
    public List<Employee> listByName(String n){
    	return service.fetchAllByname(n);
    }
}

 
 