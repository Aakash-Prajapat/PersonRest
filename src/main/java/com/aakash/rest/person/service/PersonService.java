package com.aakash.rest.person.service;

import java.util.List;

import com.aakash.rest.person.model.Person;

public interface PersonService {

	List<Person> getAllPerson();

	Person findById(int id);

	void createPerson(Person person);

	void updatePerson(Person person);

	void updatePersonBio(int id, String bio);

	void updatePersonPassword(int id, String password);

	void deletePersonById(int id);

	boolean isUserExist(int id);

}
