package com.hoya.webservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing // JPA Auditing
@SpringBootApplication
public class Application {
	
	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.yml,"
			+ "SpringBootFolder/app/config/spring-webservice/real-application.yml";

	public static void main(String[] args) {
		
//		SpringApplication.run(Application.class, args);
		
		new SpringApplicationBuilder(Application.class)
			.properties(APPLICATION_LOCATIONS)
			.run(args);
	}
}
