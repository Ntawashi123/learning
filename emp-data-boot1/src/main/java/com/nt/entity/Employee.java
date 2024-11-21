package com.nt.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table (name="emps")
public class Employee {
	@Id
	@Column(name="emp_no")
	private int empNo;
	@Column(name="ename", length =30)
	private String empName;
	@Column(length = 20)
	private String job;
	@Column (name="hire_date")
	private LocalDate hireDate;
	public Employee() {
		
	}
	public Employee(int empNo, String empName, String job, LocalDate hireDate) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.hireDate = hireDate;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	

}
