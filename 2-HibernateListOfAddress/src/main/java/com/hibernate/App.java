package com.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

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
        Address homeAdd = new Address("Bhopal", "Madhya Pradesh");
        
        List<Address> collAdd = new ArrayList<Address>();
        //collAdd.add(officeAdd);
        collAdd.add(add);
        collAdd.add(homeAdd);
        
        User user = new User();
        user.setUserId(113);
        user.setUserName("Akhil");
//        user.setHomeAddress(homeAdd);
        user.setOfficeAddress(collAdd);
        
        session.save(user);
        
        tx.commit();
        session.close();
        
    }
}
