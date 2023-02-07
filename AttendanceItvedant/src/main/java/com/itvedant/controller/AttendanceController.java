package com.itvedant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.itvedant.model.EmployeeInfo;
import com.itvedant.service.AttendanceService;
import com.itvedant.service.Serviceatt;


@RestController
public class AttendanceController {
	
	@Autowired
	Serviceatt attendanceService;

	@GetMapping("/getproduct")
   	public String getproduct() {

   	 return "hello";
   	}
	
	
	@GetMapping("/getEmplMonthlyAttendaceInfo/{emplid}/{month}")
	public List<EmployeeInfo> getEmployeeMonthlyInfo(@PathVariable int emplid,@PathVariable String month) {
	
		return attendanceService.getEmplInfo(emplid,month);
				
		
	}
	
	@GetMapping("/getallempldata")
	public List<EmployeeInfo> getEmployeeallinfo() {
	
		return attendanceService.getEmplAllInfo();
				
		
	}
	
	
//	@PostMapping("/createEmplData")
//	public EmployeeInfo createEmplData(@RequestBody EmplData empl) {
//	
//		return attendanceService.createdata(empl);		
//		
//	}

//	@PutMapping("/updateEmplData")
//	public EmployeeInfo updateEmplData(@RequestBody EmplData empl) {
//	
//		return attendanceService.updatedata(empl);		
//		
//	}
	
	@DeleteMapping("/deleteEmplData/{emplid}")
	public void deleteEmplData(@PathVariable String emplid) {
	
		attendanceService.deletedata(emplid);		
		
	}
	
//	@PostMapping("/toMarkAttendance")
//	public EmployeeInfo attendanceStatus(@RequestBody EmplData empl) {
//	
//		return attendanceService.attandancedata(empl);		
//		
//	}
	
}
