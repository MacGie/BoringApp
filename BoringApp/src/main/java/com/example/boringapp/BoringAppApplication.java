package com.example.boringapp;

import com.example.boringapp.Repository.ActivityRepository;
import com.example.boringapp.service.ActivityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class BoringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoringAppApplication.class, args);
	}

}
