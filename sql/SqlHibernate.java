package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SqlHibernate {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		//SQL Query
		String q = "select * from Student";
		NativeQuery nq = s.createNativeQuery(q);
		List<Object[]> list = nq.list();
		for (Object[] student : list) {
			System.out.println(Arrays.toString(student));
		}
		s.close();
		factory.close();
	}
	
}
