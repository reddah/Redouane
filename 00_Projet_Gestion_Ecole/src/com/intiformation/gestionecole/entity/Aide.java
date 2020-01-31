package com.intiformation.gestionecole.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author IN-BR-020
 *
 */

@Entity(name = "aide")
@Table(name="aides")
@NamedQueries({@NamedQuery(name="Aide_getAll", query="SELECT a FROM aide a"), 
	           @NamedQuery(name="Aide_getAllContenu", query="SELECT a.contenu FROM aide a"),
               @NamedQuery(name="Aide_getById", query="SELECT a FROM aide a WHERE a.page = :pID")})
public class Aide implements Serializable {
	/* ____________ Props ____________ */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Page")
	private int page;
	@Column(name="Contenu")
	private String contenu;

	/* ____________ Ctor ____________ */

	public Aide() {
		super();
	}

	public Aide(int page, String contenu) {
		super();
		this.page = page;
		this.contenu = contenu;
	}

	public Aide(String contenu) {
		super();
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "Aide [page=" + page + ", contenu=" + contenu + "]";
	}

	/* ____________ getters/setters ____________ */

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}// Fin de la classe Aide
