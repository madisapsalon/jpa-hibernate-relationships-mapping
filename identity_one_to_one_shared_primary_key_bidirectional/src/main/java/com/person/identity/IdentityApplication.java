package com.person.identity;

import com.person.identity.entity.IDCard;
import com.person.identity.entity.Person;
import com.person.identity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class IdentityApplication implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(IdentityApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Tom", new IDCard()));
		persons.add(new Person("Daisy", new IDCard()));
		persons.add(new Person("Alex", new IDCard()));
		personRepository.saveAll(persons);
	}
}
