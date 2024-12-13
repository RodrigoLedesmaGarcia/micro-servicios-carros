package com.rodrigo.www.concesionaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConcesionariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcesionariaApplication.class, args);
	}

}
