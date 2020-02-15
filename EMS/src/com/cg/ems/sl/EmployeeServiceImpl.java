package com.cg.ems.sl;

import java.util.List;
import java.util.Random;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoJdbcImpl;
import com.cg.ems.dao.EmployeeDaoMapImpl;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	public EmployeeServiceImpl() {
		employeeDao=new EmployeeDaoJdbcImpl();
	}
	@Override
	public boolean validateName(String employeeName) {
		if(employeeName.matches("[a-zA-Z]+")) {
			return true;
		}
		
		return false;
	}

	@Override
	public int addEmployee(Employee emp) throws EmployeeException {
		String name=emp.getEmployeeName();
		boolean flag=validateName(name);
		if(!flag) {
			throw new EmployeeException("Name should be only in characters"); 
		}
		Random rand= new Random();
		int id=rand.nextInt(100)+1000;
		emp.setEmployeeId(id);
		return employeeDao.addEmployee(emp);
	}

	@Override
	public Employee findEmployeeId(int employeeId) throws EmployeeException {
		String str=String.valueOf(employeeId);
		if(!str.matches("[0-9]{4}")) {
			throw new EmployeeException("Employee Id should be 4 digit number");
		}
		
		return employeeDao.findEmployeeId(employeeId);
	}

	@Override
	public Employee deleteEmployeeId(int employeeId) throws EmployeeException {
		
		String str=String.valueOf(employeeId);
		if(!str.matches("[0-9]{4}")) {
			throw new EmployeeException("Employee Id should be 4 digit number");
		}
		
		return employeeDao.deleteEmployeeId(employeeId);
	}

	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
		
		
		return employeeDao.findAllEmployee();
	}

}
