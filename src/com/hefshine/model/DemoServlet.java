package com.hefshine.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.Employee;
import com.hefshine.dao.EmployeeDao;


public class DemoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(uname);
		
		PrintWriter out=response.getWriter();
		
		Employee emp =new Employee(uname,password);
		EmployeeDao dao= new EmployeeDao();
		
		boolean s=dao.checkUserName(emp);
		System.out.println("status is:"+s);
		
		//requestdispatcher to access within same appli            cation
		
		if(dao.checkUserName(emp))//-->to acces other app alos send redirect
		{
			out.print(("welcome.."+uname));
			//out.println(uname+" "+password+"   logged in succesfully.");
			/*RequestDispatcher rd=request.getRequestDispatcher("NewServlet");
			rd.forward(request	, response);*/
			response.sendRedirect("https://github.com/santoshi215/Anualy");
			
		}
		else
		{
			out.println(uname+" "+password+"   invalid username & password.");
		}
		
	
	}

		
		
	

	
}
