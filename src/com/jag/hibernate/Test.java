package com.jag.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test {

	public static void main(String[] args) {
		StudentAddress studentAddress = new StudentAddress();
		studentAddress.setAddress_detail("St. Louis, MO");
		
		Student student1 = new Student();
		
		student1.setStudent_name("jag");
		student1.setStudentAddress(studentAddress);
		
		Student student2 = new Student();
		
		student2.setStudent_name("Ram");
		student2.setStudentAddress(studentAddress);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
	}
	
}
