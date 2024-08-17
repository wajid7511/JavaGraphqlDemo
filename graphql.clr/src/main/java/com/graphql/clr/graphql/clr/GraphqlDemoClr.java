package com.graphql.clr.graphql.clr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GraphqlDemoClr {
	private static final Logger LOG = LoggerFactory.getLogger(GraphqlDemoClr.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			LOG.info("Start");
			for (int i = 1; i <= 100; i++) {
				if (i % 15 == 0) {
					LOG.info(i + " is FizzBuzz");
				} else if (i % 3 == 0) {
					LOG.info(i + " is Fizz");
				} else if (i % 5 == 0) {
					LOG.info(i + " is Buzz");
				} else {
					LOG.info(i + " is " + i);
				}
			}
			LOG.info("Stop");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoClr.class, args);
	}

}
