package com.securityhope.hope;

import com.securityhope.hope.domain.Role;
import com.securityhope.hope.domain.User;
import com.securityhope.hope.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class HopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopeApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Kim hope", "kim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Park juhong", "park", "2345", new ArrayList<>()));
			userService.saveUser(new User(null, "Yun taebin", "yun", "3456", new ArrayList<>()));
			userService.saveUser(new User(null, "chae jongin", "chae", "4567", new ArrayList<>()));

			userService.addRoleToUser("kim", "ROLE_USER");
			userService.addRoleToUser("park", "ROLE_MANAGER");
			userService.addRoleToUser("yun", "ROLE_ADMIN");

			userService.addRoleToUser("chae", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("chae", "ROLE_MANAGER");
			userService.addRoleToUser("chae", "ROLE_ADMIN");
		};
	}

}
