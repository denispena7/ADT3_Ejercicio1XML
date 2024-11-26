package es.studium.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestPerro
{
	public static void main(String[] args)
	{
		SessionFactory sessionFactory = new
				Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		/*Creamos dos objetos de tipo Usuario*/
		Perro p1 = new Perro("Dálmata", "1.2 m", 10, "Blanco con manchas");
		Perro p2 = new Perro("Pastor Alemán", "1 m", 6, "Amarillo");

		//Marcamos los objetos para guardarlos en la base de datos
		session.persist(p1);
		session.persist(p2);
		//Guardamos el objeto en la base de datos
		tx.commit();
		session.close();
		
		System.out.println("El perro de raza " + p1.getRaza()
		+ " se ha añadido correctamente a tu base de datos");
		System.out.println("El perro de raza " + p2.getRaza()
		+ " se ha añadido correctamente a tu base de datos");

	}

}
