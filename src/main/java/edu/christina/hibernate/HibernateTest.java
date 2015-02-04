/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.christina.hibernate;

import edu.christina.dto.Address;
import edu.christina.dto.UserDetails;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author CKarki
 */
public class HibernateTest {
      
    private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry; 
	static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
    
        public static void main(String[] args){ 
        Session session = null;
        Transaction tx= null;
        UserDetails user = new UserDetails();
        try{
            session = sessionFactory.openSession();
            tx= session.beginTransaction();
            
          
            user.setUserid(1);
            user.setUsername("First User");
//            user.setJoinedDate(new Date());
        
//           user.setDescription("I am first user and i live in Kathmandu");
            //WAS in third commit of embedded and embeddable but deleted in this fourth commit of multiple Addresses
//           Address address = new Address();
//           address.setStreet("100N 4th Street");
//           address.setCity("Fairfield");
//           address.setState("Iowa");
//           address.setPincode("52557");
//           user.setAddress(address);
            Address address1 = new Address();
            address1.setStreet("homeStreet1");
            address1.setCity("homeCity1");
            Address address2 = new Address();
            address2.setStreet("homeStreet2");
            address2.setCity("homeCity2");
          //  user.setHomeAddress(address1);
          //  user.setOfficeAddress(address2);
            user.getListOfAddresses().add(address1);
            user.getListOfAddresses().add(address2);
            session.save(user);
           // session.persist(user);
            tx.commit();   
        }
        catch(HibernateException ex)
        {
            if(tx != null)
            tx.rollback();
            ex.printStackTrace();
        }
        finally{
            if(session!=null)
               session.close();
        }
        
        session = sessionFactory.openSession();
        tx=session.beginTransaction();
        user = (UserDetails)session.get(UserDetails.class, 1);
       // System.out.println("User retrieved is:"+user.toString());
        session.close();
        System.out.println(user.getListOfAddresses().size());
    }
}
