package com.mindtree.discussions.JdbcCodingChallenge;

import java.util.InputMismatchException;
import java.util.List;

import com.mindtree.discussions.JdbcCodingChallenge.entity.Employee;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.ServiceException;
import com.mindtree.discussions.JdbcCodingChallenge.exceptions.WrongInputException;
import com.mindtree.discussions.JdbcCodingChallenge.service.ProjectEmployeeService;
import com.mindtree.discussions.JdbcCodingChallenge.service.impl.ProjectEmployeeServiceImpl;
import com.mindtree.discussions.JdbcCodingChallenge.utility.ScannerClass;

/**
 * Hello world!
 *
 */
public class App {
	static ScannerClass scanner = new ScannerClass();

	public static void main(String[] args) {
		ProjectEmployeeService projectEmployeeService = new ProjectEmployeeServiceImpl();

		int option = -1;

		do {

			System.out
					.println("Choose an option:\n1.Add Employee\n2.Retrive Employees under particular manager\n3.Exit");

			option = scanner.scanInt();
			switch (option) {
			case 1:
				try {
					Employee employee = loadEmployee();
					projectEmployeeService.addEmployee(employee);
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				} catch (WrongInputException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter project manager name: ");
				String managerName = scanner.scanString();
				List<Employee> employeesList;
				try {
					employeesList = projectEmployeeService.getEmployeesInProjectByManagerName(managerName);
					printEmployees(employeesList);
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:
				System.exit(0);
			}

		} while (option <= 3);

	}

	private static void printEmployees(List<Employee> employeesList) {
		System.out.println("Employees are:");
		System.out.println("*****************************************************************************************");
		for (Employee employee : employeesList) {
			System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getRole() + "\t"
					+ employee.getProjectId());
		}
		System.out.println("*****************************************************************************************");
	}

	private static Employee loadEmployee() throws WrongInputException {
		try {
			System.out.println("Enter employee id: ");
			int id = scanner.scanInt();
			System.out.println("Enter employee name: ");
			String employeeName = scanner.scanString();
			System.out.println("Enter role: ");
			String role = scanner.scanString();
			System.out.println("Enter phone number: ");
			double phoneNumber = scanner.scanDouble();
			System.out.println("Enter project id: ");
			int projectId = scanner.scanInt();
			return new Employee(id, employeeName, role, phoneNumber, projectId);
		} catch (InputMismatchException e) {
			throw new WrongInputException("Please enter the correct input....");
		}

	}
}
