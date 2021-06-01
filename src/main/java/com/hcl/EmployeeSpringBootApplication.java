package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EmployeeSpringBootApplication extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringBootApplication.class, args);
	}
	 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(EmployeeSpringBootApplication.class);
    }


}
