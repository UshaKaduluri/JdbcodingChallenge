package com.mindtree.discussions.JdbcCodingChallenge.entity;

public class Project {

	private int id;
	private String name;

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

	public Project(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Project() {
		super();
	}

}
