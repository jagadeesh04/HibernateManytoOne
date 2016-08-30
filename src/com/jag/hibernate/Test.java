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
		
		(studentAddress.getStudents()).add(student1);
		(studentAddress.getStudents()).add(student2);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(studentAddress);
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
	}
	
}
