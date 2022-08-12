import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Student st1;
	private Student st2;
	
	private ArrayList<Student> studentList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		st1 = new Student("123456", "Peter", "C206", "Armstrong");
		st2 = new Student("654321", "Tom", "C203", "Zen");
		
		studentList= new ArrayList<Student>();

	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddStudent() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Student arraylist to add to", studentList);
		//Given an empty list, after adding 1 student, the size of the list is 1 - normal
		//The student just added is as same as the first student of the list
		C206_CaseStudy.addStudent(studentList, st1);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that Student is added", st1, studentList.get(0));
		
		//Add another Student. test The size of the list is 2? -normal
		//The item just added is as same as the second Student of the list
		C206_CaseStudy.addStudent(studentList, st2);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
		assertSame("Check that Student is added", st2, studentList.get(1));
	}
	
	@Test
	public void testRetrieveAllStudent() {
		// Test if Student list is not null but empty -boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);
		
		//test if the list of student retrieved from the CaseStudy is empty - boundary
		String allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
		
		//Given an empty list, after adding 2 Student, test if the size of the list is 2 - normal
		C206_CaseStudy.addStudent(studentList, st1);
		C206_CaseStudy.addStudent(studentList, st2);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());
		
		//test if the expected output string same as the list of student retrieved from the CaseStudy	
		allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		testOutput = String.format("%-15s %-15s %-30s %-15s %-15s\n","1",
	    		  "123456", "Peter","C206","Armstrong");
		testOutput += String.format("%-15s %-15s %-30s %-15s %-15s\n","2", 
				"654321", "Tom", "C203", "Zen" );
	
		assertEquals("Test that ViewAllCamcorderlist", testOutput, allStudent);

	}
	
	@Test
	public void testDelete() {
		
	}
	
	@After
	public void tearDown() throws Exception {
		st1 = null;
		st2 = null;
		studentList = null;
	}
}
