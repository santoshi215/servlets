package com.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.Employee;
import com.hefshine.dao.EmployeeDao;

public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//request dispatcher
	response.setContentType("text/html");
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		
		PrintWriter out=response.getWriter();
		
		Employee emp =new Employee(uname,password);
		EmployeeDao dao= new EmployeeDao();
		System.out.println("called");
		
		
		if(dao.checkUserName(emp))
		{
			out.println("welcome ..."+uname );
			RequestDispatcher rd=request.getRequestDispatcher("/NewServlet");
			rd.forward(request	, response);
		}
		else
		{
			out.print("sorry your username is not found.");
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.include(request	, response);
			
		}
		
		/*PrintWriter out=response.getWriter();
		out.print("hellow from servlet.");
		
		String s=request.getParameter("username");
		System.out.println("hello servlet.");
		HttpSession session=request.getSession();
		String s1=(String)session.getAttribute("username");
		out.print(s+  "home servlet.");*/
		
		
		
	
	}
	

}
