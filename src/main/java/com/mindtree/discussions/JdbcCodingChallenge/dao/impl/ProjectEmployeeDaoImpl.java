package com.mindtree.discussions.JdbcCodingChallenge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.discussions.JdbcCodingChallenge.dao.ProjectEmployeeDao;
import com.mindtree.discussions.JdbcCodingChallenge.entity.Employee;
import com.mindtree.discussions.JdbcCodingChallenge.entity.Project;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.DaoException;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.InsertionFailureException;
import com.mindtree.discussions.JdbcCodingChallenge.utility.ConnectionClass;

public class ProjectEmployeeDaoImpl implements ProjectEmployeeDao{
	ConnectionClass connection = new ConnectionClass();
	Connection con = null;

	public void insertEmployee(Employee employee) throws DaoException {
		try {
			con = connection.getConnection();
			String query = "insert into employee values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getRole());
			pstmt.setDouble(4, employee.getPhoneNo());
			pstmt.setInt(5, employee.getProjectId());
			pstmt.executeUpdate();
		} catch (InsertionFailureException e) {
			throw new DaoException("Insertion Failed in Dao Layer", e);
		} catch (SQLException e) {
			throw new InsertionFailureException("Insertion Failed in Dao Layer", e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DaoException("Connection not closed");
			}
		}
	}

	public List<Employee> retriveEmployees() throws DaoException {
		con = connection.getConnection();
		List<Employee> employee = new ArrayList<Employee>();
		ResultSet result;
		try {
			String query = "select * from employee";
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(query);

			while (result.next())
				employee.add(new Employee(result.getInt("id"), result.getString("employeeName"),
						result.getString("role"), result.getDouble("phoneNo"), result.getInt("projectId")));
		} catch (SQLException e) {
			throw new DaoException("Insertion Failed in Dao Layer", e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DaoException("Connection not closed");
			}
		}
		return employee;
	}
	
	public List<Project> retriveProjects() throws DaoException {
		con = connection.getConnection();
		List<Project> project = new ArrayList<Project>();
		ResultSet result;
		try {
			String query = "select * from project";
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(query);

			while (result.next())
				project.add(new Project(result.getInt("id"), result.getString("projectName")));
		} catch (SQLException e) {
			throw new DaoException("Insertion Failed in Dao Layer", e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DaoException("Connection not closed");
			}
		}
		return project;
	}

}
