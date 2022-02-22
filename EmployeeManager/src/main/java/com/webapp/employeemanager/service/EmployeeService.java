package com.webapp.employeemanager.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.employeemanager.exception.UserNotFoundException;
import com.webapp.employeemanager.model.Employee;
import com.webapp.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployee(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException ("User by id " + id + " was not found"));
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
}
