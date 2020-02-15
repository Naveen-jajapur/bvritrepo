package com.cg.ems.sl;

import java.util.List;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeService {
	
	public boolean validateName(String employeeName);
	public int addEmployee(Employee emp) throws EmployeeException;
	public Employee findEmployeeId(int employeeId) throws EmployeeException;
	public Employee deleteEmployeeId(int employeeId) throws EmployeeException;
	public List<Employee> findAllEmployee() throws EmployeeException;
	

}
