package com.poly.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class XJPA {
	static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("SOF3012_Lab2");
	}
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
