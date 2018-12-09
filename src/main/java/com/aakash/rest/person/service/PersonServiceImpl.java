package com.aakash.rest.person.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aakash.rest.person.model.Person;
import com.aakash.rest.person.repository.PersonRepository;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	private List<Person> persons;
	@Autowired
	private PersonRepository personRepository;

	@PostConstruct
	public void laodData() {
		persons = new ArrayList<>();

		persons.add(new Person(1, "Akash", "prajapatfads", "abc@xyz.com", 2, "IT", "akash1234"));
		persons.add(new Person(2, "Akash12", "prajapatewqr", "abc@xyz.com", 2, "IT", "akash12345"));
		persons.add(new Person(3, "Akash23", "prajapatfasd", "abc@xyz.com", 2, "IT", "akash12346"));
		persons.add(new Person(4, "Akash334", "prajapatfsdaf", "abc@xyz.com", 2, "IT", "akash12347"));
		persons.add(new Person(5, "Akash43", "prajapatfsdfs", "abc@xyz.com", 2, "IT", "akash12348"));
	}

	@Override
	public List<Person> getAllPerson() {

		return personRepository.getAllPerson();
	}

	@Override
	public Person findById(int id) {

		return personRepository.getPersonById(id);
	}

	@Override
	public void createPerson(Person person) {
		personRepository.createPerson(person);
	}

	@Override
	public void updatePerson(Person person) {
		personRepository.updatePerson(person);
	}

	@Override
	public void updatePersonBio(int id, String bio) {
		personRepository.updatePersonBio(id, bio);
	}

	@Override
	public void updatePersonPassword(int id, String password) {
		personRepository.updatePersonPassword(id, password);

	}

	@Override
	public void deletePersonById(int id) {
		personRepository.deletePerson(id);

	}

	@Override
	public boolean isUserExist(int id) {
		Person p = new Person();
		p.setId(id);
		return getAllPerson().contains(p);

	}

}
