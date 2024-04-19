package com.farhad.example.studentmanagementsystem.model;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Entity;

@Entity
public class Address {

	private String street;
	private String city;
	private String state;
	private String country;
	@Field("zip_code")
	private String zipcode;
}
