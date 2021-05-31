package com.hcl.service;

import java.util.List;

import com.hcl.beans.Employee;
import com.hcl.exception.EmployeeException;

public interface EmployeeService {
	public List<Employee> displayEmployee();
	public Employee addEmployee(Employee e) throws EmployeeException;
	public boolean deleteEmployee(int id) throws EmployeeException;
	public Employee updateEmployee(Employee e,int id) throws EmployeeException;
	public Employee searchEmployee(int id) throws EmployeeException;
}
