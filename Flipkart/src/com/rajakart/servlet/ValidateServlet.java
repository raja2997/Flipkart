package com.rajakart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet(description = "to validate user", urlPatterns = { "/ValidateServlet" })
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o=response.getWriter();
		 String username=request.getParameter("username");

		   String password=request.getParameter("password");
		   HttpSession s=request.getSession();
		   ValidateDao v=new ValidateDao();
		   boolean status=true;
			 try {
				status=v.validate(username, password);
				o.print(status);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	}
                    if(status==true)
                    {
                    	s.setAttribute("username", username);
                  	
                    	response.sendRedirect("details.html");
                    }else {
                    	response.sendRedirect("login.html");
                    }
}
}
