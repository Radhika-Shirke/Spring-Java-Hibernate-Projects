package com.hib;

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
        
        Account acc = new Account();
        acc.setBankName("HSBC Bank");
        
        SavingAccount saveAcc = new SavingAccount();
        saveAcc.setAccountId(acc.getAccountId());
        saveAcc.setBankName(acc.getBankName());
        saveAcc.setBalance(50000);
        saveAcc.setContact("1234567890");
        
        SalaryAccount sal = new SalaryAccount();
        sal.setAccountId(acc.getAccountId());
        sal.setBankName(acc.getBankName());
        sal.setEmail("abc@gmail.com");
        sal.setSalary(89000);
        
        session.save(acc);
        session.save(saveAcc);
        session.save(sal);
        tx.commit();
        session.close();
    }
}
