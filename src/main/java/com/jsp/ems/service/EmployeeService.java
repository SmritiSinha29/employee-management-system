package com.jsp.ems.service;

import java.util.List;


import com.jsp.ems.entity.Employee;

public interface EmployeeService {
	
	Employee addEmp(Employee e);

	Employee findEmployeeById(String eid);
 
	String deleteEmpById(String eid);
		
	List<Employee> findEmpByName(String ename);
	
	List<Employee> findBySalary(double sal);
	
	List<Employee> findBySalRange(double sal1, double sal2); 
	
	Employee login(String val,String pass);

}
