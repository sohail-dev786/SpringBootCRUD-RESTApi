package com.spring.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.entity.Employee;
import com.spring.crud.repository.EmployeeRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmployeeRepo empCrud;

	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee employee1=empCrud.save(employee);
		return employee1;
	}

	@Override
	public List<Employee> getAllEmployees() {
	List<Employee> emplist=empCrud.findAll();
	return emplist;
	
	}

	@Override
	public Employee getEmployeeById(Long empId) {
	
	return empCrud.findById(empId).get();	
	
	
	}

	@Override
	public void deleteById(Long empId) {
		empCrud.deleteById(empId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
	Employee employee2=empCrud.save(employee);
	return employee2;
	}

	
	
	
	
	
}
