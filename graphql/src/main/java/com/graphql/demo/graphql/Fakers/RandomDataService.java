package com.graphql.demo.graphql.Fakers;

import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;

@Service
public class RandomDataService {
    private final Faker faker = new Faker();

    public String generateRandomName() {
        return faker.name().fullName(); // Generates a random full name
    }

    public String generateRandomPhoneNumber() {
        return faker.phoneNumber().phoneNumber(); // Generates a random phone number
    }

    public String generateRandomEmail() {
        return faker.internet().emailAddress(); // Generates a random email address
    }
}
