package com.spring.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.entity.Employee;
import com.spring.crud.services.EmployeeServiceInterface;

@RestController
public class EmployeeController {
	

	@Autowired
	EmployeeServiceInterface empService;
	
	
	@PostMapping("/SaveEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{	
		Employee employeeSaved=empService.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved  , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/Employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> employeeList=empService.getAllEmployees();
		if(employeeList.size()>0) {
			return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/Employee/{empId}")
	public ResponseEntity<Employee> getAllEmployees(@PathVariable("empId") Long empId){
		
		Employee employeeFound=empService.getEmployeeById(empId);
		
		return new ResponseEntity<Employee>(employeeFound,HttpStatus.OK);
	}
	
	@DeleteMapping("Employee/delete/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") Long empId)
	{
		empService.deleteById(empId);
		return new  ResponseEntity<Void>(HttpStatus.GONE);
		
	}
	
	
	@PutMapping("/UpdateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{	
		Employee employeeUpdate=empService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employeeUpdate  , HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	
	
}
