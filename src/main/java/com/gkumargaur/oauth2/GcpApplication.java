package com.gkumargaur.oauth2;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PropertySource("classpath:default-application.properties")
@SpringBootApplication
@RestController
public class GcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcpApplication.class, args);
	}
	
	@RequestMapping(value = "/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
