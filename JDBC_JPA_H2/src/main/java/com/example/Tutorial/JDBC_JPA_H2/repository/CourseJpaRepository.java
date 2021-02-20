package com.example.Tutorial.JDBC_JPA_H2.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Tutorial.JDBC_JPA_H2.entity.Course;
import com.example.Tutorial.JDBC_JPA_H2.entity.Review;

@Repository
@Transactional
public class CourseJpaRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void insertCourse(Course course) {
		em.persist(course);
		logger.info("Course has been persisted in DB {}", course);
	}

	public void addReviews(Long id) {
		Course course = em.find(Course.class, id);
		logger.info("{}", course.getReviews());
		Review review1 = new Review("3");
		Review review2 = new Review("2");
		review1.setCourse(course);
		review2.setCourse(course);

		em.persist(review1);
		em.persist(review2);

	}

	public void getReviesFromCourse(Long id) {
		Course course = em.find(Course.class, id);
		List<Review> reviewsList = course.getReviews();
		logger.info("{}",reviewsList);
	}

}
