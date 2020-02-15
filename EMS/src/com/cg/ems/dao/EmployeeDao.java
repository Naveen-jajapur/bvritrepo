package com.cg.ems.dao;
import java.util.*;
import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeDao {
	public int addEmployee(Employee emp) throws EmployeeException;
	public Employee findEmployeeId(int employeeId) throws EmployeeException;
	public Employee deleteEmployeeId(int employeeId) throws EmployeeException;
	
    public List<Employee> findAllEmployee() throws EmployeeException;

}
