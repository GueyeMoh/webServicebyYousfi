package com.example.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.demo.web.CompteRestApi;

@Configuration 
public class ConfigCompte {

	@Bean //pour que la méthode s'exécute au démarrage 
	public ResourceConfig resConf () {
		ResourceConfig resConfig = new ResourceConfig(); 
		resConfig.register(CompteRestApi.class);
		return resConfig; 
	}
}
