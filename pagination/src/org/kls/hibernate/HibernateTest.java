package org.kls.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kls.learn.Address;
import org.kls.learn.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from UserDetails where userId>5");
		List<UserDetails>  users = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println(users.size());

	}

}
