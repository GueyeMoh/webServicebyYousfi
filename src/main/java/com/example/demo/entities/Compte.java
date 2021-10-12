package com.example.demo.entities;

import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString; 


@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @ToString //grace à lombok
public class Compte {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	public Compte(Long id, double solde, Date dateCreation, TypeCompte type) {
		super();
		this.id = id;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.type = type;
	}
	public Compte() {
		
	}
	private double solde;
	@Temporal(TemporalType.DATE)
	private Date dateCreation; 
	@Enumerated(EnumType.ORDINAL)
	private TypeCompte type;
	public void setId(Long id2) {
		this.id = id2;
		
	} 
}
