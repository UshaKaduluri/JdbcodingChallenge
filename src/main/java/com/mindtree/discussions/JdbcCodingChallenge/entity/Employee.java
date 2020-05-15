package com.mindtree.discussions.JdbcCodingChallenge.entity;

public class Employee {
	private int id;
	private String name;
	private String role;
	private double phoneNo;
	private int projectId;

	public Employee(int id, String name, String role, double phoneNo, int projectId) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.phoneNo = phoneNo;
		this.projectId = projectId;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(double phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

}
