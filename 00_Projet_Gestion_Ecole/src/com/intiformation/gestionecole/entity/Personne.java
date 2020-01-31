package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class Personne implements Serializable {
	/* ____________ Props ____________ */
	protected int identifiant;
	protected String motDePasse;
	protected String nom;
	protected String prenom;
	protected String email;

	/* ____________ Ctor ____________ */

	public Personne() {
		super();
	}

	public Personne(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Personne [identifiant=" + identifiant + ", motDePasse=" + motDePasse + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + "]";
	}

	/* ____________ getters/setters ____________ */

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}// Fin de la classe Personne