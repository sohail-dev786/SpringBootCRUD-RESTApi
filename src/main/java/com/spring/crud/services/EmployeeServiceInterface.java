package com.spring.crud.services;

import java.util.List;

import com.spring.crud.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long empId);

	public void deleteById(Long empId);

	public Employee updateEmployee(Employee employee);


}
