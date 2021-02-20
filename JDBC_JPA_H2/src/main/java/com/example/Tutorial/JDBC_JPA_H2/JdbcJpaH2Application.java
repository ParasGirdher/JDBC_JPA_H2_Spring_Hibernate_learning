package com.example.Tutorial.JDBC_JPA_H2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Tutorial.JDBC_JPA_H2.entity.Course;
import com.example.Tutorial.JDBC_JPA_H2.entity.Person;
import com.example.Tutorial.JDBC_JPA_H2.repository.CourseJpaRepository;
import com.example.Tutorial.JDBC_JPA_H2.repository.PersonJpaRepository;
import com.example.Tutorial.JDBC_JPA_H2.repository.PersonPassportJpaRepository;

@SpringBootApplication
public class JdbcJpaH2Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository personJpaRepository;

	@Autowired
	PersonPassportJpaRepository personPassportJpaRepository;

	@Autowired
	CourseJpaRepository courseJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(JdbcJpaH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(date);
		System.out.println(time);
		System.out.println(ldt);
		// TODO Auto-generated method stub
		personPassportJpaRepository.insert();
		personPassportJpaRepository.findById(2L);

		courseJpaRepository.insertCourse(new Course("Testing Course"));
		courseJpaRepository.addReviews(3L);
		courseJpaRepository.getReviesFromCourse(3L);

	}

}
