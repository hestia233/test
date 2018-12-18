package com.felix.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.felix.domain.User;

public class Demo1 {
	@Test
	public void fun1()
	{
		 Configuration conf = new Configuration().configure();
		 SessionFactory sessionFactory = conf.buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 
		 
		 Transaction tx = session.beginTransaction();
		 
		 User user = new User();
		 user.setName("灭霸洗衣液");
		 
		 session.save(user);
		 
		 tx.commit();
	}
	
	@Test
	 public void fun2()
	 {
			
			
	   ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	   SessionFactory sessionFactory = (SessionFactory) ac.getBean("SessionFactory");
	   Session session = sessionFactory.openSession();	
			
		 /*Configuration conf = new Configuration().configure();
		 SessionFactory sessionFactory = conf.buildSessionFactory();
		 Session session = sessionFactory.openSession();*/
		 
		 
		 Transaction tx = session.beginTransaction();
		 
		 User user = new User();
		 user.setName("武大郎");
		 
		 session.save(user);
		 
		 tx.commit(); 
		 
	 }
}
