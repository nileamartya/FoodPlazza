package com.foodplazza.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
static 	Connection conn=null;
	public static  Connection getConnectionObj()
	{
		
		try {
			String url="jdbc:mysql://localhost:3306/dbuser";
			String uName="dbuser";
			String pass="dbuser";
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded...");
			conn=DriverManager.getConnection(url,uName,pass);
			System.out.println("Connection established...");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		 catch (SQLException e) {
				e.printStackTrace();
			}
			
		return conn;
		
	}
	

}
