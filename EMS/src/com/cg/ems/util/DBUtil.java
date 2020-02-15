package com.cg.ems.util;

import java.sql.*;

public class DBUtil {
	
	public static Connection getConnection() throws Exception{
		

		String username="scott";
		String password="tiger";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String className="oracle.jdbc.driver.OracleDriver";
		
		Connection connection = null;
		Class.forName(className);
		connection =DriverManager.getConnection(url,username,password);
		return connection;
	}

}
