package com.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.beans.Employee;
import com.hcl.exception.EmployeeException;
import com.hcl.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@GetMapping("/displayAll")
	public ResponseEntity<List<Employee>> getEmployees(){
		return new ResponseEntity<List<Employee>>(service.displayEmployee(),HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) throws EmployeeException{
		return new ResponseEntity<Employee>(service.addEmployee(e),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) throws EmployeeException{
		return new ResponseEntity<Boolean>(service.deleteEmployee(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee e) throws EmployeeException{
		return new ResponseEntity<Employee>(service.updateEmployee(e, id),HttpStatus.OK);
	}
	
	@GetMapping("/searchEmployee/{id}")
	public ResponseEntity<Employee> searchEmployee(@PathVariable int id) throws EmployeeException{
		return new ResponseEntity<Employee>(service.searchEmployee(id),HttpStatus.OK);
	}
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<Object> handleRuntimeException(HttpServletRequest request, Exception ex){
		System.out.println("Controller based exception");
	//	System.out.println("RuntimeException Occured:: URL="+request.getRequestURL() +" raised "+ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);	
	}
}
