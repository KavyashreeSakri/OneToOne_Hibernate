package one_to_one_uni_pan.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_pan.dto.PanCard;
import one_to_one_uni_pan.dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		PanCard panCard = person.getPanCard();
		entityTransaction.begin();

		entityManager.persist(panCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(String name, int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		person.setName(name);
		
		entityTransaction.begin();
		
		entityManager.merge(person);
		entityTransaction.commit();
	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		PanCard panCard = person.getPanCard();
		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(panCard);
			entityManager.remove(person);
			entityTransaction.commit();
		} else
			System.out.println("No person available for the given id");

	}

	public Person getPersonById(int id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Person.class, id);

	}

	public List<Person> getAllPerson() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT p FROM Person p");
		List<Person> list = query.getResultList();
		return list;

	}
}
