package com.webapp.employeemanager.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.employeemanager.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Optional<Employee> findEmployeeById(Long id);
	
}
