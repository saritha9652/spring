package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Employee;
import com.hcl.exception.EmployeeException;
import com.hcl.repository.EmployeeDAO;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDAO emp;
	@Override
	public List<Employee> displayEmployee() {
		// TODO Auto-generated method stub
		return emp.findAll();
	}

	@Override
	public Employee addEmployee(Employee e) throws EmployeeException {
		// TODO Auto-generated method stub
		if(!emp.findById(e.getId()).isPresent())
			return emp.save(e);
		else 
			throw new EmployeeException("id already exists");
	}

	@Override
	public boolean deleteEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		if(emp.findById(id).isPresent()) {
			emp.deleteById(id);
			return true;
		}
		else 
			throw new EmployeeException("id not exists");
		
	}

	@Override
	public Employee updateEmployee(Employee e, int id) throws EmployeeException {
		// TODO Auto-generated method stub
		if(emp.findById(id).isPresent())
			return emp.saveAndFlush(e);
		else 
			throw new EmployeeException("id not exists");
	}

	
	@Override
	public Employee searchEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		if(emp.findById(id).isPresent())
			return emp.findById(id).get();
		else 
			throw new EmployeeException("id not exists");
	}

}
