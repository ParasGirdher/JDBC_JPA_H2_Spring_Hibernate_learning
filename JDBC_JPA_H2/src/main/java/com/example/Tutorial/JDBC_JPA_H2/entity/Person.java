package com.example.Tutorial.JDBC_JPA_H2.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
//@Table(name="person_details")
//No need for Table entity, table name would be same
@NamedQueries(value = { @NamedQuery(name = "find_all_persons", query = "select p from Person p"),
		@NamedQuery(name = "find_person_byName", query = "select p from Person p where name like '%Girdher'") })
//@NamedQuery(name = "find_all_persons", query = "select p from Person p") //This is only for 1 query
public class Person {

	@Id // Indicates that this is a primary key
	@GeneratedValue
	private Long id;
	@Column(name = "fullname", nullable = false) // (No need for this as the column name would be same)
	private String name;
	private String location;

	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	private Date birthDate;
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
	private LocalDateTime createdDate;

	protected Person() {
		super();
	}

	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}
}
