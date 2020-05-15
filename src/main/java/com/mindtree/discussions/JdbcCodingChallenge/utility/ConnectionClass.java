package com.mindtree.discussions.JdbcCodingChallenge.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.discussions.JdbcCodingChallenge.exceptions.InsertionFailureException;


public class ConnectionClass {
	Connection con;
	String ULR = "jdbc:mysql://localhost:3306/projectEmployee";
	String user = "root";
	String password = "Welcome123";
	public Connection getConnection() throws InsertionFailureException
	{
	try {
		con = DriverManager.getConnection(ULR, user, password);
	} catch (SQLException e) {
		throw new InsertionFailureException("Insertion Failed in Connection Class",e);
	}
	return con;
	}
}
