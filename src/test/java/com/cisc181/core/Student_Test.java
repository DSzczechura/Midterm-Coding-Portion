package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Course> CourseTest = new ArrayList<Course>();
	static ArrayList<Semester> SemesterTest = new ArrayList<Semester>();
	static ArrayList<Section> SectionTest = new ArrayList<Section>();
	static ArrayList<Student> StudentTest = new ArrayList<Student>();
	
	@BeforeClass
	public static void setup() throws PersonException {
		Course Chemistry = new Course(UUID.randomUUID(), "Chemistry", 100, eMajor.CHEM);
		CourseTest.add(Chemistry);
		
		Course Calculus = new Course(UUID.randomUUID(), "Calculus", 100, eMajor.COMPSI);
		CourseTest.add(Calculus);
		
		Course Accounting = new Course(UUID.randomUUID(), "Accounting", 100, eMajor.BUSINESS);
		CourseTest.add(Accounting);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2015, Calendar.SEPTEMBER, 1);
		Date Start_Fall = cal.getTime();
		
		cal.set(2015, Calendar.DECEMBER, 15);
		Date End_Fall = cal.getTime();
		
		Semester Fall = new Semester(UUID.randomUUID(), Start_Fall, End_Fall);
		SemesterTest.add(Fall);
		
		cal.set(2016, Calendar.FEBRUARY, 8);
		Date Start_Spring = cal.getTime();
		
		cal.set(2016, Calendar.MAY, 20);
		Date End_Spring = cal.getTime();
		
		Semester Spring = new Semester(UUID.randomUUID(), Start_Spring, End_Spring);
		SemesterTest.add(Spring);
		
		Section Chemistry_Fall = new Section(Chemistry.getCourseID(), Fall.getSemesterID(), 
				UUID.randomUUID(), 001);
		SectionTest.add(Chemistry_Fall);
		
		Section Chemistry_Spring = new Section(Chemistry.getCourseID(), Spring.getSemesterID(),
				UUID.randomUUID(), 001);
		SectionTest.add(Chemistry_Spring);
		
		Section Calculus_Fall = new Section(Calculus.getCourseID(), Fall.getSemesterID(), 
				UUID.randomUUID(), 002);
		SectionTest.add(Calculus_Fall);
		
		Section Calculus_Spring = new Section(Calculus.getCourseID(), Spring.getSemesterID(),
				UUID.randomUUID(), 002);
		SectionTest.add(Calculus_Spring);
		
		Section Accounting_Fall = new Section(Accounting.getCourseID(), Fall.getSemesterID(), 
				UUID.randomUUID(), 003);
		SectionTest.add(Accounting_Fall);
		
		Section Accounting_Spring = new Section(Accounting.getCourseID(), Spring.getSemesterID(),
				UUID.randomUUID(), 003);
		SectionTest.add(Accounting_Spring);
		
		cal.set(1997,Calendar.OCTOBER, 8);
		Date DOB = cal.getTime();
		
		Student Student_1 = new Student("Daniel", "Stephen", "Szczechura", DOB, eMajor.COMPSI,
				"316 Peach Peddler Path, Dover, DE 19901", "(302)-423-0336", "danielsz@udel.edu");
		StudentTest.add(Student_1);
		
		Student Student_2 = new Student("Joshua", "Alan", "Diehl", DOB, eMajor.BUSINESS,
				"", "(302)-492-0342", "joshd@udel.edu");
		StudentTest.add(Student_2);
		
		Student Student_3 = new Student("Thomas", "Cole", "Ford", DOB, eMajor.COMPSI,
				"", "(302)-111-3333", "colef@udel.edu");
		StudentTest.add(Student_3);
		
		Student Student_4 = new Student("Julie", "Lynn", "Barnett", DOB, eMajor.CHEM,
				"", "(302)-122-3533", "julieb@udel.edu");
		StudentTest.add(Student_4);
		
		Student Student_5 = new Student("Brad", "Christian", "London", DOB, eMajor.PHYSICS,
				"", "(302)-331-9998", "bradl@udel.edu");
		StudentTest.add(Student_5);
		
		Student Student_6 = new Student("William", "Alex", "Jones", DOB, eMajor.PHYSICS,
				"", "(302)-442-6767", "williamj@udel.edu");
		StudentTest.add(Student_6);
		
		Student Student_7 = new Student("Brandon", "James", "Smith", DOB, eMajor.BUSINESS,
				"", "(302)-102-3641", "brandonsf@udel.edu");
		StudentTest.add(Student_7);
		
		Student Student_8 = new Student("Ashley", "Sarah", "Caspar", DOB, eMajor.NURSING,
				"", "(302)-226-3333", "ashley@udel.edu");
		StudentTest.add(Student_8);
		
		Student Student_9 = new Student("James", "Paul", "Blake", DOB, eMajor.CHEM,
				"", "(302)-099-2121", "colef@udel.edu");
		StudentTest.add(Student_9);
		
		Student Student_10 = new Student("Brooke", "Madison", "Sanders", DOB, eMajor.COMPSI,
				"", "(302)-812-5309", "Brookes@udel.edu");
		StudentTest.add(Student_10);
	}

	@Test
	public void EnrollmentGradeTest() {
		
		//Chemistry
		
		Enrollment Enrollment_Student1 = new Enrollment(StudentTest.get(0).getStudentID(), 
				SectionTest.get(0).getSectionID());
		Enrollment_Student1.SetGrade(100);
		
		double Enrollment_Student1_GPA = Enrollment_Student1.getGrade()/25;
		assertEquals((Enrollment_Student1_GPA), 4.0, 0.1);
		
		Enrollment Enrollment_Student2 = new Enrollment(StudentTest.get(1).getStudentID(), 
				SectionTest.get(1).getSectionID());
		Enrollment_Student2.SetGrade(50);
		
		double Enrollment_Student2_GPA = Enrollment_Student2.getGrade()/25;
		assertEquals((Enrollment_Student2_GPA), 2.0, 0.1);
		
		//Calculus
		
		Enrollment Enrollment_Student3 = new Enrollment(StudentTest.get(2).getStudentID(), 
				SectionTest.get(2).getSectionID());
		Enrollment_Student3.SetGrade(100);
		
		double Enrollment_Student3_GPA = Enrollment_Student3.getGrade()/25;
		assertEquals((Enrollment_Student3_GPA), 4.0, 0.1);
		
		Enrollment Enrollment_Student4 = new Enrollment(StudentTest.get(3).getStudentID(), 
				SectionTest.get(3).getSectionID());
		Enrollment_Student4.SetGrade(90);
		
		double Enrollment_Student4_GPA = Enrollment_Student4.getGrade()/25;
		assertEquals((Enrollment_Student4_GPA), 3.6, 0.1);
		
		//Accounting
		
		Enrollment Enrollment_Student5 = new Enrollment(StudentTest.get(4).getStudentID(), 
				SectionTest.get(4).getSectionID());
		Enrollment_Student5.SetGrade(100);
		
		double Enrollment_Student5_GPA = Enrollment_Student5.getGrade()/25;
		assertEquals((Enrollment_Student5_GPA), 4.0, 0.1);
		
		Enrollment Enrollment_Student6 = new Enrollment(StudentTest.get(5).getStudentID(), 
				SectionTest.get(5).getSectionID());
		Enrollment_Student6.SetGrade(70);
		
		double Enrollment_Student6_GPA = Enrollment_Student6.getGrade()/25;
		assertEquals((Enrollment_Student6_GPA), 2.8, 0.1);
		
		//Chemistry
		
		Enrollment Enrollment_Student7 = new Enrollment(StudentTest.get(6).getStudentID(), 
				SectionTest.get(0).getSectionID());
		Enrollment_Student7.SetGrade(100);
		
		double Enrollment_Student7_GPA = Enrollment_Student7.getGrade()/25;
		assertEquals((Enrollment_Student7_GPA), 4.0, 0.1);
		
		Enrollment Enrollment_Student8 = new Enrollment(StudentTest.get(7).getStudentID(), 
				SectionTest.get(1).getSectionID());
		Enrollment_Student8.SetGrade(60);
		
		double Enrollment_Student8_GPA = Enrollment_Student8.getGrade()/25;
		assertEquals((Enrollment_Student8_GPA), 2.4, 0.1);
		
		//Calculus
		
		Enrollment Enrollment_Student9 = new Enrollment(StudentTest.get(8).getStudentID(), 
				SectionTest.get(2).getSectionID());
		Enrollment_Student9.SetGrade(100);
		
		double Enrollment_Student9_GPA = Enrollment_Student9.getGrade()/25;
		assertEquals((Enrollment_Student9_GPA), 4.0, 0.1);
		
		Enrollment Enrollment_Student10 = new Enrollment(StudentTest.get(9).getStudentID(), 
				SectionTest.get(3).getSectionID());
		Enrollment_Student10.SetGrade(80);
		
		double Enrollment_Student10_GPA = Enrollment_Student10.getGrade()/25;
		assertEquals((Enrollment_Student10_GPA), 3.2, 0.1);
		
		double chemistry_total_grade =(Enrollment_Student1_GPA + Enrollment_Student2_GPA + 
									Enrollment_Student7_GPA + Enrollment_Student8_GPA);
		
		double chemistry_gpa = (chemistry_total_grade/4);
		
		assertEquals(chemistry_gpa, 3.1, 0.1);
		
		double calculus_total_grade =(Enrollment_Student3_GPA + Enrollment_Student4_GPA + 
				Enrollment_Student9_GPA + Enrollment_Student10_GPA);

		double calculus_gpa = (calculus_total_grade/4);
		
		assertEquals(calculus_gpa, 3.7, 0.1);
		
		double accounting_total_grade =(Enrollment_Student5_GPA + Enrollment_Student6_GPA);

		double accounting_gpa = (accounting_total_grade/2);
		
		assertEquals(accounting_gpa, 3.4, 0.1);
			
	}
	
	@Test
	public void MajorChangeTest() {
		StudentTest.get(0).setMajor(eMajor.NURSING);
		assertEquals(StudentTest.get(0).getMajor(), eMajor.NURSING);
	}
}