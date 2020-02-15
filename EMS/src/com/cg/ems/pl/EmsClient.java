package com.cg.ems.pl;

import java.util.*;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.sl.EmployeeService;
import com.cg.ems.sl.EmployeeServiceImpl;

public class EmsClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeService employeeService = new EmployeeServiceImpl();
		int choice=0;
		Employee employee=null;
		List<Employee> list=null;
		while(choice!=5) {
			
			System.out.println("1.Add Employee");
			System.out.println("2.Search Employee");
			System.out.println("3.Delete Employee");
			System.out.println("4.List All  Employee");
			System.out.println("5.Exit");
			System.out.println("Enter your choice :");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
					System.out.println("Enter the name of the employee");
					String name=sc.nextLine();
					System.out.println("Enter the salary of the employee");
					double salary = sc.nextDouble();
					employee = new Employee();  
					employee.setEmployeeName(name);
					employee.setEmployeeSalary(salary);
					try {
					int id =employeeService.addEmployee(employee);
					System.out.println("employee ID = "+id);
					}
					catch(EmployeeException e) {
						System.err.println(e.getMessage());
					}
					break;
			case 2 :
					System.out.println("Enter the id to be searched");
					try {
					int id=sc.nextInt();
					employee =employeeService.findEmployeeId(id);
					System.out.println("Name ="+employee.getEmployeeName()+"Id ="+employee.getEmployeeId()+"Salary ="+employee.getEmployeeSalary());
					}
					catch(EmployeeException e) {
						System.err.println(e.getMessage());
					}
					break;
				
			case 3:
				System.out.println("Enter the id to be deleted");
				try {
				int id =sc.nextInt();
				employee =employeeService.deleteEmployeeId(id);
				System.out.println("Name ="+employee.getEmployeeName()+"Id ="+employee.getEmployeeId()+"Salary ="+employee.getEmployeeSalary());
				}
				catch(EmployeeException e) {
					System.err.println(e.getMessage());
				}
				break;
				
			case 4:
				try {
					list=employeeService.findAllEmployee();
					for(Employee e :list) {
						int id=e.getEmployeeId();
						String name1=e.getEmployeeName();
						double sal=e.getEmployeeSalary();
						
					System.out.println(id+" "+name1+" "+sal);
					}
				}
				catch(EmployeeException e) {
					System.err.println(e.getMessage());
				}
				break;
				
			case 5 :
					System.out.println("Thank You");
					return;
				
			}
			
		}

	}

}
