package com.ex.vigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ex.vigo.entities"})
public class VigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VigoApplication.class, args);
	}

}
