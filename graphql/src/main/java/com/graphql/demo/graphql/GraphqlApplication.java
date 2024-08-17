package com.graphql.demo.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.graphql.demo.graphql.Core.IStudentRepository;
import com.graphql.demo.graphql.Database.Student;
import com.graphql.demo.graphql.Fakers.RandomDataService;

@SpringBootApplication
@EnableMongoRepositories
public class GraphqlApplication implements CommandLineRunner {
	@Autowired
	IStudentRepository studentRepository;
	@Autowired
	private RandomDataService randomDataService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		createGroceryItems(studentRepository, randomDataService);
	}

	// CREATE
	void createGroceryItems(IStudentRepository studentRepository, RandomDataService randomDataService) {
		try {
			System.out.println("Data creation started...");
			studentRepository.save(new Student(randomDataService.generateRandomName(),
					randomDataService.generateRandomPhoneNumber(), randomDataService.generateRandomEmail()));

			System.out.println("Data creation complete...");
		} catch (Exception ex) {

			System.out.println("Exception " + ex.toString());
		}
	}
}
