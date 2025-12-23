package com.jsp.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ems.entity.Employee;
import com.jsp.ems.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmp")
	ResponseEntity<Employee> addEmp(@RequestBody Employee e ) {
		return new ResponseEntity<Employee>(employeeService.addEmp(e),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/empById")
	public ResponseEntity<Employee> findEmployeeById(@RequestParam String id){	
		return new ResponseEntity<Employee>(employeeService.findEmployeeById(id),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delById")
	public ResponseEntity<String> deleteEmployeeById(@RequestParam String id){	
		return new ResponseEntity<String>(employeeService.deleteEmpById(id),HttpStatus.OK);
	}
	
	@GetMapping("/findBySal")
	public ResponseEntity<List<Employee>> findBySalary(@RequestParam double sal){
		return new ResponseEntity<List<Employee>>(employeeService.findBySalary(sal), HttpStatus.FOUND);
	}
	@GetMapping("/empByName")
	public ResponseEntity<List<Employee>> findEmployeeByName(@RequestParam String ename){	
		return new ResponseEntity<List<Employee>>(employeeService.findEmpByName(ename),HttpStatus.FOUND);
	}
	
	@GetMapping("/emp/findBySal")
	public ResponseEntity<List<Employee>> findBySalRange(@RequestParam double sal1,@RequestParam double sal2){
		return new ResponseEntity<List<Employee>>(employeeService.findBySalRange(sal1,sal2), HttpStatus.FOUND);
	}
	
		
	
}
