package com.ricston.dao;
 
import com.ricston.entities.Person;
 
import java.util.List;
import java.util.Random;
 
import javax.persistence.Query;
import javax.ws.rs.PathParam;
 
import com.ricston.entitymanager.PoeticEntityManager;
 
public class PersonDao {
 
   private PoeticEntityManager em;
 
   public List<Person> findAll() {
      Query q = em.getEntityManager().createQuery("Select p From Person p");
      List<Person> persons = q.getResultList();
      return persons;
   }
 
   public List<Person> findByName(String name) {
      Query q = em.getEntityManager().createQuery("Select p From Person p Where p.name=?1");
      q.setParameter(1, name);
      List<Person> persons = q.getResultList();
      return persons;
   }
 
   public Person generate(String name) {
      em.getEntityManager().getTransaction().begin();
 
      Random r = new Random();
      Person p = new Person();
      p.setName(name);
      p.setAge(r.nextInt(75));
      p.setJob("developer");
      p.setSurname("surname");
 
      em.getEntityManager().persist(p);
      em.getEntityManager().getTransaction().commit();
 
      return p;
   }
 
   public Person findById(int id) {
      Query q = em.getEntityManager().createQuery("Select p From Person p WHERE p.id=?1");
      q.setParameter(1, id);
      return (Person)q.getSingleResult();
   }
 
   public Person deleteById(int id) {
	      Query q = em.getEntityManager().createQuery("Select p From Person p WHERE p.id=?1");
	      q.setParameter(1, id);
	      Person aPerson = null;
	      Object personObject = q.getSingleResult();
	      if (personObject != null) {
	    	  em.getEntityManager().getTransaction().begin(); 
	    	  aPerson =  (Person) personObject;
		      em.getEntityManager().remove(aPerson);
		      em.getEntityManager().getTransaction().commit();
	      }
	      return aPerson;
	}
   public PoeticEntityManager getEm() {
      return em;
   }
 
   public void setEm(PoeticEntityManager em) {
      this.em = em;
   }
 
}
