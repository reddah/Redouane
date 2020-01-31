package com.intiformation.gestionecole.test;

import com.intiformation.gestionecole.dao.AideDao;
import com.intiformation.gestionecole.entity.Aide;

public class AppTestAide {

	public static void main(String[] args) {

		/*==============================================================*/
		/*======================= Ajouter Aide =========================*/
		/*==============================================================*/
		
		// aide à ajouter
		Aide aide = new Aide("C'est pour nous");
		
		// DAO
		AideDao aideDao = new AideDao();
		
		// Ajout
		aideDao.ajouterAide(aide);
		
		// Affichage
		System.out.println("Ajout des aides : ++++++++++++++++++++++++++++++++++++");
		System.out.println("\t > " + aide);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		
		
		/* ============================================================== */
		/* ======================= Get By IdAide ======================== */
		/* ============================================================== */
		
		System.out.println("Get by id ++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t > ID : " + aideDao.getAideById(2).getPage());
		System.out.println("\t > Contenu : " + aideDao.getAideById(2).getContenu());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		
		
		/* ============================================================== */
		/* ======================= Modifier Aide ======================== */
		/* ============================================================== */
		
		System.out.println("UPDATE +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		aideDao.modifierAide(3, "Aubin Rossignol");
		System.out.println("\t > Aprés update : ");
		Aide a = aideDao.getAideById(3);
		System.out.println("\t\t > id = : " + a.getPage() + ", nom : " + a.getContenu() );
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		
		/* ============================================================== */
		/* ======================= Supprimer Aide ======================= */
		/* ============================================================== */
		
		System.out.println("DELETE ++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		//aideDao.supprimerAide(5);
		
		
		/* ============================================================== */
		/* ======================== Get all Aide ======================== */
		/* ============================================================== */
		
		System.out.println("Get All Aides ===================================");	
		for (Aide aide1 : aideDao.getAllAide()) {
			System.out.println("\t > " + aide1.getPage() + "  " + aide1.getContenu());
		}
		
		System.out.println("===================================================================\n");
		
		
		/* ============================================================== */
		/* =================== Get all Contenu de Aide ================== */
		/* ============================================================== */
		
		System.out.println("Get ALL Contenu Aide ===================================");	
		for (String contenu : aideDao.getAllContenuAide()) {
			System.out.println("\t > " + contenu);
		}
		
		System.out.println("===================================================================\n");
		
	}// Fin du main

}// Fin de la classe 
