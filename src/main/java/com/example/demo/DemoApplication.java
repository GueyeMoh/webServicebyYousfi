package com.example.demo;

import java.util.Date;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.*;
import com.example.demo.repository.CompteRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean 
	CommandLineRunner start(CompteRepository compteRep) {
		return args -> {
			compteRep.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT));
			compteRep.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT));
			compteRep.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE));
			compteRep.findAll().forEach(c->{
				System.out.println(c.toString());
			});
		};
	}

}
