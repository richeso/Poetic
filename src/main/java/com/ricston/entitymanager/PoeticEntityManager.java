package com.ricston.entitymanager;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class PoeticEntityManager {
 
   private static PoeticEntityManager poeticEntityManager = new PoeticEntityManager();
 
   private EntityManagerFactory factory;
   private EntityManager entityManager;
 
   private PoeticEntityManager () {
      factory =   Persistence.createEntityManagerFactory("PoeticPersistenceUnit");
      entityManager = factory.createEntityManager();
   }
 
   public EntityManager getEntityManager(){
      return poeticEntityManager.entityManager;
   }
 
   public void close(){
      poeticEntityManager.entityManager.close();
      poeticEntityManager.factory.close();
   }
 
}
