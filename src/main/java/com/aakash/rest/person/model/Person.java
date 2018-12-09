package com.aakash.rest.person.model;

public class Person {
	
	private int id;
	private String name;
	private String bio;
	private String email;
	private int teamid;
	private String department;
	private String password;
	
	public Person() {
		
	}

	public Person(int id, String name, String bio, String email, int teamid, String department, String password) {
		this.id = id;
		this.name = name;
		this.bio = bio;
		this.email = email;
		this.teamid = teamid;
		this.department = department;
		this.password = password;
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTeamid() {
		return teamid;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	/*public String getPassword() {
		return password;
	}*/

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	
	

}
