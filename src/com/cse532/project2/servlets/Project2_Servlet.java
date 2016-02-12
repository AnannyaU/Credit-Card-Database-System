/****************************************************************************
Brief description: This is the servlet that recieves the request from JSP page and calls facade to get results based on whichever query button is clicked.
The servlet mapping have been defined in web.xml
****************************************************************************/

package com.cse532.project2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cse532.project2.facade.Project2_Facade;

public class Project2_Servlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Project2_Facade facade = new Project2_Facade();
		List<String[]> records = new ArrayList<>();
		String action = request.getParameter("action");
		try 
		{
			if ("Query1".equals(action)) 
			{
				records = facade.getDataForQuery1();
			} 
			else if ("Query2".equals(action)) 
			{
				records = facade.getDataForQuery2();
			} 
			else if ("Query3".equals(action)) 
			{
				records = facade.getDataForQuery3();
			} 
			else if ("Query4".equals(action)) 
			{
				records = facade.getDataForQuery4();
			} 
			else if ("Query5".equals(action)) 
			{
				records = facade.getDataForQuery5();
			}

		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

		request.setAttribute("records", records);
		request.setAttribute("query",action);
		getServletConfig().getServletContext().getRequestDispatcher("/forward.jsp").forward(request,response);
		
	}
}