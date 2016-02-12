/****************************************************************************
Brief description: This is the data access object that executes the desired query on the connected database and returns the result set for further processing.
****************************************************************************/

package com.cse532.project2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Project2_Dao 
{
	public ResultSet getDataforQuery1(Connection conn) throws SQLException, ClassNotFoundException 
	{
		ResultSet result;
		String query = "SELECT A.id, A.name, S.id, S.name FROM Organization O, UNNEST(O.signatureAuthority) S, CreditCard C, UNNEST(C.authorizedUsers) A WHERE C.ownerId=O.id AND C.balance>=C.credit_limit-1000";
		result = getData(conn,query);
		return result;
	}

	public ResultSet getDataForQuery2(Connection conn) throws SQLException, ClassNotFoundException 
	{
		ResultSet result;
		String query = "SELECT P.Id, P.Name FROM Person P WHERE P.Id IN (SELECT OwnerId FROM CreditCard GROUP BY OwnerId HAVING COUNT(*) >= 4) AND P.Id IN (SELECT P.Id FROM Person P, AuthorizedUser A WHERE P.Id = A.Id GROUP BY P.Id HAVING COUNT(A.ActNo) >= 3)";
		result = getData(conn,query);
		return result;
	}
	
	public ResultSet getDataForQuery3(Connection conn) throws SQLException, ClassNotFoundException 
	{
		ResultSet result;
		String query = "SELECT C1.actNo FROM CreditCard C1, Organization O WHERE C1.ownerId=O.id AND NOT EXISTS(SELECT S.id FROM UNNEST(O.signatureAuthority) S, CreditCard C WHERE C.ownerId=S.id AND C.credit_limit<25000)";
		result = getData(conn,query);
		return result;
	}
	
	public ResultSet getDataForQuery4(Connection conn) throws SQLException, ClassNotFoundException 
	{
		ResultSet result;

		// Recursive view already created in Database with following query and hence performing only SELECT here:
		// CREATE RECURSIVE VIEW IndirectUser (Id, Name, ActNo) AS (SELECT * FROM AuthorizedUser UNION SELECT P.Id, P.Name, I.ActNo 
		// FROM Person P, AuthorizedUser A, CreditCard C, IndirectUser I WHERE P.Id = A.Id AND A.ActNo = C.ActNo AND C.OwnerId = I.Id);
		String query = "SELECT * FROM IndirectUser";
		result = getData(conn,query);
		return result;
	}
	
	public ResultSet getDataForQuery5(Connection conn) throws SQLException, ClassNotFoundException 
	{
		String query = "SELECT SUM(C.balance) FROM CreditCard C, IndirectUser R, Person P WHERE P.name='Joe' AND P.id=R.id AND R.actNo=C.actNo";
		ResultSet result = getData(conn,query);
		return result;
	}

	private ResultSet getData(Connection conn, String query) throws SQLException 
	{
		ResultSet result;
		Statement statement = null;
		statement = conn.createStatement();
	    result = statement.executeQuery(query);
		try 
		{
			if (conn != null && !conn.isClosed()) 
			{
				conn.close();
			}
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		return result;
	}
	
}
