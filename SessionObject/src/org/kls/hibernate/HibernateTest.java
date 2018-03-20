package org.kls.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kls.learn.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
         user.setUserId(1);
         user.setUserName("First User");
         user.setAddress("First User's Address");
         user.setJoinedDate(new Date());
         user.setDescription("Description of first user");
         SessionFactory sessionfactory= new Configuration().configure().buildSessionFactory();
         Session session=sessionfactory.openSession();
         session.beginTransaction();
         session.save(user);
         session.getTransaction().commit();
         session.close();
         
         user=null;
          session=sessionfactory.openSession();
         session.beginTransaction();
         user=(UserDetails) session.get(UserDetails.class, 1);
         System.out.println("UserName is " + user.getUserName() );
	}

}
