package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        
        //Transient State of Object
        User user = new User();
        
        Vehicle v1 = new Vehicle();
        v1.setName("Audi");
        v1.setVehType("Sedan");
        
        Vehicle v2 = new Vehicle();
        v2.setName("Mercedes");
        v2.setVehType("Hatchback");
        
        Vehicle v3 = new Vehicle();
        v3.setName("Audi");
        v3.setVehType("Car");
		/*
		 * Vehicle v2 = new Vehicle("Nissan", "Hatchback"); Vehicle v3 = new
		 * Vehicle("Mercedes", "Sedan"); Vehicle v4 = new Vehicle("Bugatti", "XUV");
		 */
        
        
        
        List<Vehicle>veh = new ArrayList<Vehicle>();
        
       veh.add(v1);
       veh.add(v2);
       veh.add(v3);
		/*
		 * veh.add(v2); veh.add(v3); veh.add(v4);
		 */
        
        
        user.setUserName("Thomas");
        user.setVeh(veh);
        
        User u1 = new User();
        u1.setUserName("Ravindra");
        
        User u2 = new User();
        u1.setUserName("Trisha");
        
       
        
        
        List<User>uList = new ArrayList<User>();
        uList.add(user);
        
        
        v1.setUser(uList);
        
        session.save(user);
        session.save(v1);
        session.save(v2);
        session.save(v3);
        session.save(u1);
        session.save(u2);
        
        tx.commit();
        
        session.close();
        
    }
}
