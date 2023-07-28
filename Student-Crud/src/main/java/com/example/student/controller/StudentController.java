package com.example.student.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.student.dao.StudentDao;
import com.example.student.entity.StudentEntity;
import com.example.student.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
public class StudentController {

	@Autowired 
	StudentRepository studRepo;

	@GetMapping("/students")
  public List<StudentEntity> studentList(){
		
		return studRepo.findAll();
	}

	@PostMapping("/savestudent")
   public StudentEntity savestudent(@RequestBody StudentDao stdao) {
	    StudentEntity student = new StudentEntity();
	    student.setStudentName(stdao.getStudentName());
	    student.setStudentRoll(stdao.getStudentRoll()); 
	    student.setCity(stdao.getCity());
		//student.setStudentId(stdao.getStudentId());
	      return studRepo.save(student);
	}

	@PutMapping("/updatestudent")
	public StudentEntity updateStudent(@RequestBody StudentDao stdao) {
		// Get the studentId from the request body
		Long studentId = stdao.getStudentId();

		// Find the student by studentId
		Optional<StudentEntity> studentOp = studRepo.findById(studentId);

		if (studentOp.isPresent()) {
			StudentEntity student = studentOp.get();
			student.setStudentName(stdao.getStudentName());
			student.setStudentRoll(stdao.getStudentRoll());
			student.setCity(stdao.getCity());

			// No need to set the studentId as it's already fetched from the request body
			// student.setStudentId(stdao.getStudentId());

			return studRepo.save(student);
		} else {
			// Handle the case when the student with the provided studentId is not found
			throw new RuntimeException("Student with ID " + studentId + " not found.");
		}
	}

	@DeleteMapping("/deletestudent")
	public void deleteStudent(@RequestBody StudentDao stdao) {
		
		Optional<StudentEntity> studentOp= studRepo.findById(stdao.getStudentId());
		 StudentEntity student = studentOp.get();
		 studRepo.delete(student);

	}

}
