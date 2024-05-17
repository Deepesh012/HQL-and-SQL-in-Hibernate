package com.hql.hibernate;

import java.util.Arrays;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import com.jsp.ProjectWithMaven.Student;

public class HQLExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		//HQL
		//Syntax:
		String query = "from Student where city=:x";
		Query q = s.createQuery(query);
		q.setParameter("x", "Agra");
		
		List<Student> list = q.list();
		for(Student student : list)
		{
			System.out.println(student);
		}
		
		
		
		System.out.println("___________________________________________");
		Transaction tx = s.beginTransaction();
		//Delete
//		Query q2 = s.createQuery("delete from Student s where s.name=:c");
//		q2.setParameter("c", "Dinasour");
//		int r = q2.executeUpdate();
//		System.out.println("Deleted:");
//		System.out.println(r);
//		tx.commit();
		
		//Update
		Query q3 = s.createQuery("Update Student set city=:x where name=:y");
		q3.setParameter("x", "New Delhi");
		q3.setParameter("y", "abcd");
		int r = q3.executeUpdate();
		System.out.println(r + " Objects Updated");
		tx.commit();
		
		//Join 
		Query q4 = s.createQuery("select q.question , q.questionId , a.Answer from Question as q INNER JOIN q.answer as a");
		List<Object [] > list4 = q4.getResultList();
		
		for (Object[] arr : list4)
		{
			System.out.println(Arrays.toString(arr));
		}
		
		s.close();
		factory.close();
		
	}
	
}
