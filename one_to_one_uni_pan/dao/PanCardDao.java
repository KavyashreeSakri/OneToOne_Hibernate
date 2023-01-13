package one_to_one_uni_pan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_pan.dto.PanCard;
import one_to_one_uni_pan.dto.Person;

public class PanCardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void savePan(PanCard panCard) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(panCard);
		entityTransaction.commit();
	}

	public void updatePan(String name, int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard panCard = entityManager.find(PanCard.class, id);
		panCard.setPan_name(name);

		entityTransaction.begin();
		entityManager.merge(panCard);
		entityTransaction.commit();
	}
	public void deletePan(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard panCard = entityManager.find(PanCard.class, id);
		
		if (panCard != null) {
			entityTransaction.begin();
			entityManager.remove(panCard);
			entityTransaction.commit();
		} else
			System.out.println("No pancard available for the given id");

	}
	
	public PanCard getPanById(int id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(PanCard.class, id);

	}
	public List<PanCard> getAllPan() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT p FROM PanCard p");
		List<PanCard> list = query.getResultList();
		return list;

	}



}
