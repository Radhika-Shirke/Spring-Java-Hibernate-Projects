package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        
        //Transient State of Object
        User user = new User();
        user.setUserId(2);
        user.setUserName("Rina");
        
      //Persistent State of Object
        //session.save(user);
        
        
		User u = session.get(User.class, 2);
		System.out.println("*******************");
		//session.delete(u);
		/*//Will Return NULL
		 * User uGet = session.get(User.class, 67); System.out.println(uGet);
		 * System.out.println("*******************************");
		 */
		  
		  
			/*//ObjectNotFoundException
			 * User uLoad = session.load(User.class, 67); System.out.println(uLoad);
			 * System.out.println("******************************");
			 */
		
//		User u2 = session.get(User.class, 2);
//		System.out.println(u2);
//		System.out.println("*******************");
		
       tx.commit();
        
        //Detach state of Object
        session.close();
//        session.clear();
		
		//session.evict(u);
        
		
		  session = factory.openSession();
		  Transaction tx2 = session.beginTransaction();
		  u.setUserName("Tina");
		  session.update(u);
		  System.out.println(u);
		  tx2.commit();
			/*
			 * User u1 = session.get(User.class, 2); System.out.println(u1);
			 */
        
    }
}
