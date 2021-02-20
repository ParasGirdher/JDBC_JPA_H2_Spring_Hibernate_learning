package com.example.Tutorial.JDBC_JPA_H2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
//@Table(name="person_details")
//No need for Table entity, table name would be same
public class Review {

	@Id // Indicates that this is a primary key
	@GeneratedValue
	private Long id;
	@Column(nullable = false) // (No need for this as the column name would be same)
	private String rating;

	@ManyToOne
	private Course course;

	protected Review() {
		super();
	}

	public Review(String rating) {
		super();
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + "]";
	}

}
