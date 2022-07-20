package com.security.userService;

import com.security.userService.model.AppUser;
import com.security.userService.model.UserRole;
import com.security.userService.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@ComponentScan(basePackages = {"com.securitymodule"})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new UserRole(null, "ROLE_USER"));
			userService.saveRole(new UserRole(null, "ROLE_MANAGER"));
			userService.saveRole(new UserRole(null, "ROLE_ADMIN"));

			userService.saveUser(new AppUser(null, "John Wick", "john", "john123", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Ana De Armas", "Ana", "ana123", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Ben Affleck", "Ben", "ben123", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Vikram", "vikram", "vikram123", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("Ben", "ROLE_USER");
			userService.addRoleToUser("vikram", "ROLE_USER");
			userService.addRoleToUser("vikram", "ROLE_MANAGER");
			userService.addRoleToUser("Ana", "ROLE_MANAGER ");
			userService.addRoleToUser("vikram", "ROLE_ADMIN");
		};
	}
}
