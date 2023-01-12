package com.example.UserService;

import com.example.UserService.domain.AppUser;
import com.example.UserService.domain.AppUserRole;
import com.example.UserService.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	@Bean
  CommandLineRunner run (
		AppUserService userService){
	return args -> {
	    userService.saveRole(new AppUserRole( 1,"ROLE_USER"));
		userService.saveRole(new AppUserRole( 2,"ROLE_MANAGER"));
		userService.saveRole(new AppUserRole( 3,"ROLE_ADMIN"));
		userService.saveRole(new AppUserRole( 4,"ROLE_SUPPER_ADMIN"));

		userService.saveUser((new AppUser(1,"meryem hassine","meryem","hassinemeryem@gmail.com","124578",new ArrayList<>())));
		userService.saveUser((new AppUser(2,"aza hassine","aza","hassineaza@gmail.com","124578",new ArrayList<>())));
		userService.saveUser((new AppUser(3,"seif hassine","seif","hassineseif@gmail.com","124578",new ArrayList<>())));
		userService.saveUser((new AppUser(4,"ala hassine","ala","hassineala@gmail.com","124578",new ArrayList<>())));

		AppUserService.addRoleToUser("ROLE_USER","meryem hassine");
		AppUserService.addRoleToUser("ROLE_MANAGER","aza hassine");
		AppUserService.addRoleToUser("ROLE_ADMIN","seif hassine");
		AppUserService.addRoleToUser("ROLE_SUPPER_ADMIN","ala hassine");

	};
}
}



