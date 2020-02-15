package com.cg.ems.dao;

import java.util.*;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeDaoMapImpl implements EmployeeDao{
	
	private Map<Integer,Employee> map ;
	public EmployeeDaoMapImpl() {
		map=new HashMap<Integer,Employee>();
	}

	@Override
	public int addEmployee(Employee emp) throws EmployeeException {
		if(map.containsKey(emp.getEmployeeId())) {
			throw new EmployeeException("Id already Exists");
		}
		map.put(emp.getEmployeeId(), emp);
		return emp.getEmployeeId();
	}

	@Override
	public Employee findEmployeeId(int employeeId) throws EmployeeException {
		Employee emp =null;
		if(!map.containsKey(employeeId)) {
			throw new EmployeeException("Id doesn't exists");
		}
		emp=map.get(employeeId);
		return emp;
	}

	@Override
	public Employee deleteEmployeeId(int employeeId) throws EmployeeException {
		Employee emp =null;
		if(!map.containsKey(employeeId)) {
			throw new EmployeeException("Id doesn't exists");
		}
		emp=map.remove(employeeId);
	
		return emp;
	}

	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
		Collection<Employee> coll =map.values();
		List<Employee> list = new ArrayList<Employee>(coll);
		if(coll.isEmpty()) {
			throw new EmployeeException(" No Employees details are found");
		}
//		for(Employee e : list) {
//			list.add(e);
//		}
		return list;
	}

}
