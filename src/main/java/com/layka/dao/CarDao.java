package com.layka.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.layka.entities.Car;
import com.layka.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class CarDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MyProjectJPA");

//méthode ajouter d'une entité à la bd
	public void ajouter(Car c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(c);
		tx.commit();
	}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Car c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Car c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		c = entityManager.merge(c); // important
		entityManager.remove(c);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Car consulter(Car c, Object id) {
		return entityManager.find(c.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Car> listerTous() {
		List<Car> Cars = entityManager.createQuery("select c from Car c").getResultList();

		return Cars;
	}

//méthode pour lister tous les Car dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Car> listerParNom(String nom) {
		List<Car> Cars = entityManager.createQuery("select c from Car c where c.Carname like :pnom").setParameter("pnom", "%" + nom + "%").getResultList();

		return Cars;
	}
}
