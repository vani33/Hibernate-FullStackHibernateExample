package com.hcl.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hcl.model.User;

public class UserDAO {

	public void addUserDetails(User user) {
		try{
			Configuration config = new Configuration().configure();
			SessionFactory factory = config.buildSessionFactory();  
			Session session = factory.openSession();  
			Transaction t = session.beginTransaction();
			session.save(user);
			t.commit();
			System.out.println("\n\n Details Added \n");
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
