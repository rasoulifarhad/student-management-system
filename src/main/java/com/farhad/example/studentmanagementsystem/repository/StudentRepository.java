package com.farhad.example.studentmanagementsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.farhad.example.studentmanagementsystem.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByNameAndCgpa(String name, Double cgpa);
	Student findByAddress_City(String city);

	List<Student> findByAddress_CountryOrHasArrears(String country, Boolean hasArrears);

	List<Student> findByEnrollmentDateBetweenOrderByEnrollmentDate(LocalDate startDate, LocalDate endDate);

	List<Student> findByCgpaGreaterThanEqual(Double cgpa);

	String findByNameIgnoreCase(String name);

	List<Student> findByCgpaOrderByNameDesc(Double cgpa, String name);

	@Aggregation("{ $group : { _id : null, averageCgpa : { $avg : $cgpa}}}")
	Long avgCgpa();
}
