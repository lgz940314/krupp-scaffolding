package com.krupp.scaffolding.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KruppEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KruppEurekaApplication.class, args);
	}

}
