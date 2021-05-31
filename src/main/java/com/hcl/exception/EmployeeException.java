package com.hcl.exception;

public class EmployeeException extends Exception{
	private static final long serialVersionUID = 1L;
	private String msg;
	public EmployeeException(String msg){
	
		this.msg=msg;
	}
	public String getMessage(){
		return msg;
	}
}
