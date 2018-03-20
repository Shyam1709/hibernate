package org.kls.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kls.learn.Address;
import org.kls.learn.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();

         user.setUserName("First User");
       
         
       Address addr =new Address();
       addr.setCity("Delhi");
       addr.setPincode("201001");
       addr.setState("UP");
       addr.setStreet("Rajiv chawk");
       user.setHomeAddress(addr);
       user.setOfficeAddress(addr);
       
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
