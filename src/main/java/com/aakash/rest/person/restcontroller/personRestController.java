package com.aakash.rest.person.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.rest.person.model.Person;
import com.aakash.rest.person.service.PersonService;


@RestController
@RequestMapping("/person")
public class personRestController {
	
	@Autowired
    PersonService personService;
	
	@GetMapping(value="/getAllPerson")
	public ResponseEntity<List<Person>> getAllPerson() {
		
		List<Person> persons = personService.getAllPerson();
		
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);

	}
	
	@GetMapping(value="/get/personById/{id}")
	public ResponseEntity<Person> getPersonbyId(@PathVariable int id) {
		
		if(!personService.isUserExist(id)) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		Person person = personService.findById(id);
		 return new ResponseEntity<Person>(person, HttpStatus.OK);

	}
	
	@PostMapping(value="/create")
	public ResponseEntity<Void> createPerson(@RequestBody Person person) {
		
	 personService.createPerson(person);
	 return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Void> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
		if(!personService.isUserExist(id)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		personService.updatePerson(person);
		 return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

	@PutMapping(value="/updateBio/{id}")
	public ResponseEntity<Void> updatePersonBio(@PathVariable("id") int id, @RequestBody String bio) {
		if(!personService.isUserExist(id)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		personService.updatePersonBio(id, bio);
		 return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PutMapping(value="/updatePassword/{id}")
	public ResponseEntity<Void> updatePersonPassword(@PathVariable("id") int id, @RequestBody String password) {
		if(!personService.isUserExist(id)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		personService.updatePersonPassword(id, password);
		 return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value="/delete/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable("id") int id, @RequestBody String password) {
		if(!personService.isUserExist(id)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		personService.deletePersonById(id);
		 return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
