package com.hcl.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hcl.beans.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer>{

}
