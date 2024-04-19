package com.farhad.example.studentmanagementsystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.farhad.example.studentmanagementsystem.model.Student;
import com.farhad.example.studentmanagementsystem.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;

	public void addStudentData(Student studentDetail) {
		studentRepository.insert(studentDetail);
	}

	public void addMultipleStudentData(List<Student> studentDetails) {
		studentRepository.insert(studentDetails);
	}

	public List<Student> fetchAllStudentsData() {
		return studentRepository.findAll();
	}

	public Optional<Student> fetchStudentDataById(String id) {
		return studentRepository.findById(id);
	}

	public List<Student> fetchStudentDataByNameAndCgpa(String name, Double cgpa) {
		return studentRepository.findByNameAndCgpa(name, cgpa);
	}

	public Student fetchStudentDataByCity(String city) {
		return studentRepository.findByAddress_City(city);
	}

	public List<Student> fetchStudentDataByCountryOrArrears(String country, Boolean hasArrears) {
		return studentRepository.findByAddress_CountryOrHasArrears(country, hasArrears);
	}

	public List<Student> fetchStudentDataByCgpa(Double cgpa) {
		return studentRepository.findByCgpaGreaterThanEqual(cgpa);
	}

	public List<Student> fetchStudentDataByEnrollmentDate(LocalDate startDate, LocalDate endDate) {
		return studentRepository.findByEnrollmentDateBetweenOrderByEnrollmentDate(startDate, endDate);
	}

	public List<Student> fetchStudentDataByCgpaAndName(Double cgpa, String name) {
		return studentRepository.findByCgpaOrderByNameDesc(cgpa, name);
	}

	public Long fetchAverageCgpa() {
		return studentRepository.avgCgpa();
	}

	public String fetchStudentDataByName(String name) {
		return studentRepository.findByNameIgnoreCase(name);
	}

	public void deleteStudentData(Student studentDetails) {
		studentRepository.insert(studentDetails);
	}

	public void deleteAllStudentData() {
		studentRepository.deleteAll();
	}

}
