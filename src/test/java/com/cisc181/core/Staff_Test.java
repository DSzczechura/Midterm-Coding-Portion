package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

import java.util.Date;
import java.util.Calendar;

import com.cisc181.core.*;

public class Staff_Test {

	public static ArrayList<Staff> StaffTest;
	
	@BeforeClass
	public static void setup() throws PersonException {
		StaffTest = new ArrayList<Staff>();
		
		Calendar cal = Calendar.getInstance();
		cal.set(1997, Calendar.OCTOBER, 8);
		Date DOB = cal.getTime();
		
		cal.set(2015, Calendar.AUGUST, 15);
		Date employment_date = cal.getTime();
		
		Staff staff_1 = new Staff("Danny", "Hightide", "Szczechura", DOB, 
				"316 Peach Peddler Path, Dover, DE 19901", "(302)-423-0336", "danielsz@udel.edu",
				"Tuesday 1:00-3:00", 1, 30000.00, employment_date, eTitle.MR);
		
		StaffTest.add(staff_1);
		
		Staff staff_2 = new Staff("Sarah", "Supremecuts", "Szczechura", DOB, 
				"316 Peach Peddler Path, Dover, DE 19901", "(302)-423-0336", "sarahsz@udel.edu",
				"Tuesday 1:00-3:00", 1, 40000.00, employment_date, eTitle.MS);
		
		StaffTest.add(staff_2);
		
		Staff staff_3 = new Staff("Aliyah", "Yogurl", "Nelson", DOB, 
				"316 Peach Peddler Path, Dover, DE 19901", "(302)-423-0336", "aliyahn@udel.edu",
				"Tuesday 1:00-3:00", 1, 35000.00, employment_date, eTitle.MS);
		
		StaffTest.add(staff_3);
		
		Staff staff_4 = new Staff("Kevin", "Noseisis", "Doak", DOB, 
				"316 Peach Peddler Path, Dover, DE 19901", "(302)-423-0336", "kevind@udel.edu",
				"Tuesday 1:00-3:00", 1, 45000.00, employment_date, eTitle.MR);
		
		StaffTest.add(staff_4);
		
		Staff staff_5 = new Staff("Rachel", "Turkey", "Wilson", DOB, 
				"316 Peach Peddler Path, Dover, DE 19901", "(302)-423-0336", "rachelw@udel.edu",
				"Tuesday 1:00-3:00", 1, 20000.00, employment_date, eTitle.MS);
		
		StaffTest.add(staff_5);
	}
	
	@Test
	public void SalaryTest() {
		
		double sum = 0.0;
		int i = 0;
		
		for(Staff x : StaffTest){
			i++;
			sum += x.getSalary();
		}
		
		double actual = (sum/i);
		double expected = 34000;
		assertEquals(actual, expected, 0.01);
	}	
	
	@Test(expected = com.cisc181.core.PersonException.class)
	public void DOBTest() throws PersonException {
		Calendar cal = Calendar.getInstance();
		cal.set(1900, Calendar.FEBRUARY, 2);
		Date DOB = cal.getTime();
		
		cal.set(2015, Calendar.AUGUST, 15);
		Date employment_date = cal.getTime();
		
		Staff old_man =  new Staff("Old", "Man", "Jenkins", DOB, 
				"316 Peach Peddler Path, Dover, DE 19901", "(302)-423-0336", "oldmj@udel.edu",
				"Tuesday 1:00-3:00", 1, 30000.00, employment_date, eTitle.MR);
	}
	
	@Test(expected = com.cisc181.core.PersonException.class)
	public void PhoneNumberTest() throws PersonException {
		Calendar cal = Calendar.getInstance();
		cal.set(1994, Calendar.FEBRUARY, 2);
		Date DOB = cal.getTime();
		
		cal.set(2015, Calendar.AUGUST, 15);
		Date employment_date = cal.getTime();
		
		Staff funky_phonenumber =  new Staff("Funky", "Phone", "Number", DOB, 
				"316 Peach Peddler Path, Dover, DE 19901", "423-0336", "funkypn@udel.edu",
				"Tuesday 1:00-3:00", 1, 30000.00, employment_date, eTitle.MR);
	}

}
