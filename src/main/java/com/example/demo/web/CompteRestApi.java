package com.example.demo.web;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Compte;
import com.example.demo.repository.CompteRepository;

//On va faire le service avec JaxRS 

@Component // pour dire que c un composant spring 
@Path("/banque")
public class CompteRestApi {
	
	@Autowired
	private CompteRepository compteRep; 
	
	
	@Path("/comptes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> compteList(){
		return compteRep.findAll();
	}
	
	@Path("/comptes/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Compte unCompte(@PathParam(value = "id") Long id) {
		return compteRep.findById(id).get();
		}
	
	@Path("/comptes")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Compte ajouter(Compte compte){
		return compteRep.save(compte);
	}
	
	@Path("/comptes/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Compte udpdateCompte(Compte compte, @PathParam("id") Long id){
		compte.setId(id); 
		return compteRep.save(compte);
	}
	
	@Path("/comptes/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void supprimer(@PathParam("id") Long id){
		
		compteRep.deleteById(id);
	}
}
