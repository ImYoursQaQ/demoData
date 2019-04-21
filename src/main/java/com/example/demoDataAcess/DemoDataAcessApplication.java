package com.example.demoDataAcess;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoDataAcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDataAcessApplication.class, args);
	}
}
