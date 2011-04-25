package com.ricston.rest;
 
import java.util.List;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
import com.ricston.dao.PersonDao;
import com.ricston.entities.Person;
 
@Path("/poetic")
public class PoeticResource {
 
   private PersonDao personDao;
 
   @GET
   @Produces("application/xml")
   @Path("/generate/xml/{name}")
   public Person xmlGenerate(@PathParam("name") String name) {
      return personDao.generate(name);
   }
 
   @GET
   @Produces("application/json")
   @Path("/generate/json/{name}")
   public Person jsonGenerate(@PathParam("name") String name) {
      return personDao.generate(name);
   }
 
   @GET
   @Produces("application/xml")
   @Path("/findByName/xml/{name}")
   public List<Person> xmlFindByName(@PathParam("name") String name) {
      return personDao.findByName(name);
   }
 
   @GET
   @Produces("application/json")
   @Path("/findByName/json/{name}")
   public List<Person> jsonFindByName(@PathParam("name") String name) {
      return personDao.findByName(name);
   }
 
 
   @GET
   @Produces("application/xml")
   @Path("/findAll/xml")
   public List<Person> xmlFindAll() {
      return personDao.findAll();
   }
 
   @GET
   @Produces("application/json")
   @Path("/findAll/json")
   public List<Person> jsonFindAll() {
      return personDao.findAll();
   }
 
 
 
   @GET
   @Produces("application/xml")
   @Path("/findById/xml/{id}")
   public Person xmlFindById(@PathParam("id") int id) {
      return personDao.findById(id);
   }
 
   @GET
   @Produces("application/json")
   @Path("/findById/json/{id}")
   public Person jsonFindById(@PathParam("id") int id) {
      return personDao.findById(id);
   }
 
   public PersonDao getPersonDao() {
      return personDao;
   }
 
   public void setPersonDao(PersonDao personDao) {
      this.personDao = personDao;
   }
}
