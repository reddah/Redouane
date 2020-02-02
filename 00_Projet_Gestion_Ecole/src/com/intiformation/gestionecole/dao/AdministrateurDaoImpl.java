package com.intiformation.gestionecole.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.gestionecole.entity.Administrateur;
import com.intiformation.gestionecole.tool.JpaUtil;

public class AdministrateurDaoImpl implements IGestionDao<Administrateur>{

	// 1. récup de la l'entityManager à partir de JpaUtil
		private EntityManager entityManager = JpaUtil.getInstance();

		/* ============================================================== */
		/* ======================= Ajouter Administrateur ========================= */
		/* ============================================================== */
		@Override
		public boolean ajouter(Administrateur aAdministrateur) {

			EntityTransaction transaction = null;
			try {
				// 1. récup de ouverture d'une transaction
				transaction = entityManager.getTransaction();
				transaction.begin();

				// 2. ajout de l'administrateur à la bdd via la méthode persist()
				entityManager.persist(aAdministrateur);

				// 3. validation de la transaction avec commit()
				transaction.commit();
				return true;
			} catch (PersistenceException ex) {

				if (transaction != null) {
					// 4. annulation de la transaction
					transaction.rollback();
					ex.printStackTrace();
				} // fin du if
			} finally {
				// 7. fermeture de l'entityManager
				// entityManager.close();

			} // fin du catch
			return false;
		}// fin de la méthode ajouterAdministrateur()

		/* ============================================================== */
		/* ===================== Get By IdAdministrateur ====================== */
		/* ============================================================== */
		@Override
		public Administrateur getById(int pIdAdministrateur) {

			Administrateur administrateur = null;

			try {
				Query getByIdQuery = entityManager.createNamedQuery("Administrateur_getById");
				getByIdQuery.setParameter("pID", pIdAdministrateur);

				administrateur = (Administrateur) getByIdQuery.getSingleResult();

				return administrateur;

			} catch (PersistenceException ex) {
				ex.printStackTrace();
			} finally {
				// 3. fermeture de l'entityManager
				// entityManager.close();
			} // end finally

			return null;
		}// end getAdministrateurById()

		/* ============================================================== */
		/* ===================== Modifier Administrateur ====================== */
		/* ============================================================== */
		@Override
		public boolean modifier(int pIdAdministrateur, Administrateur pAdministrateur) {

			EntityTransaction transaction = null;

			try {
				// 1. ouverture d'une transaction via l'entityManager
				transaction = entityManager.getTransaction();
				transaction.begin();

				// 3. récup de l'administrateur à modifier
				Administrateur administrateurUpdate = getById(pIdAdministrateur);

				// 4. modif de l'administrateur

				administrateurUpdate.setIdentifiant(pAdministrateur.getIdentifiant());
				administrateurUpdate.setMotDePasse(pAdministrateur.getMotDePasse());
				administrateurUpdate.setNom(pAdministrateur.getNom());
				administrateurUpdate.setPrenom(pAdministrateur.getPrenom());
				administrateurUpdate.setEmail(pAdministrateur.getEmail());

				// 5. modif de l'administrateur dans la bdd via la méthode update()
				entityManager.merge(administrateurUpdate);

				// 6. validation de la transaction avec commit()
				transaction.commit();

				return true;
			} catch (PersistenceException ex) {

				if (transaction != null) {
					// 7. annulation de la transaction
					transaction.rollback();
					ex.printStackTrace();
				}

			} finally {
				// 8. fermeture de l'entityManager
				// entityManager.close();
			} // end finally
			return false;
		}// end modifierAdministrateur

		/* ============================================================== */
		/* ==================== Supprimer Administrateur ====================== */
		/* ============================================================== */
		@Override
		public boolean supprimer(int pIdAdministrateur) {

			EntityTransaction transaction = null;

			try {
				// 2. ouverture d'une transaction via l'entityManager
				transaction = entityManager.getTransaction();
				transaction.begin();
				// 3. récup de l'administrateur à modifier
				Administrateur administrateurSupp = getById(pIdAdministrateur);

				// 4. modif de l'administrateur dans la bdd via la méthode remove() de l'entityManager
				entityManager.remove(administrateurSupp);

				// 5. validation de la transaction avec commit()
				transaction.commit();

				return true;
			} catch (PersistenceException ex) {

				if (transaction != null) {
					// 6. annulation de la transaction
					transaction.rollback();
					ex.printStackTrace();
				}

			} finally {
				// 7. fermeture de l'entityManager
				// entityManager.close();
			} // end finally
			return false;
		}// end supprimerAdministrateur

		/* ============================================================== */
		/* ===================== Get all Administrateur ======================= */
		/* ============================================================== */
		@Override
		public List<Administrateur> getAll() {

			List<Administrateur> listeAllAdministrateurs = null;

			try {
				Query getAllAdministrateurQuery = entityManager.createNamedQuery("Administrateur_getAll");

				listeAllAdministrateurs = getAllAdministrateurQuery.getResultList();

				return listeAllAdministrateurs;

			} catch (PersistenceException ex) {
				ex.printStackTrace();
			} finally {
				// 7. fermeture de l'entityManager
				// entityManager.close();
			} // end finally
			return null;

		}// Fin de la méthode getAllAdministrateur
}// Fin de la classe AdministrateurDaoImpl
