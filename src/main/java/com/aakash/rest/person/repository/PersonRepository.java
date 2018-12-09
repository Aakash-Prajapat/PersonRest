package com.aakash.rest.person.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aakash.rest.person.mapper.PersonMapper;
import com.aakash.rest.person.model.Person;

@Repository("personRepository")
public class PersonRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String SQL_GET_ALL = "select * from person";

	private final String SQL_FIND_PERSON = "select * from person where id = ?";

	private final String SQL_INSERT_PERSON = "insert into person(id, name, bio, email, teamid, "
			+ "department, password) values(?,?,?,?,?,?,?)";

	private final String SQL_UPDATE_PERSON = "update person set name = ?, bio = ?, email  = ?,  "
			+ "teamid = ?, department = ?, password  = ? " + "where id = ?";

	private final String SQL_UPDATE_PERSON_BIO = "update person set bio = ? where id = ?";

	private final String SQL_UPDATE_PERSON_PASSWORD = "update person set password  = ? " + "where id = ?";

	private final String SQL_DELETE_PERSON = "delete from person where id = ?";

	public List<Person> getAllPerson() {

		return jdbcTemplate.query(SQL_GET_ALL, new PersonMapper());
	}

	public Person getPersonById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new PersonMapper());
	}
	
	public boolean createPerson(Person person) {
		return jdbcTemplate.update(SQL_INSERT_PERSON, person.getId(), person.getName(), person.getBio(),
				person.getEmail(), person.getTeamid(), person.getDepartment(),person.getPassword()) > 0;
	}
	
	public boolean updatePerson(Person person) {
		return jdbcTemplate.update(SQL_UPDATE_PERSON, person.getId(), person.getName(), person.getBio(),
				person.getEmail(), person.getTeamid(), person.getDepartment(),person.getPassword(),person.getId()) > 0;
	}
	
	public boolean updatePersonBio(int id, String bio) {
		return jdbcTemplate.update(SQL_UPDATE_PERSON_BIO,bio, id) > 0;
	}
	
	public boolean updatePersonPassword(int id, String password) {
		return jdbcTemplate.update(SQL_UPDATE_PERSON_BIO,password, id) > 0;
	}
	
	
	public boolean deletePerson(int id) {
		return jdbcTemplate.update(SQL_DELETE_PERSON, id)>0;
	}
	

}
