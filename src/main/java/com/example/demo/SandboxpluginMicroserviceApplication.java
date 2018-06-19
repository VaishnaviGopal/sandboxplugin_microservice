package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"controller"})
@Controller

public class SandboxpluginMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxpluginMicroserviceApplication.class, args);
	}
}
