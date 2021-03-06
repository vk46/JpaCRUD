package com.vk.JpaDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Simple JPA Application!
 *
 */
public class Application
{
	public static void main( String[] args ){
		
		//convert object to JSON
		ObjectMapper mapper = new ObjectMapper();
		
		try{
			//create new person
			Person person = new Person();
			person.setPname("Ram");
			person.setTech("RPA");

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("vk");
			EntityManager em = emf.createEntityManager();

			//begin transaction
			em.getTransaction().begin();

			//create person object
			em.persist(person);
			
			//read person object
//			Person person = em.find(Person.class, 3);
			
			//update person object
//			person.setTech("Asp.Net");
			
			//delete person object
//			em.remove(person);
			
			//commit transaction
			em.getTransaction().commit();

			//close transaction
			em.close();
			
			String objectJSON = mapper.writeValueAsString(person);
			System.out.println(objectJSON);
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}
