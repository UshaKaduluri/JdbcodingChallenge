package com.mindtree.discussions.JdbcCodingChallenge.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.discussions.JdbcCodingChallenge.dao.ProjectEmployeeDao;
import com.mindtree.discussions.JdbcCodingChallenge.dao.impl.ProjectEmployeeDaoImpl;
import com.mindtree.discussions.JdbcCodingChallenge.entity.Employee;
import com.mindtree.discussions.JdbcCodingChallenge.entity.Project;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.DaoException;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.InvalidRoleException;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.ManagerExistsException;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.ManagerNotExistsException;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.ServiceException;
import com.mindtree.discussions.JdbcCodingChallenge.service.ProjectEmployeeService;

public class ProjectEmployeeServiceImpl implements ProjectEmployeeService {

	ProjectEmployeeDao projectEmployeeDao = new ProjectEmployeeDaoImpl();

	public int addEmployee(Employee employee) throws ServiceException {

		int success = -1;
		try {
			List<Employee> employees = projectEmployeeDao.retriveEmployees();
			if (employee.getRole().equalsIgnoreCase("manager") || employee.getRole().equalsIgnoreCase("developer")
					|| employee.getRole().equalsIgnoreCase("tester"))
			{
				if (employee.getRole().equalsIgnoreCase("manager")) {
					for (Employee employeeList : employees) {
						if (employeeList.getRole().equalsIgnoreCase("manager")
								&& employeeList.getProjectId() == employee.getProjectId())
							throw new ManagerExistsException(
									"Manager already present for project: " + employee.getId());
					}
				}
			projectEmployeeDao.insertEmployee(employee);
			}else
				throw new InvalidRoleException("Role must be 'Manager'/'Tester'/'Developer'");
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return success;

	}

	public List<Employee> getEmployeesInProjectByManagerName(String managerName) throws ServiceException {
		List<Employee> result = new ArrayList<Employee>();
		int projectId = -1;
		List<Employee> employees = null;
		boolean managerExists = false;
		try {
			employees = projectEmployeeDao.retriveEmployees();
			for (Employee employeeList : employees) {
				if (employeeList.getName().equalsIgnoreCase(managerName)
						&& employeeList.getRole().equalsIgnoreCase("manager")) {
					projectId = employeeList.getProjectId();
					managerExists = true;
				}
			}

		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		if (managerExists) {
			for (Employee employeeList : employees) {
				if (employeeList.getProjectId() == projectId && !employeeList.getRole().equalsIgnoreCase("manager")) {
					result.add(employeeList);
				}
			}
		} else {
			throw new ManagerNotExistsException("Manager with name: " + managerName + " doesn't exist");
		}
		return result;

	}

}
