package com.farhad.example.studentmanagementsystem.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document("Student")
public class Student {

	@Id
	@Indexed(unique = true)
	private String id;
	private String name;
	private double cgpa;
	@Field("has_arrears")
	private boolean hasArrears;
	@Field("course_list")
	private List<String> courseList;
	private Address address;
	@Field("enrollment_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate enrollmentDate; 
}
