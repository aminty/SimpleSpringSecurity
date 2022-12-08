package com.simple.springSecurity;

import com.simple.springSecurity.domain.User;
import com.simple.springSecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}


@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args -> {
			userRepository.save(new User("user","1234","ROLE_USER"));
			userRepository.save(new User("admin","1234","ROLE_USER,ROLE_ADMIN"));
		};
}
}
