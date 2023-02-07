package com.itvedant.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.itvedant.model.EmplData;
import com.itvedant.model.EmployeeInfo;
import com.itvedant.repo.AttendRepo;
//import com.itvedant.repository.AttendanceRepository;

@Service
public class AttendanceService implements Serviceatt {

	@Autowired
	AttendRepo attendanceRepository;

	private Map<Integer, EmployeeInfo> attentMap = new HashMap<>();

	private AtomicInteger atomic = new AtomicInteger();

	public Object AttendanceService() {
		EmployeeInfo empl = new EmployeeInfo();
		empl.setEmplId(atomic.incrementAndGet());
		empl.setEmplName("Vijay");
		empl.setEmplSurname("Chauhan");
		empl.setEmplRole("Software Engg");
		empl.setAttendanceMonth("Feb");
		empl.setAttendanceStatus(true);
		empl.setAttendanceTime("01-02-2023 09:01:01");
		attentMap.put(empl.getEmplId(), empl);

		EmployeeInfo empl2 = new EmployeeInfo();
		empl.setEmplId(atomic.incrementAndGet());
		empl.setEmplName("Nirav");
		empl.setEmplSurname("Modi");
		empl.setEmplRole("Software Engg");
		empl.setAttendanceMonth("Feb");
		empl.setAttendanceStatus(true);
		empl.setAttendanceTime("01-02-2023 09:04:01");
		attentMap.put(empl2.getEmplId(), empl2);

		return attentMap;

	}

	public Collection<EmployeeInfo> getInfo() {
		return attentMap.values();
	}

	public List<EmployeeInfo> getEmplInfo(int emplid, String month) {

		return attendanceRepository.findmonthlydatabyid(emplid, month);

	}

//public EmployeeInfo createdata(EmplData empl) {
//	
//	EmployeeInfo emplInfo=new EmployeeInfo();
//	EmployeeInfo em=null;
//	em.setEmplName(empl.getEmplName());
//	em.setEmplRole(empl.getEmplRole());
//	em.setEmplSurname(empl.getEmplSurname());
//	
//	return attendanceRepository.save(em);
//}

//public EmployeeInfo updatedata(EmplData empl) {
//	int empid = Integer.parseInt(empl.getEmplId());
//	Optional<EmployeeInfo> employee=attendanceRepository.findById(empid);
//	EmployeeInfo em=employee.get();
//	
//	em.setEmplName(empl.getEmplName());
//	em.setEmplRole(empl.getEmplRole());
//	em.setEmplSurname(empl.getEmplSurname());
//	
//	
//	return attendanceRepository.save(em);
//}

	public void deletedata(String emplid) {
		// TODO Auto-generated method stub
		int empid = Integer.parseInt(emplid);

		attendanceRepository.deleteById(empid);
		;
	}

//public EmployeeInfo attandancedata(EmplData empl) {
//	
//	int empid = Integer.parseInt(empl.getEmplId());
//	Optional<EmployeeInfo> employee=attendanceRepository.findById(empid);
//	EmployeeInfo em=employee.get();
//	
//	em.setEmplName(empl.getEmplName());
//	em.setEmplSurname(empl.getEmplSurname());
//	em.setAttendanceStatus(true);
//	//em.setAttendanceTime(empl.getAttendanceTime());
//	
//	return attendanceRepository.save(em);
//}

	public List<EmployeeInfo> getEmplAllInfo() {
		// TODO Auto-generated method stub
		return attendanceRepository.findAll();
	}

}
