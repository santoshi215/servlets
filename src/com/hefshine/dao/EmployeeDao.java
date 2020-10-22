package com.hefshine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hefshine.Employee;

public class EmployeeDao {
	String url = "jdbc:mysql://localhost:3306/demo";
	String username = "root";
	String password = "Santu@956";	
	public boolean checkUserName(Employee emp){
		boolean b= false;
		String sel="select username ,password from employee where username =? and password=?";
	try
	{	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(sel);
		st.setString(1,emp.getUsername());
		st.setString(2, emp.getPassword());
		ResultSet set=st.executeQuery();	
		
		while(set.next())
		{
			b = true;
			System.out.println("exe");
		}	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return b;
	}
	
}
