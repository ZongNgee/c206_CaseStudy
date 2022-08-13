import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Student st1;
	private Student st2;

	private Parent p1;
	private Parent p2;

	private CCA cca1;
	private CCA cca2;

	private Category ccaCat1;
	private Category ccaCat2;

	private ArrayList<Student> studentList;
	private ArrayList<Parent> parentList;
	private ArrayList<CCA> ccaList;
	private ArrayList<Category> ccaCatList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		st1 = new Student("123456", "Peter", "C206", "Armstrong");
		st2 = new Student("654321", "Tom", "C203", "Zen");

		p1 = new Parent("C123", "John", "W66Z", "Faci", "Adam", "adam@email.com", 91234321);
		p2 = new Parent("C321", "Mat", "E65F", "Faci", "Lim", "lim@email.com", 98765432);
		parentList = new ArrayList<Parent>();

		cca1 = new CCA("Uniform Group", "Red Cross", "Youths learning basic first aid", 20, "Friday", "3PM", "Hall",
				"Mr Teng");
		cca2 = new CCA("Perfoming Arts", "Dance", "Youths uniting as one to dance", 30, "Friday", "3.30PM",
				"Dance Studio", "Mrs Woo Woo");

		ccaCat1 = new Category("Performing arts");
		ccaCat2 = new Category("Uniform Groups");

		studentList = new ArrayList<Student>();
		ccaList = new ArrayList<CCA>();
		ccaCatList = new ArrayList<Category>();

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void testAddStudent() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Student arraylist to add to", studentList);
		// Given an empty list, after adding 1 student, the size of the list is 1 -
		// normal
		// The student just added is as same as the first student of the list
		C206_CaseStudy.addStudent(studentList, st1);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that Student is added", st1, studentList.get(0));

		// Add another Student. test The size of the list is 2? -normal
		// The item just added is as same as the second Student of the list
		C206_CaseStudy.addStudent(studentList, st2);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
		assertSame("Check that Student is added", st2, studentList.get(1));
	}
	
	@Test
	
	 public void testAddParent() {
	  // Item list is not null, so that can add a new item
	  assertNotNull("Test if there is valid Parent arraylist to add to", parentList);
	  //Given an empty list, after adding 1 item, the size of the list is 1
	   C206_CaseStudy.addParent(parentList, p1);  
	    assertEquals("Test if that Parent arraylist size is 1?", 1, parentList.size());
	    
	    //The item just added is as same as the first item of the list
	    assertSame("Test that Parent is added same as 1st item of the list?", p1, parentList.get(0));
	    
	    //Add another item. test The size of the list is 2?
	    C206_CaseStudy.addParent(parentList, p2);
	    assertEquals("Test that Parent arraylist size is 2?", 2, parentList.size());
	    assertSame("Test that Parent is added same as 2nd item of the list?", p2, parentList.get(1));
	   }

	@Test

	public void testAddCCA() {
		// Item list is not null, so that can add a new cca - boundary
		assertNotNull("Check if there is valid CCA arraylist to add to", ccaList);
		// Given an empty list, after adding 1 cca, the size of the list is 1 - normal
		// The cca just added is as same as the first cca of the list
		C206_CaseStudy.addCCA(ccaList, cca1);
		assertEquals("Check that CCA arraylist size is 1", 1, ccaList.size());
		assertSame("Check that CCA is added", cca1, ccaList.get(0));

		// Add another CCA. test The size of the list is 2? -normal
		// The item just added is as same as the second cca of the list
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Check that cca arraylist size is 2", 2, ccaList.size());
		assertSame("Check that cca is added", cca2, ccaList.get(1));
	}

	@Test

	public void testAddCCACategory() {
		// Item list is not null, so that can add a new cca category - boundary
		assertNotNull("Check if there is a valid CCA Category arraylist to add to", ccaCatList);
		// Given an empty list, after adding 1 category, the size of the list is 1 -
		// normal
		// The category just added is as same as the first category of the list
		C206_CaseStudy.addCategory(ccaCatList, ccaCat1);
		assertEquals("Check that CCA category arraylist size is 1", 1, ccaCatList.size());
		assertSame("Check that CCA category is added", ccaCat1, ccaCatList.get(0));

		// Add another category. test The size of the list is 2 -normal
		// The item just added is as same as the second category of the list
		C206_CaseStudy.addCategory(ccaCatList, ccaCat2);
		assertEquals("Check that cca category arraylist size is 2", 2, ccaCatList.size());
		assertSame("Check that category is added", ccaCat2, ccaCatList.get(1));
	}

	@Test
	public void testRetrieveAllStudent() {
		// Test if Student list is not null but empty -boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);

		// test if the list of student retrieved from the CaseStudy is empty - boundary
		String allStudent = C206_CaseStudy.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that viewAllStudent is empty", testOutput, allStudent);

		// Given an empty list, after adding 2 Student, test if the size of the list is
		// 2 - normal
		C206_CaseStudy.addStudent(studentList, st1);
		C206_CaseStudy.addStudent(studentList, st2);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());

		// test if the expected output string same as the list of student retrieved from
		// the CaseStudy
		allStudent = C206_CaseStudy.retrieveAllStudent(studentList);
		testOutput = String.format("%-15s %-15s %-30s %-15s %-15s\n", "1", "123456", "Peter", "C206", "Armstrong");
		testOutput += String.format("%-15s %-15s %-30s %-15s %-15s\n", "2", "654321", "Tom", "C203", "Zen");

		assertEquals("Test that viewAllStudent matches with the testOutput", testOutput, allStudent);

	}
	
	@Test
	 public void testRetrieveAllParent() {
	  // Test if Item list is not null but empty, so that can add a new item
	  assertNotNull("Test if there is valid Parent arraylist to add to", parentList);
	  //test if the list of parents retrieved from the SourceCentre is empty
	    String allParent= C206_CaseStudy.retrieveAllParent(parentList);
	    String testOutput = "";
	    assertSame("Check that ViewAllParentlist", testOutput, allParent);
	  //Given an empty list, after adding 2 items, test if the size of the list is 2
	    C206_CaseStudy.addParent(parentList, p1);
	    C206_CaseStudy.addParent(parentList, p2);
	    assertEquals("Test if that Parent arraylist size is 2?", 2, parentList.size());
	  //test if the expected output string same as the list of parents retrieved from the C206_CaseStudy
	    allParent = C206_CaseStudy.retrieveAllParent(parentList);
	    testOutput = String.format("%-15d %-15s %-30s %-15d %-15s %-15s %-15s %-15s\n",1,"Adam","adam@email.com",91234321,"C123","John","W66Z","Faci");
	    testOutput += String.format("%-15d %-15s %-30s %-15d %-15s %-15s %-15s %-15s\n",2,"Lim","lim@email.com",98765432,"C321","Mat","E65F","Faci");
	    assertEquals("Check that ViewAllParentlist", testOutput, allParent);
	   }

	@Test

	public void testRetrieveAllCCADetails() {
		// Test if cca list is not null -boundary
		assertNotNull("Test if there is valid CCA arraylist to retrieve item", ccaList);

		// test if the list of cca retrieved from the CaseStudy is empty - boundary
		String allCCAs = C206_CaseStudy.retrieveAllCCAs(ccaList);
		String testOutput = "";
		assertEquals("Check that viewAllCCAs is empty", testOutput, allCCAs);

		// Given an empty list, after adding 2 CCAs, test if the size of the list is 2 -
		// normal
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Test that CCA arraylist size is 2", 2, ccaList.size());

		// test if the expected output string same as the list of CCAs retrieved from
		// the CaseStudy
		allCCAs = C206_CaseStudy.retrieveAllCCAs(ccaList);
		testOutput = String.format("%-15s %-20s %-40s %-20d %-10s %-10s %-20s %-30s \n", "1", "Uniform Group",
				"Red Cross", "Youths learning basic first aid", 20, "Friday", "3PM", "Hall", "Mr Teng");

		testOutput += String.format("%-15s %-20s %-40s %-20d %-10s %-10s %-20s %-30s \n", "2", "Perfoming Arts",
				"Dance", "Youths uniting as one to dance", 30, "Friday", "3.30PM", "Dance Studio", "Mrs Woo Woo");

		assertEquals("Test that viewAllCCAs matches with the testOutput", testOutput, allCCAs);

	}

	@Test

	public void testRetrieveAllCategoryDetails() {
		// Test if category list is not null -boundary
		assertNotNull("Test if there is valid CCA category arraylist to retrieve item", ccaCatList);

		// test if the list of categories retrieved from the CaseStudy is empty -
		// boundary
		String allCategories = C206_CaseStudy.retrieveAllCategories(ccaCatList);
		String testOutput = "";
		assertEquals("Check that viewAllCategories is empty", testOutput, allCategories);

		// Given an empty list, after adding 2 categories, test if the size of the list
		// is 2 - normal
		C206_CaseStudy.addCategory(ccaCatList, ccaCat1);
		C206_CaseStudy.addCategory(ccaCatList, ccaCat2);

		assertEquals("Test that CCA category arraylist size is 2", 2, ccaCatList.size());

		// test if the expected output string same as the list of categories retrieved
		// from the CaseStudy
		allCategories = C206_CaseStudy.retrieveAllCategories(ccaCatList);
		testOutput = String.format("%-15s %-15s\n", "1", "Performing arts");

		testOutput += String.format("%-15s %-15s\n", "2", "Uniform Groups");

		assertEquals("Test that viewAllCCAs matches with the testOutput", testOutput, allCategories);

	}

	@Test
	public void testDeleteStudent() {
		// Test if Student list is not null too see if got any value to delete
		assertNotNull("Test if there is valid Student arraylist to delete", studentList);

		// One member added; one removed
		C206_CaseStudy.addStudent(studentList, st1);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());

		C206_CaseStudy.deleteStudent(studentList, 1);
		assertTrue("Check that the Student arraylist is empty", studentList.isEmpty());

		boolean exists = false;
		for (Student s : studentList) {
			if (s.equals(st1)) {
				exists = true;
			}
		}

		assertFalse("Test if the deleted student can't be delete again", exists);

		// Two members added; one removed
		C206_CaseStudy.addStudent(studentList, st1);
		C206_CaseStudy.addStudent(studentList, st2);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());

		C206_CaseStudy.deleteStudent(studentList, 2);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());

		exists = false;
		for (Student s : studentList) {
			if (s.equals(st2)) {
				exists = true;
			}
			assertFalse("Test if the deleted student can't be delete again", exists);
		}

	}
	
	 @Test
	    public void testRemoveParent(){
	         //One member added; one removed
	   C206_CaseStudy.addParent(parentList, p1);
	   assertEquals("Test if that Parent arraylist size is 1?", 1, parentList.size());
	   C206_CaseStudy.deleteAllParent(parentList);
	   assertEquals(0, parentList.size());

	         boolean exists = false;
	         for (int i = 0; i < parentList.size(); i++) {
	              if (parentList.get(i).equals(p1))
	                   exists = true;
	         }
	         assertFalse(exists);
	 }

	@Test
	public void testDeleteCCA() {
		// Test if cca list is not null -boundary
		assertNotNull("Test if there is valid CCA arraylist to delete from", ccaList);

		// Given an empty list, add 1 cca, and test if item has been added
				ccaList.add(cca1);
				assertEquals(1, ccaList.size());

				// Remove the cca that was added from the list, and test if the list is
				// empty - normal
				C206_CaseStudy.deleteCCA(ccaList, 1);
				assertTrue(ccaList.isEmpty());

				// Check that removed cca does not exist in the list - normal
				boolean exists = false;
				for (CCA cca : ccaList) {
					if (cca.equals(cca1))
						exists = true;
				}

				assertFalse("Test that the deleted cca is not found in the list", exists);

				// Given an empty list, add 1 category, and test if item has been added
				ccaList.add(cca1);
				ccaList.add(cca2);
				assertEquals(2, ccaList.size());

				// Remove the 1 of the cca that was added to the list, and test if the
				// list size is 1 - normal
				C206_CaseStudy.deleteCCA(ccaList, 2);
				assertEquals(1, ccaList.size());

				// Check that removed ccca does not exist in the list - normal
				for (CCA cca : ccaList) {
					if (cca.equals(cca2))
						exists = true;
				}

				assertFalse("Test that the deleted cca is not found in the list", exists);
	}
 
	@Test
	public void testDeleteCategory() {
		// Test if category list is not null -boundary
		assertNotNull("Test if there is valid CCA category arraylist to delete items from", ccaCatList);

		// Given an empty list, add 1 category, and test if item has been added
		ccaCatList.add(ccaCat1);
		assertEquals(1, ccaCatList.size());

		// Remove the category that was added from the list, and test if the list is
		// empty - normal
		C206_CaseStudy.deleteCategory(ccaCatList, 1);
		assertTrue(ccaCatList.isEmpty());

		// Check that removed category does not exist in the list - normal
		boolean exists = false;
		for (Category category : ccaCatList) {
			if (category.equals(ccaCat1))
				exists = true;
		}

		assertFalse("Test that the deleted category is not found in the list", exists);

		// Given an empty list, add 1 category, and test if item has been added
		ccaCatList.add(ccaCat1);
		ccaCatList.add(ccaCat2);
		assertEquals(2, ccaCatList.size());

		// Remove the 1 of the categories that was added to the list, and test if the
		// list size is 1 - normal
		C206_CaseStudy.deleteCategory(ccaCatList, 2);
		assertEquals(1, ccaCatList.size());

		// Check that removed category does not exist in the list - normal
		for (Category category : ccaCatList) {
			if (category.equals(ccaCat2))
				exists = true;
		}

		assertFalse("Test that the deleted category is not found in the list", exists);

	}

	@After
	public void tearDown() throws Exception {
		st1 = null;
		st2 = null;
		studentList = null;

		cca1 = null;
		cca2 = null;
		ccaList = null;

		ccaCat1 = null;
		ccaCat2 = null;
		ccaCatList = null;

		p1 = null;
		p2 = null;
		parentList = null;

	}
}
