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
	UserDetails user= (UserDetails) session.get(UserDetails.class, 1);
	session.getTransaction().commit();
	session.close();
	
	Session session2= sessionfactory.openSession();
	session2.beginTransaction();
	
	UserDetails user2= (UserDetails) session2.get(UserDetails.class, 1);
	session.getTransaction().commit();
	session.close();

	}

}
