package com.cg.ems.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.util.DBUtil;

public class EmployeeDaoJdbcImpl implements EmployeeDao{

	@Override
	public int addEmployee(Employee emp) throws EmployeeException {
		try {
		Connection con =DBUtil.getConnection();
		String cmd="insert into employee_tbl values(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(cmd);
		pstmt.setInt(1, emp.getEmployeeId());
		pstmt.setString(2, emp.getEmployeeName());
		pstmt.setDouble(3, emp.getEmployeeSalary());
		pstmt.executeUpdate();
		con.close();
		}
		catch(Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		return emp.getEmployeeId();
	}

	@Override
	public Employee findEmployeeId(int employeeId) throws EmployeeException {
		Employee e=new Employee();
		try {
		Connection con =DBUtil.getConnection();
		String cmd="select empid,empname,empsal from employee_tbl where empid=?";
		PreparedStatement pstmt=con.prepareStatement(cmd);
		pstmt.setInt(1, employeeId);
		
		ResultSet rst =pstmt.executeQuery();
		if(rst.next()) {
			int id=rst.getInt("empid");
			String str=rst.getString("empname");
			double sal=rst.getDouble("empsal");
//			e.setEmployeeId(id);
//			e.setEmployeeName(str);
//			e.setEmployeeSalary(sal);
			e=new Employee(id,str,sal);
		}
		else {
			throw new EmployeeException(employeeId+" not exist");
		}
		
		
		
		con.close();
		}
		catch(Exception e1) {
			throw new EmployeeException(e1.getMessage());
		}
		return e;
		
	}

	@Override
	public Employee deleteEmployeeId(int employeeId) throws EmployeeException {
		Employee e=new Employee();
		try {
		Connection con =DBUtil.getConnection();
		String cmd="delete from employee_tbl where empid=?";
		PreparedStatement pstmt=con.prepareStatement(cmd);
		pstmt.setInt(1, employeeId);
		ResultSet rst =pstmt.executeQuery();
		if(rst.next()) {
			int id=rst.getInt("empid");
			String str=rst.getString("empname");
			double sal=rst.getDouble("empsal");
//			e.setEmployeeId(id);
//			e.setEmployeeName(str);
//			e.setEmployeeSalary(sal);
			e=new Employee(id,str,sal);
		}
		else {
			throw new EmployeeException(employeeId+" not exist");
		}
		
		
		
		con.close();
		}
		catch(Exception e1) {
			throw new EmployeeException(e1.getMessage());
		}
		return e;
		
		
	}

	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
		List<Employee> list=new ArrayList<Employee>();
		Employee e=null;
		try {
		Connection con =DBUtil.getConnection();
		String cmd="select empid,empname,empsal from employee_tbl";
		PreparedStatement pstmt=con.prepareStatement(cmd);
		
		ResultSet rst =pstmt.executeQuery(cmd);
		
		while(rst.next()) {
		int id=rst.getInt("empid");
		String str=rst.getString("empname");
		Double sal=rst.getDouble("empsal");
		e= new Employee(id,str,sal);
		list.add(e);
		}
		
		con.close();
		}catch(Exception e1) {
			throw new EmployeeException(e1.getMessage());
		}
	
		
		return list;
	}
	

}
