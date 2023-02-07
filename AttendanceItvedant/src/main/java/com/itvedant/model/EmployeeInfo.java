package com.itvedant.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emplId;
	
	private String emplName;
	
	private String emplSurname;
	
	private String emplRole;
	
	private String attendanceMonth;
	
	private boolean attendanceStatus;
	
	@JsonFormat(pattern="dd-mm-yyyy HH:mm:ss")
	private String attendanceTime;
}
