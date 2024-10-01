package br.com.sitelease.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.sitelease.model.Person;

@Service
public class PersonServices{

	private final AtomicLong count = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll(){
		logger.info("Finding all people");
		List<Person> persons = new ArrayList<>();
		for(long i = 1; i <= 8 ; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}
	
	public Person findById(String id) {
		logger.info("Finding one Person!");
		
		Person person = new Person();
		
		person.setId(count.incrementAndGet());
		person.setFirstName("Gabriel");
		person.setLastName("Avelino Amorim");
		person.setAddress("Florianópolis - SC - Brasil");
		person.setGender("Male");
		
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creatiing one Person!");
		
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Update one Person!");
		
		return person;
	}
	
	public void delete(String id ) {
		logger.info("Deleting one Person!");
	}
	
	private Person mockPerson(long i) {
		Person person = new Person();
		
		person.setId(count.incrementAndGet());
		person.setFirstName("Fist-Name" + i);
		person.setLastName("Last-Name" + i);
		person.setAddress("Cidade e Estado" + i);
		if(i % 2 == 0) {
			person.setGender("Male");
		}
		else {
			person.setGender("Female");
		}
		return person;
	}

}
