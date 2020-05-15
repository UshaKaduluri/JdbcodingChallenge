package com.mindtree.discussions.JdbcCodingChallenge.dao;

import java.util.List;

import com.mindtree.discussions.JdbcCodingChallenge.entity.Employee;
import com.mindtree.discussions.JdbcCodingChallenge.entity.Project;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.DaoException;

public interface ProjectEmployeeDao {

	public void insertEmployee(Employee employee) throws DaoException;
	public List<Employee> retriveEmployees() throws DaoException;
	public List<Project> retriveProjects() throws DaoException;

}
