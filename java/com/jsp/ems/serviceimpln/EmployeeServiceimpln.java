package com.jsp.ems.serviceimpln;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ems.entity.Employee;
import com.jsp.ems.entity.IdGenerator;
import com.jsp.ems.exception.EmployeeNotFoundException;
import com.jsp.ems.exception.InvalidCredentialsException;
import com.jsp.ems.repo.EmployeeRepo;
import com.jsp.ems.repo.GeneratorRepo;
import com.jsp.ems.service.EmployeeService;

@Service
public class EmployeeServiceimpln implements EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	GeneratorRepo genrepo;
	
	
	@Override
	public Employee addEmp(Employee e) {
		String  eid = idGeneration();
		e.setEid(eid);
		Employee e1 = empRepo.save(e);
		return e1;
	}
//
//	@Override
//	public Employee findEmployeeById(int id) {
//		// TODO Auto-generated method stub
//		Employee e = empRepo.findById(id).orElse(null);
//		if(e!=null) {
//			return e;
//		}
//		throw new EmployeeNotFoundException("Employee ID Not Found");
//	}

	@Override
	public Employee findEmployeeById(String eid) {
		// TODO Auto-generated method stub
		Employee e = empRepo.findByEid(eid);
		if(e!=null) {
			return e;
		}
		throw new EmployeeNotFoundException("Employee ID Not Found");
	}
	@Override
	public String deleteEmpById(String id) {
		// TODO Auto-generated method stub
		Employee e = empRepo.findByEid(id);
		if(e!=null) {
			empRepo.deleteByEid(id);
			return "Data deleted successfully";
		}
		throw new EmployeeNotFoundException("Employee Name Not Found");
	}
//	
//	@Override
//	public String deleteEmpById(int id) {
//		// TODO Auto-generated method stub
//		Employee e = empRepo.findById(id).orElse(null);
//		if(e!=null) {
//			empRepo.deleteById(id);
//			return "Data deleted successfully";
//		}
//		throw new EmployeeNotFoundException("Employee Name Not Found");
//	}
	@Override
	public List<Employee> findEmpByName(String ename) {
		// TODO Auto-generated method stub
		List<Employee> e1=empRepo.findByEname(ename);
		if(e1.size()>0) {
			return e1;
		}
		throw new EmployeeNotFoundException("Employee Name Not Found");
	}

	@Override
	public List<Employee> findBySalary(double sal) {
		// TODO Auto-generated method stub
		List<Employee> e1 = empRepo.findBySalary(sal);
		if(e1.size()>0) {
			return e1;
		}
		throw new EmployeeNotFoundException("Employees Salary  Not Found");
	}

	@Override
	public List<Employee> findBySalRange(double sal1, double sal2) {
		// TODO Auto-generated method stub
		List<Employee> e1 = empRepo.findSalByRange(sal1, sal2);
		if(e1.size()>0) {
			return e1;
		}
		throw new EmployeeNotFoundException("Employees Not Found");
	}
  
	private String idGeneration() {
		IdGenerator i= genrepo.save(new IdGenerator());
        int id=i.getId();
        if(id<10) {
        	return"TCS00"+id;
        } 
        else if (id<100){
        return"TCS0"+id;
        }
        return "TCS"+id;
	}

	@Override
	public Employee login(String val, String pass) {
		Employee e = empRepo.findEmpByIdOrEmail(val,val);
		if(e!=null) {
			if(e.getPwd().equals(pass)) {
				return e;
			}
		}
		throw new InvalidCredentialsException("Invalid Credential");
	}
	 
  	
	

}
