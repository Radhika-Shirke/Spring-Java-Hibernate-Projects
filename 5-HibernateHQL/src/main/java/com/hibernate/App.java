package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.criterion.Restrictions;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        
        User user = new User();
        user.setUserName("Rohit");
        user.setUserAddress("Pune");
        
        //session.save(user);
        
        Query query = session.createQuery("from User");
        
		
		query.setFirstResult(0); query.setMaxResults(10);
		 
		//Pagination        
        query.setFirstResult(10);
        query.setMaxResults(20);
              
        
        //Using 	WHERE condition
        
		/*
		 * Query query1 = session.
		 * createQuery("from User u where u.userName = :x and u.userAddress = :y");
		 * query1.setParameter("x", "Virat"); query1.setParameter("y", "Pune");
		 * 
		 * Query query2 =
		 * session.createQuery("from User u where u.userName = :x or u.userAddress = :y"
		 * ); query2.setParameter("x", "Virat"); query2.setParameter("y", "Pune");
		 */
        
		/*
		 * Criteria criteria = session.createCriteria(User.class);
		 * criteria.add(Restrictions.eq("userAddress", "Pune"));
		 */
        
		/*
		 * Query queryNamed = session.getNamedQuery("findUserName");
		 * queryNamed.setParameter("x", "Virat");
		 */

		/*
		 * NativeQuery queryNamedNative =
		 * session.getNamedNativeQuery("findUserAddress");
		 * queryNamedNative.setParameter("address", "Pune");
		 * 
		 * 
		 * List<User>list = queryNamedNative.getResultList();
		 * 
		 * for(User u : list) { System.out.println(u); }
		 */
		  
		  
		  User u = session.get(User.class, 2);
		  System.out.println(u);

		  User u1 = session.get(User.class, 2);
		  System.out.println(u1);

        session.close();
        
        session = factory.openSession();
        
        Transaction tx1 = session.beginTransaction();
        
        User u2 = 
        
    }
}
