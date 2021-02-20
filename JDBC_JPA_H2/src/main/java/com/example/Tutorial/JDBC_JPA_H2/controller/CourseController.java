package com.example.Tutorial.JDBC_JPA_H2.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tutorial.JDBC_JPA_H2.entity.Course;

@RestController
public class CourseController {

	@GetMapping("/courses")
	public List<Course> getCourses() {
		return Stream.of(new Course("English")).collect(Collectors.toList());
	}
}
