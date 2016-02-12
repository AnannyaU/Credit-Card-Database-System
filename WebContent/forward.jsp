<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSE532 Project 2</title>
</head>
<body background="background.png">
	<form action="CSE532">
		<input type="submit" name="action" value="Query1"> 
		<input type="submit" name="action" value="Query2"> 
		<input type="submit" name="action" value="Query3"> 
		<input type="submit" name="action" value="Query4"> 
		<input type="submit" name="action" value="Query5">
	</form>
<%  

List<String[]> list = (List<String[]>) request.getAttribute("records");
String query =  (String) request.getAttribute("query");
if(!list.isEmpty() && list != null)
{
	out.println("<BR><BR><BR>");
	if("Query1".equals(query))
	{
		out.println("<div id = \"q1\"><table border =\"1\"");
		out.println("<tr><td>User Id</td><td>User Name</td><td>Signer Id</td><td>Signer Name</td></tr>");
		for( String[] row: list)
		{
			out.println("<tr>");
		    for( String s: row )
			{
		        out.println( "<td> " + s + "</td>" );
		    } 
		    out.println("</tr>");
		}
		out.println("</table></div>");
	}
	if("Query2".equals(query))
	{
		out.println("<table border =\"1\">");
		out.println("<tr><td>User Id</td><td>User Name</td></tr>");
		for( String[] row: list)
		{
			out.println("<tr>");
		    for( String s: row )
			{
		        out.println( "<td> " + s + "</td>" );
		    } 
		    out.println("</tr>");
		}
		out.println("</table>");
	}
	if("Query3".equals(query))
	{
		out.println("<table border =\"1\"> ");
		out.println("<tr><td>Account Number</td></tr>");
		for( String[] row: list)
		{
			out.println("<tr>");
		    for( String s: row )
			{
		        out.println( "<td> " + s + "</td>" );
		    } 
		    out.println("</tr>");
		}
		out.println("</table>");
	}
	if("Query4".equals(query))
	{
		out.println("<table border =\"1\"> ");
		out.println("<tr><td>User Id</td><td>User Name</td><td>Account Number</td></tr>");
		for( String[] row: list)
		{
			out.println("<tr>");
		    for( String s: row )
			{
		        out.println( "<td> " + s + "</td>" );
		    } 
		    out.println("</tr>");
		}
		out.println("</table>");
	}
	if("Query5".equals(query))
	{
		out.println("<table border =\"1\"> ");
		out.println("<tr><td>Total Balance</td></tr>");
		for( String[] row: list)
		{
			out.println("<tr>");
		    for( String s: row )
			{
		        out.println( "<td> " + s + "</td>" );
		    } 
		    out.println("</tr>");
		}
		out.println("</table>");
	}
}
%>
</body>
</html>