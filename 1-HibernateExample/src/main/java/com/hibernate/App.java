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
        
        Address add = new Address("Pune", "Maharashtra");
        
        Address officeAdd = new Address("Mumbai", "Maharashtra");
        
        User user = new User();
        user.setUserId(111);
        user.setUserName("Rohit");
        user.setHomeAddress(add);
        user.setOfficeAddress(officeAdd);
        
        session.save(user);
        
        tx.commit();
        session.close();
        
    }
}
