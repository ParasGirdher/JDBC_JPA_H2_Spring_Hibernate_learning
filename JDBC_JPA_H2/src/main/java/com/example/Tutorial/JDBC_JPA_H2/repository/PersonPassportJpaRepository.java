package com.example.Tutorial.JDBC_JPA_H2.repository;

import java.util.Date;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Tutorial.JDBC_JPA_H2.entity.Passport;
import com.example.Tutorial.JDBC_JPA_H2.entity.Person;

@Repository
@Transactional
public class PersonPassportJpaRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void findById(Long id) {
		Person p = em.find(Person.class, id);
		logger.info("{}", p);
		logger.info("{}", p.getPassport());
	}

	public void insert() {
		Person p = new Person("Paras", "Kalanaur", new Date());
		Passport passport = new Passport("EHJKL");
		em.persist(passport);
		p.setPassport(passport);
		em.persist(p);
	}

}
