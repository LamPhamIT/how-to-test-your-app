package com.shinn.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class HowToTestYourAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowToTestYourAppApplication.class, args);
	}

}
