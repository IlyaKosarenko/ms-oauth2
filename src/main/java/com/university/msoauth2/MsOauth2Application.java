package com.university.msoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MsOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(MsOauth2Application.class, args);
	}

}
