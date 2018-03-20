package org.kls.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kls.learn.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
         user.setUserId(2);
         user.setUserName("Second User");
         SessionFactory sessionfactory= new Configuration().configure().buildSessionFactory();
         Session session=sessionfactory.openSession();
         session.beginTransaction();
         session.save(user);
         session.getTransaction().commit();
	}

}
