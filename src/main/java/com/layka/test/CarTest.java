package com.layka.test;

import com.layka.dao.CarDao;
import com.layka.entities.Car;

public class CarTest {
	public static void main(String[] args) {
//créer un objet Car
		Car c = new Car();
		c.setCarname("BMW M5CS");
		c.setPrice(150000);
		Car c2 = new Car();
		c2.setCarname("Nissan GTR");
		c2.setPrice(110000);
		
//ajouter l'objet Car à la BD
		
		CarDao cltDao = new CarDao();
		cltDao.ajouter(c);
		cltDao.ajouter(c2);
		System.out.println("Appel de la méthode listerTous");
		for (Car cl : cltDao.listerTous())
			System.out.println(cl);
		System.out.println("Appel de la méthode listerParNom");
		for (Car cl : cltDao.listerParNom("BMW"))

			System.out.println(cl);

//tester les autres méthodes de la classe CarDao
	}
}