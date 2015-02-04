/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.christina.mapping;

import edu.christina.dto.Student;
import edu.christina.dto.Vehicle;
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
public class MappingTest {
    private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry; 
	
        static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        
    public static void main(String[]args){
        Student stu = new Student();
        stu.setStudentName("Student Name");
       
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Vehicle Name");
        
        stu.setVehicle(vehicle);
        
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(stu);
        session.save(vehicle);
        tx.commit();
        session.close();
        
    }
}
