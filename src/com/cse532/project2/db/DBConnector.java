/****************************************************************************
Brief description: It is used to connect to the desired Database.
****************************************************************************/

package com.cse532.project2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector 
{

	 public Connection createConnection() throws ClassNotFoundException
	 {
		 Class.forName("org.postgresql.Driver");
		 Connection conn = null;
		 
	        try 
	        {
	            String dbURL = "jdbc:postgresql:postgres?user=postgres&password=shweta2210";
	            conn = DriverManager.getConnection(dbURL);
	            if (conn != null) 
	            {
	                System.out.println("Connected to database");
	            }
	            else
	            {
	            	System.out.println("Connection is null");
	            }
	 
	        } 
	        catch (SQLException ex) 
	        {
	            ex.printStackTrace();
	        } 
	        return conn;
	 }
}
