package com.mindtree.discussions.JdbcCodingChallenge.service;

import java.util.List;

import com.mindtree.discussions.JdbcCodingChallenge.entity.Employee;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.ServiceException;

public interface ProjectEmployeeService {
	
	public int addEmployee(Employee employee) throws ServiceException;
	public List<Employee> getEmployeesInProjectByManagerName(String managerName) throws ServiceException;
	

}
