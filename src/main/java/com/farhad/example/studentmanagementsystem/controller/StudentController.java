package com.farhad.example.studentmanagementsystem.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.studentmanagementsystem.model.Student;
import com.farhad.example.studentmanagementsystem.service.StudentService;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@PostMapping("/addStudent")
	public void populateStudentData(@RequestBody Student student) {
		studentService.addStudentData(student);
	}

	@GetMapping("/getAllStudentsData")
	public List<Student> fetchAllStudentsData() {
		return studentService.fetchAllStudentsData();
	}
	
	@GetMapping("/getStudentById/{id}")
	public Optional<Student> fetchStudentDataById(@PathVariable String id) {
		return studentService.fetchStudentDataById(id);
	}

	@GetMapping("/getStudentByNameAndCgpa")
	public List<Student> fetchStudentDataByNameAndCgpa(@RequestParam String name, @RequestParam Double cgpa) {
		return studentService.fetchStudentDataByNameAndCgpa(name, cgpa);
	}

	@GetMapping("/getStudentByCity/{city}")
	public Student fetchStudentDataByCity(@PathVariable String city) {
		return studentService.fetchStudentDataByCity(city);
	}

	@GetMapping("/getStudentByCountryOrArrears")
	public List<Student> fetchStudentDataByCountryOrArrears(@RequestParam String country,
			@RequestParam Boolean hasArrears) {
		return studentService.fetchStudentDataByCountryOrArrears(country, hasArrears);
	}

	@GetMapping("/getStudentByEnrollmentDate")
	public List<Student> fetchStudentDataByEnrollmentDate(
			@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") LocalDate startDate,
			@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") LocalDate endDate) {
		return studentService.fetchStudentDataByEnrollmentDate(startDate, endDate);
	}

	@GetMapping("/getStudentByName")
	public String fetchStudentDataByName(@RequestParam String name) {
		return studentService.fetchStudentDataByName(name);
	}

	@GetMapping("/getStudentByCgpa")
	public List<Student> fetchStudentDataByCgpa(@RequestParam Double cgpa) {
		return studentService.fetchStudentDataByCgpa(cgpa);
	}

	@GetMapping("/getAvgCgpa")
	public Long fetchStudentAvgCgpa() {
		return studentService.fetchAverageCgpa();
	}

	@DeleteMapping("/deleteStudent")
	public void deleteStudentData(Student student) {
		studentService.deleteStudentData(student);
	}

	@DeleteMapping("/deleteAllStudents")
	public void deleteAllStudentsData() {
		studentService.deleteAllStudentData();
	}
}
