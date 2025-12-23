package com.jsp.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.ems.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
  
	@Query(nativeQuery = true, value="select* from employee where ename=?1")
	List<Employee> findByname(String ename);
	
	List<Employee> findByEname(String ename);
	
	
	Employee findByEid(String eid);
	
	@Query(nativeQuery= true, value="Select * from employee where sal<=?1")
    List<Employee> findBySalary(double sal);
	
	@Query(nativeQuery=true, value="Select * from employee where sal>=?1 sal1 and sal<=?2 sal2")
	List<Employee>findSalByRange(double sal1, double sal2);

     Employee  deleteByEid(String id);
     
     @Query(nativeQuery= true, value="Select * from employee where eid=? eid or email=? email")
     Employee findEmpByIdOrEmail(String eid, String email);
     

	
	
	
	
	
}
