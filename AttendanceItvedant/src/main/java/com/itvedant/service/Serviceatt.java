package com.itvedant.service;

import java.util.Collection;
import java.util.List;

//import com.itvedant.model.EmplData;
import com.itvedant.model.EmployeeInfo;

public interface Serviceatt {
	
	
	List<EmployeeInfo> getEmplAllInfo();
	
//	EmployeeInfo attandancedata(EmplData empl);
	
	void deletedata(String emplid);
	
//	EmployeeInfo updatedata(EmplData empl);
	
	
	List<EmployeeInfo> getEmplInfo(int emplid, String month);
	
//	EmployeeInfo createdata(EmplData empl);
	
	Collection<EmployeeInfo> getInfo();
	
	Object AttendanceService();

}
