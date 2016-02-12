/****************************************************************************
Brief description: This is the facade layer that first calls the dabase connector to connect to database and then calls dao to get query results. The result
sets are processed to be returned to servlet in for of 2D arraylist.
****************************************************************************/

package com.cse532.project2.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cse532.project2.dao.Project2_Dao;
import com.cse532.project2.db.DBConnector;

public class Project2_Facade 
{
	Project2_Dao dao = new Project2_Dao();

	// method to connect to database
	private Connection createDBConnection() throws ClassNotFoundException
	{
		DBConnector connector = new DBConnector();
		Connection conn = connector.createConnection();
		return conn;
	}

	// method to convert result set into 2D arraylist.
	private List<String[]> convertResultToArray(ResultSet result) throws SQLException
	{
		int nCol = result.getMetaData().getColumnCount();
		List<String[]> records = new ArrayList<>();
		while( result.next()) 
		{
		    String[] row = new String[nCol];
		    for( int iCol = 1; iCol <= nCol; iCol++ )
			{
		        row[iCol-1] = result.getObject( iCol ).toString();
		    }
		    records.add( row );
		}

		return records;
	}
	
	public List<String[]> getDataForQuery1() throws ClassNotFoundException, SQLException
	{
		Connection conn = createDBConnection();
		ResultSet result = dao.getDataforQuery1(conn);
		List<String[]> records = convertResultToArray(result);
		return records;
	}
	
	public List<String[]> getDataForQuery2() throws ClassNotFoundException, SQLException
	{
		Connection conn = createDBConnection();
		ResultSet result = dao.getDataForQuery2(conn);
		List<String[]> records = convertResultToArray(result);
		return records;
	}
	
	public List<String[]> getDataForQuery3() throws ClassNotFoundException, SQLException
	{
		Connection conn = createDBConnection();
		ResultSet result = dao.getDataForQuery3(conn);
		List<String[]> records = convertResultToArray(result);
		return records;
	}
	
	public List<String[]> getDataForQuery4() throws ClassNotFoundException, SQLException
	{
		Connection conn = createDBConnection();
		ResultSet result = dao.getDataForQuery4(conn);
		List<String[]> records = convertResultToArray(result);
		return records;
	}
	
	public List<String[]> getDataForQuery5() throws ClassNotFoundException, SQLException
	{
		Connection conn = createDBConnection();
		ResultSet result = dao.getDataForQuery5(conn);
		List<String[]> records = convertResultToArray(result);
		return records;
	}

}
