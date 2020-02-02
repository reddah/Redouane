package com.intiformation.gestionecole.test;

import com.intiformation.gestionecole.dao.AdministrateurDaoImpl;
import com.intiformation.gestionecole.entity.Administrateur;

public class AppTestAdministrateur {

	public static void main(String[] args) {

		/*==============================================================*/
		/*=================== Ajouter Administrateur ===================*/
		/*==============================================================*/
		
		// administrateur à ajouter
		Administrateur administrateur = new Administrateur("mdp123","AdminNom","AdminPrenom","admin@admin.com");
		
		// DAO
		AdministrateurDaoImpl administrateurDao = new AdministrateurDaoImpl();
		
		// Ajout
		administrateurDao.ajouter(administrateur);
		
		// Affichage
		System.out.println("Ajout des administrateurs : ++++++++++++++++++++++++++++++++++++");
		System.out.println("\t > " + administrateur);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		
		
		/* ============================================================== */
		/* ================== Get By IdAdministrateur =================== */
		/* ============================================================== */
		
		System.out.println("Get by id ++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t > ID : " + administrateurDao.getById(2).getIdentifiant());
		System.out.println("\t > Email : " + administrateurDao.getById(2).getEmail());
		System.out.println("\t > Mot de passe : " + administrateurDao.getById(2).getMotDePasse());
		System.out.println("\t > Nom : " + administrateurDao.getById(2).getNom());
		System.out.println("\t > Prenom : " + administrateurDao.getById(2).getPrenom());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		
		System.out.println("Get by id toString ++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t > " + administrateur.toString());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		
		
		
		System.out.println("\t > Prenom : " + administrateurDao.getById(2).getPrenom());
		
		
		/* ============================================================== */
		/* ================= Modifier Administrateur ==================== */
		/* ============================================================== */
		
		System.out.println("UPDATE +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		administrateur = new Administrateur("mdp000","AdminNom1","AdminPrenom1","admin1@admin.com");
		administrateurDao.modifier(3, administrateur);
		System.out.println("\t > Aprés update : ");
		Administrateur a = administrateurDao.getById(3);
		System.out.println("\t\t > id = : " + administrateur.toString());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		
		/* ============================================================== */
		/* ================== Supprimer Administrateur ================== */
		/* ============================================================== */
		
		System.out.println("DELETE ++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		//administrateurDao.supprimerAdministrateur(5);
		
		
		/* ============================================================== */
		/* ================== Get all Administrateur ==================== */
		/* ============================================================== */
		
		System.out.println("Get All Administrateurs ===================================");	
		for (Administrateur administrateur1 : administrateurDao.getAll()) {
			System.out.println("\t > " + administrateur1.toString());
		}
		
		System.out.println("===================================================================\n");
		

		
	}// Fin du main

}// Fin de la classe 
