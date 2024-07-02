package com.matheusparro.desafio_java_pleno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DesafioJavaPlenoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioJavaPlenoApplication.class, args);
	}

}
