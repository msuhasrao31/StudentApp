package com.example.student.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@Table(name = "student")
@Entity
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	private String studentName;
	private String studentRoll;
	private String city;

	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentRoll() {
		return studentRoll;
	}
	public void setStudentRoll(String studentRoll) {
		this.studentRoll = studentRoll;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public StudentEntity(Long studentId, String studentName, String studentRoll, String city) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRoll = studentRoll;
		this.city = city;
	}
	
	public StudentEntity() {
		// TODO Auto-generated constructor stub
	}
	
}
