import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// ================ For testing ==============================
//		ArrayList<Category> categoriesList = new ArrayList<Category>();
//
//		categoriesList.add(new Category("Performing arts"));
//		categoriesList.add(new Category("Uniform Groups"));
//		categoriesList.add(new Category("Information Technology"));
//		categoriesList.add(new Category("Clubs"));
//
//		ArrayList<CCA> ccaList = new ArrayList<CCA>();
//		ccaList.add(new CCA("Uniform Group", "Red Cross", "Youths learning basic first aid", 20, "Friday", "3PM",
//				"Hall", "Mr Teng"));
//		ccaList.add(new CCA("Perfoming Arts", "Dance", "Youths uniting as one to dance", 30, "Friday", "3.30PM",
//				"Dance Studio", "Mrs Woo Woo"));
//
//		C206_CaseStudy.viewAllCategories(categoriesList);
//
//		C206_CaseStudy.viewAllCCAs(ccaList);
		// ===========================================================


		
		//Maintaining student accounts (add,view,delete)
		ArrayList<Student> studentList = new ArrayList<>();
		int option = 0;

	    while (option != 4) {

	      C206_CaseStudy.Studentmenu();
	      option = Helper.readInt("Enter an option > ");

	      if (option == 1) {
	        // Add a new item
	        C206_CaseStudy.setHeader("ADD STUDENT");
	          // Add student
	          Student student = inputStudent();
	          C206_CaseStudy.addStudent(studentList, student);
	          System.out.println("Student added");
	       

	      } else if (option == 2) {
	        // View all items
	    	C206_CaseStudy.setHeader("STUDENT LIST");	    	  
	        C206_CaseStudy.viewAllStudent(studentList);

	      } else if (option == 3) {
	        // Delete Student
	        C206_CaseStudy.setHeader("DELETE");      
	          // Delete parent
	        C206_CaseStudy.deleteAllStudent(studentList);

	      } else if (option == 4) {
	        System.out.println("Bye!");
	        
	      } else {
	        System.out.println("Invalid option");
	      }
	    }
		//===================================================================
		
			
		
		
		//Maintaining parent accounts (add,view,delete)

		int option = 0;

		while (option != 4) {

			C206_CaseStudy.Parentmenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");
				// Add student
				Parent parent = inputParent();
				C206_CaseStudy.addParent(parentList, parent);
				System.out.println("Parent added");

			} else if (option == 2) {
				// View all items
				C206_CaseStudy.viewAllParent(parentList);

			} else if (option == 3) {
				// Delete Student
				C206_CaseStudy.setHeader("DELETE");
				// Delete parent
				C206_CaseStudy.deleteAllParent(parentList);

			} else if (option == 4) {
				System.out.println("Bye!");

			} else {
				System.out.println("Invalid option");
			}
		}
		// ===================================================================

		// Maintaining CCA Categories (add,view,delete)
		ArrayList<Category> catList = new ArrayList<Category>();
		int option = 0;

		while (option != 4) {

			C206_CaseStudy.ccaCatMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD CCA CATEGORY");
				// Add student
				Category category = inputCategory();
				C206_CaseStudy.addCategory(catList, category);
				System.out.println("Category added");

			} else if (option == 2) {
				// View all items
				C206_CaseStudy.setHeader("VIEW ALL CCA CATEGORIES");
				C206_CaseStudy.viewAllCategories(catList);

			} else if (option == 3) {
				C206_CaseStudy.setHeader("DELETE CCA CATEGORY");
				// Delete parent
				C206_CaseStudy.deleteCategory(catList);

			} else if (option == 4) {
				System.out.println("Bye!");

			} else {
				System.out.println("Invalid option");
			}
		}
		// ===================================================================

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// View all CCA details
	public static String retrieveAllCCAs(ArrayList<CCA> detailList) {
		String output = "";

		for (int i = 0; i < detailList.size(); i++) {
			output += String.format("%-20s %-40s %-20d %-10s %-10s %-20s %-30s \n", detailList.get(i).getTitle(),
					detailList.get(i).getDescription(), detailList.get(i).getClassSize(), detailList.get(i).getDay(),
					detailList.get(i).getTime(), detailList.get(i).getVenue(), detailList.get(i).getInstructor());

		}
		return output;

	}

	public static void viewAllCCAs(ArrayList<CCA> detailList) {
		setHeader("View All CCA details");
		String output = String.format("%-20s %-40s %-20s %-10s %-10s %-20s %-30s \n", "TITLE", "DESCRIPTION",
				"CLASS SIZE", "DAY", "TIME", "VENUE", "INSTRUCTOR");
		output += retrieveAllCCAs(detailList);
		System.out.println(output);

	}

	// For maintaining Student accounts ==========================================================
	
			 public static void Studentmenu() {
			      C206_CaseStudy.setHeader("Maintaining student accounts");
			      System.out.println("1. Add Student");
			      System.out.println("2. View Student");
			      System.out.println("3. Delete Student");
			      System.out.println("4. Quit");
			      Helper.line(80, "-");
			    }
			 
			 //add student account
			 public static Student inputStudent() {
				 
			     String studentID = Helper.readString("Enter your student ID > ");
			     String student_Name = Helper.readString("Enter student Name > ");
			     String student_Class =  Helper.readString("Enter student class > ");
			     String teacher = Helper.readString("Enter classroom teacher > ");


			     Student student = new Student(studentID, student_Name, student_Class, teacher);
			     return student;
			      
			    }
			 public static void addStudent(ArrayList<Student> studentList, Student student) {
			      
			      studentList.add(student);
			    }
			 //view student account
			 public static String retrieveAllStudent(ArrayList<Student> studentList) {
				 String output = "";
				 for (int i = 0; i < studentList.size(); i++) {

				        output += String.format("%-15s %-15s %-30s %-15s %-15s\n",
				        	i+1,
				        	studentList.get(i).getStudentID(),
				        	studentList.get(i).getName(), 
				        	studentList.get(i).getS_Class(), 
				        	studentList.get(i).getTeacher());
				      }
				      return output;
				    }
			 public static void viewAllStudent(ArrayList<Student> studentList) {
			      
			      String output = String.format("%-15s %-15s %-30s %-15s %-15s\n","POSITION",
			    		  "Student ID","Student Name", "Student Class","Class Teacher");
			      output += retrieveAllStudent(studentList);
			      System.out.println(output);
			    }
			 
			 public static void deleteAllStudent(ArrayList<Student> studentList) {
				 viewAllStudent(studentList);			
				 for (int i = 0; i < studentList.size(); i++) {
				 
				 int delOption = Helper.readInt("Choose option to delete > ");
				 if (delOption == (i+1)) {
					 studentList.remove(i);
			    	 System.out.println("Student deleted");
				 }else {
					 System.out.println("Invalid option");
				 }
			     }				 
				 viewAllStudent(studentList);			

			 }
			//===========================================================================================		
		    
	

	// For maintaining Parent account==========================================================
	public static void Parentmenu() {
		C206_CaseStudy.setHeader("Maintaining parent accounts");
		System.out.println("1. Add Parent");
		System.out.println("2. View Parent");
		System.out.println("3. Delete Parent");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	// add parent account
	public static Parent inputParent() {

		String studentID = Helper.readString("Enter your student ID > ");
		String student_Name = Helper.readString("Enter student Name > ");
		String student_Class = Helper.readString("Enter student class > ");
		String teacher = Helper.readString("Enter classroom teacher > ");
		String name = Helper.readString("Enter parent name > ");
		String email = Helper.readString("Enter parent email > ");
		int contact = Helper.readInt("Enter your contact number > ");

		Parent Parent = new Parent(studentID, student_Name, student_Class, teacher, name, email, contact);
		return Parent;

	}

	public static void addParent(ArrayList<Parent> parentList, Parent parent) {

		parentList.add(parent);
	}

	// view parent account
	public static String retrieveAllParent(ArrayList<Parent> parentList) {
		String output = "";
		for (int i = 0; i < parentList.size(); i++) {

			output += String.format("%-15s %-15s %-30s %-15d %-15s %-15s %-15s %-15s\n", i + 1,
					parentList.get(i).getParentName(), parentList.get(i).getEmail(), parentList.get(i).getContactNo(),
					parentList.get(i).getStudentID(), parentList.get(i).getName(), parentList.get(i).getS_Class(),
					parentList.get(i).getTeacher());
		}
		return output;
	}

	public static void viewAllParent(ArrayList<Parent> parentList) {
		C206_CaseStudy.setHeader("PARENT LIST");
		String output = String.format("%-15s %-15s %-30s %-15s %-15s %-15s %-15s %-15s\n", "POSITION", "Parent Name",
				"Email", "Contact Number", "Student ID", "Student Name", "Student Class", "Student Grade",
				"Class Teacher", "Contact Number");
		output += retrieveAllParent(parentList);
		System.out.println(output);
	}

	public static void deleteAllParent(ArrayList<Parent> parentList) {
		String output = String.format("%-15s %-15s %-30s %-15s %-15s %-15s %-15s\n", "POSITION", "Parent Name", "Email",
				"Contact Number", "Student ID", "Student Name", "Student Class", "Student Grade", "Class Teacher",
				"Contact Number");
		for (int i = 0; i < parentList.size(); i++) {
			output += String.format("%-15s %-15s %-30s %-15d %-15s %-15s %-15s %-15s\n", i + 1,
					parentList.get(i).getParentName(), parentList.get(i).getEmail(), parentList.get(i).getContactNo(),
					parentList.get(i).getStudentID(), parentList.get(i).getName(), parentList.get(i).getS_Class(),
					parentList.get(i).getTeacher());

			int delOption = Helper.readInt("Choose option to delete > ");
			if (delOption == (i + 1)) {
				parentList.remove(i);
				System.out.println("Parent deleted");
			} else {
				System.out.println("Invalid option");
			}
			System.out.println(output);
		}
	}
	// ===========================================================================================

	// For maintaining CCA categories==========================================================


	public static void ccaCatMenu() {
		C206_CaseStudy.setHeader("Maintaining CCA Categories");
		System.out.println("1. Add Category");
		System.out.println("2. View Category");
		System.out.println("3. Delete Category");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	// add cca category
	public static Category inputCategory() {

		String catName = Helper.readString("Enter the Category Name > ");

		Category category = new Category(catName);
		return category;

	}

	public static void addCategory(ArrayList<Category> catList, Category category) {

		catList.add(category);
	}

	// view categories
	public static String retrieveAllCategories(ArrayList<Category> catList) {
		String output = "";
		for (int i = 0; i < catList.size(); i++) {

			output += String.format("%-15s %-15s\n", i + 1, catList.get(i).getCatName());

		}
		return output;
	}

	public static void viewAllCategories(ArrayList<Category> catList) {

		if (retrieveAllCategories(catList) == "") {
			System.out.println("No categories found!");

		} else {
			String output = String.format("%-15s %-15s\n", "POSITION", "Category Name");
			output += retrieveAllCategories(catList);
			System.out.println(output);
		}
	}

	// delete category
	public static void deleteCategory(ArrayList<Category> catList) {
		viewAllCategories(catList);

		for (int i = 0; i < catList.size(); i++) {
			int delOption = Helper.readInt("Choose position to delete > ");
			if (delOption == (i + 1)) {
				catList.remove(i);
				System.out.println("Category deleted");
				Helper.line(80, "-");
			} else {
				System.out.println("Invalid option");
			}
		}
		viewAllCategories(catList);

	}
	// ===========================================================================================

}
