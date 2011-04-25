package com.ricston.entities;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
@Entity
public class Person {
 
   private int id;
   private String name;
   private String surname;
   private String job;
   private int age;
 
   public Person() {
      super();
   }
 
   public Person(int id, String name, String surname, String job, int age) {
      super();
      this.id = id;
      this.name = name;
      this.surname = surname;
      this.job = job;
      this.age = age;
   }
 
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public int getId() {
      return id;
   }
 
   public void setId(int id) {
      this.id = id;
   }
 
   public String getName() {
      return name;
   }
 
   public void setName(String name) {
      this.name = name;
   }
 
   public String getSurname() {
      return surname;
   }
 
   public void setSurname(String surname) {
      this.surname = surname;
   }
 
   public String getJob() {
      return job;
   }
 
   public void setJob(String job) {
      this.job = job;
   }
 
   public int getAge() {
      return age;
   }
 
   public void setAge(int age) {
      this.age = age;
   }
 
}
