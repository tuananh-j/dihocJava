package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.User;
import com.poly.utils.XJPA;

public class UserImpl implements UserDao {

	@Override
	public List<User> find_all() {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		String jpql = "SELECT o FROM User o";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		return query.getResultList();
	}

	@Override
	public User find_id(String id) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		return em.find(User.class, id);
	}

	@Override
	public void create(User item) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void update(User item) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(item);
			em.getTransaction().rollback();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void delete_id(String id) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		User item = em.find(User.class, id);
		try {
			em.getTransaction().begin();
			em.remove(item);
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
	}

}
