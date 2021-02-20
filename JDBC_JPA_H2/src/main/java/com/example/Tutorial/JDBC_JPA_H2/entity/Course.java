package com.example.Tutorial.JDBC_JPA_H2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@Table(name="person_details")
//No need for Table entity, table name would be same
public class Course {

	@Id // Indicates that this is a primary key
	@GeneratedValue
	private Long id;
	@Column(nullable = false) // (No need for this as the column name would be same)
	private String courseName;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();

	protected Course() {
		super();
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;

	}

	public Long getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}

}
