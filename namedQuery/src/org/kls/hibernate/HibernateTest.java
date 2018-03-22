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
		Query query= session.getNamedQuery("UserDetails.byId");
		List users=query.list();	
		session.getTransaction().commit();
		session.close();
		System.out.print("Size of list result = " + users.size());

	}

}
