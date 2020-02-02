package com.intiformation.gestionecole.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "administrateur")
@Table(name="administrateurs")
@NamedQueries({@NamedQuery(name="Administrateur_getAll", query="SELECT ad FROM administrateur ad"), 
               @NamedQuery(name="Administrateur_getById", query="SELECT ad FROM administrateur ad WHERE ad.identifiant = :pID")})
public class Administrateur extends Personne {

	/* ____________ Props ____________ */

	/* ____________ Ctor ____________ */

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	public Administrateur(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super(identifiant, motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String motDePasse, String nom, String prenom, String email) {
		super(motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

	/* ____________ getters/setters ____________ */

}// Fin de la classe Administrateur
