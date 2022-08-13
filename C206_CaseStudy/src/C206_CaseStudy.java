import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// ================Database==============================
		ArrayList<Category> catList = new ArrayList<Category>();

		catList.add(new Category("Performing arts"));
		catList.add(new Category("Uniform Groups"));
		catList.add(new Category("Information Technology"));
		catList.add(new Category("Clubs"));

		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ccaList.add(new CCA("Uniform Group", "Red Cross", "Youths learning basic first aid", 20, "Friday", "3PM",
				"Hall", "Mr Teng"));
		ccaList.add(new CCA("Perfoming Arts", "Dance", "Youths uniting as one to dance", 30, "Friday", "3.30PM",
				"Dance Studio", "Mrs Woo Woo"));

		ArrayList<Parent> parentList = new ArrayList<>();
		parentList.add(new Parent("202122", "John", "P3", "Mrs Smith", "Mr Michael", "michael@gmail.com", 91234567));
		parentList.add(new Parent("202123", "Mary", "P2", "Mrs Catherine", "Mrs Marie", "marie@gmail.com", 91234568));
		parentList.add(new Parent("202124", "Crystal", "P6", "Mrs Jenjen", "Mr Shaun", "shaun@gmail.com", 91234569));

		ArrayList<Student> studentList = new ArrayList<>();
		studentList.add(new Student("202122", "John", "P3", "Mrs Smith"));
		studentList.add(new Student("202123", "Mary", "P2", "Mrs Catherine"));
		studentList.add(new Student("202124", "Crystal", "P6", "Mrs Jenjen"));

		ArrayList<Users> coordinatorList = new ArrayList<>();
		coordinatorList.add(new Users("Jacob", "hello123", "Coordinator"));
		coordinatorList.add(new Users("Mabel", "12345", "Coordinator"));

		ArrayList<Users> adminList = new ArrayList<>();
		adminList.add(new Users("Michelle", "hello345", "Admin"));
		adminList.add(new Users("George", "34567", "Admin"));

		// ===========================================================

		C206_CaseStudy.loginMenu();
		int loginOption = Helper.readInt("Enter an option > ");

		if (loginOption == 1) { // login as parent

			boolean isLoggedIn = false;
			while (isLoggedIn == false) {
				Parent enteredInfo = inputParent();

				if (studAccExists(studentList, enteredInfo)) {
					isLoggedIn = true;
					System.out.println("Logged in successfully.");

				} else {
					System.out.println("Login unsuccessful, please try again!");
				}
			}

		} else if (loginOption == 2) { // login as student

			boolean isLoggedIn = false;
			while (isLoggedIn == false) {
				Student enteredInfo = inputStudent();

				if (studAccExists(studentList, enteredInfo)) {
					isLoggedIn = true;
					System.out.println("Logged in successfully.");

				} else {
					System.out.println("Login unsuccessful, please try again!");
				}
			}

		} else if (loginOption == 3) { // login as coordinator
			boolean isLoggedIn = false;
			while (isLoggedIn == false) {
				String username = Helper.readString("Enter your username > ");
				String password = Helper.readString("Enter your password > ");
				Users enteredInfo = new Users(username, password, "Coordinator");

				if (coordinatorAccExists(coordinatorList, enteredInfo)) {
					isLoggedIn = true;
					System.out.println("Logged in successfully.\n");

					coordinatorMenu();
					int coOption = Helper.readInt("Enter an option > ");

					if (coOption == 1) { // maintain cca
						// Maintaining CCAs (add,view,delete)
						int ccaOption = 0;

						while (ccaOption != 4) {

							C206_CaseStudy.ccaMenu();
							ccaOption = Helper.readInt("Enter an option > ");

							if (ccaOption == 1) {
								// Add a new detail
								C206_CaseStudy.setHeader("ADD CCA DETAILS");
								// Add student
								CCA cca = inputCCA();
								C206_CaseStudy.addCCA(ccaList, cca);
								System.out.println("CCA detail added");

							} else if (ccaOption == 2) {
								// View all details
								C206_CaseStudy.setHeader("VIEW ALL CCA DETAILS");
								C206_CaseStudy.viewAllCCAs(ccaList);

							} else if (ccaOption == 3) {
								C206_CaseStudy.setHeader("DELETE CCA");
								// Delete parent
								viewAllCCAs(ccaList);
								int delOption = Helper.readInt("Choose position to delete > ");
								C206_CaseStudy.deleteCCA(ccaList, delOption);

							} else if (ccaOption == 4) {
								System.out.println("Bye!");

							} else {
								System.out.println("Invalid option");
							}
						}
						// ===================================================================

					} else if (coOption == 2) { // maintain cca categories

						// Maintaining CCA Categories (add,view,delete)
						int ccaCatOption = 0;
						while (ccaCatOption != 4) {

							C206_CaseStudy.ccaCatMenu();
							ccaCatOption = Helper.readInt("Enter an option > ");

							if (ccaCatOption == 1) {
								// Add a new item
								C206_CaseStudy.setHeader("ADD CCA CATEGORY");
								// Add student
								Category category = inputCategory();
								C206_CaseStudy.addCategory(catList, category);
								System.out.println("Category added");

							} else if (ccaCatOption == 2) {
								// View all items
								C206_CaseStudy.setHeader("VIEW ALL CCA CATEGORIES");
								C206_CaseStudy.viewAllCategories(catList);

							} else if (ccaCatOption == 3) {
								C206_CaseStudy.setHeader("DELETE CCA CATEGORY");
								// Delete parent
								viewAllCategories(catList);
								int delOption = Helper.readInt("Choose position to delete > ");
								C206_CaseStudy.deleteCategory(catList, delOption);

							} else if (ccaCatOption == 4) {
								System.out.println("Bye!");

							} else {
								System.out.println("Invalid option");
							}
						}
						// ===================================================================

					} else if (coOption == 3) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}

				} else {
					System.out.println("Login unsuccessful, please try again!\n");
				}
			}

		} else if (loginOption == 4) { // login as an admin

			boolean isLoggedIn = false;
			while (isLoggedIn == false) {
				String username = Helper.readString("Enter your username > ");
				String password = Helper.readString("Enter your password > ");
				Users enteredInfo = new Users(username, password, "Admin");

				if (adminAccExists(adminList, enteredInfo)) {
					isLoggedIn = true;
					System.out.println("Logged in successfully.\n");

					adminMenu();
					int adminOption = Helper.readInt("Enter an option > ");

					if (adminOption == 1) { // maintain students
						// Maintaining student accounts (add,view,delete)

						int studOption = 0;

						while (studOption != 4) {

							C206_CaseStudy.studentMenu();
							studOption = Helper.readInt("Enter an option > ");

							if (studOption == 1) {
								// Add a new item
								C206_CaseStudy.setHeader("ADD STUDENT");
								// Add student
								Student student = inputStudent();
								C206_CaseStudy.addStudent(studentList, student);
								System.out.println("Student added");

							} else if (studOption == 2) {
								// View all items
								C206_CaseStudy.setHeader("STUDENT LIST");
								C206_CaseStudy.viewAllStudent(studentList);

							} else if (studOption == 3) {
								// Delete Student
								C206_CaseStudy.setHeader("DELETE");
								viewAllStudent(studentList);
								int delOption = Helper.readInt("Choose option to delete > ");
								C206_CaseStudy.deleteStudent(studentList, delOption);

							} else if (studOption == 4) {
								System.out.println("Bye!");

							} else {
								System.out.println("Invalid option");
							}
						}
						// ===================================================================

					} else if (adminOption == 2) { // maintain parents
						// Maintaining parent accounts (add,view,delete)

						int parentOption = 0;

						while (parentOption != 4) {

							C206_CaseStudy.Parentmenu();
							parentOption = Helper.readInt("Enter an option > ");

							if (parentOption == 1) {
								// Add a new item
								C206_CaseStudy.setHeader("ADD PARENT ACCOUNT");
								// Add student
								Parent parent = inputParent();
								C206_CaseStudy.addParent(parentList, parent);
								System.out.println("Parent added");

							} else if (parentOption == 2) {
								// View all items
								C206_CaseStudy.setHeader("PARENT LIST");
								C206_CaseStudy.viewAllParent(parentList);

							} else if (parentOption == 3) {
								// Delete Student
								C206_CaseStudy.setHeader("DELETE PARENT ACCOUNT");
								// Delete parent
								C206_CaseStudy.deleteAllParent(parentList);

							} else if (parentOption == 4) {
								System.out.println("Bye!");

							} else {
								System.out.println("Invalid option");
							}
						}
						// ===================================================================

					} else if (adminOption == 3) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid Option");
					}

				} else {
					System.out.println("Login unsuccessful, please try again!\n");
				}
			}

		} else if (loginOption == 5) {
			System.out.println("Bye!");
		} else {
			System.out.println("Invalid Option");
		}

	}

	public static void setHeader(String header) {
		Helper.line(160, "-");
		System.out.println(header);
		Helper.line(160, "-");
	}

	public static void loginMenu() {
		System.out.println("1. Login as a Parent");
		System.out.println("2. Login as a Student");
		System.out.println("3. Login as a CCA Coordinator");
		System.out.println("4. Login as an Admin");
		System.out.println("5. Quit");
		Helper.line(160, "-");
	}

	public static void coordinatorMenu() {
		System.out.println("1. Maintain CCA");
		System.out.println("2. Maintain CCA Categories");
		System.out.println("3. Quit");
		Helper.line(160, "-");
	}

	public static void adminMenu() {
		System.out.println("1. Maintain Students");
		System.out.println("2. Maintain Parents");
		System.out.println("3. Quit");
		Helper.line(160, "-");
	}

	public static boolean coordinatorAccExists(ArrayList<Users> coordinatorList, Users enteredAcc) {
		boolean exists = false;

		for (int i = 0; i < coordinatorList.size(); i++) {
			Users coordinator = coordinatorList.get(i);

			if (coordinator.getUsername().equals(enteredAcc.getUsername())
					&& coordinator.getPassword().equals(enteredAcc.getPassword())
					&& coordinator.getRole().equals("Coordinator")) {
				exists = true;
			}

		}
		return exists;
	}
	public static boolean adminAccExists(ArrayList<Users> adminList, Users enteredAcc) {
		boolean exists = false;
		
		for (int i = 0; i < adminList.size(); i++) {
			Users admin = adminList.get(i);
			
			if (admin.getUsername().equals(enteredAcc.getUsername())
					&& admin.getPassword().equals(enteredAcc.getPassword())
					&& admin.getRole().equals("Admin")) {
				exists = true;
			}
			
		}
		return exists;
	}

	public static boolean studAccExists(ArrayList<Student> studentList, Student enteredAcc) {
		boolean exists = false;

		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);

			if (student.getStudentID().equals(enteredAcc.getStudentID())
					&& student.getName().equalsIgnoreCase(enteredAcc.getName())
					&& student.getS_Class().equalsIgnoreCase(enteredAcc.getS_Class())
					&& student.getTeacher().equalsIgnoreCase(enteredAcc.getTeacher())) {
				exists = true;
			}
		}
		return exists;
	}

	// For maintaining Student accounts
	// ==========================================================

	public static void studentMenu() {
		C206_CaseStudy.setHeader("Maintaining student accounts");
		System.out.println("1. Add Student");
		System.out.println("2. View Student");
		System.out.println("3. Delete Student");
		System.out.println("4. Quit");
		Helper.line(160, "-");
	}

	// add student account
	public static Student inputStudent() {

		String studentID = Helper.readString("Enter your student ID > ");
		String student_Name = Helper.readString("Enter student Name > ");
		String student_Class = Helper.readString("Enter student class > ");
		String teacher = Helper.readString("Enter classroom teacher > ");

		Student student = new Student(studentID, student_Name, student_Class, teacher);
		return student;

	}

	public static void addStudent(ArrayList<Student> studentList, Student student) {

		studentList.add(student);
	}

	// view student account
	public static String retrieveAllStudent(ArrayList<Student> studentList) {
		String output = "";
		for (int i = 0; i < studentList.size(); i++) {

			output += String.format("%-15s %-15s %-30s %-15s %-15s\n", i + 1, studentList.get(i).getStudentID(),
					studentList.get(i).getName(), studentList.get(i).getS_Class(), studentList.get(i).getTeacher());
		}
		return output;
	}

	public static void viewAllStudent(ArrayList<Student> studentList) {
		if (retrieveAllStudent(studentList) == "") {
			System.out.println("No students found!");

		} else {
			String output = String.format("%-15s %-15s %-30s %-15s %-15s\n", "POSITION", "Student ID", "Student Name",
					"Student Class", "Class Teacher");
			output += retrieveAllStudent(studentList);
			System.out.println(output);
		}
	}

	public static void deleteStudent(ArrayList<Student> studentList, int delOption) {
		
		if (delOption <= 0 || delOption > studentList.size()) {
			System.out.println("Invalid option");
		} else {
			for (int i = 0; i < studentList.size(); i++) {

				if (delOption == (i + 1)) {
					studentList.remove(i);
					System.out.println("Student deleted");
					break;
				}
			}
		}

		viewAllStudent(studentList);

	}
	// ===========================================================================================

	// For maintaining Parent
	// account==========================================================
	public static void Parentmenu() {
		C206_CaseStudy.setHeader("Maintaining parent accounts");
		System.out.println("1. Add Parent");
		System.out.println("2. View Parent");
		System.out.println("3. Delete Parent");
		System.out.println("4. Quit");
		Helper.line(160, "-");
	}

	// add parent account
	public static Parent inputParent() {

		String studentID = Helper.readString("Enter your child's student ID > ");
		String student_Name = Helper.readString("Enter your child's Name > ");
		String student_Class = Helper.readString("Enter your child's class > ");
		String teacher = Helper.readString("Enter your child's classroom teacher > ");
		String name = Helper.readString("Enter your name > ");
		String email = Helper.readString("Enter your email > ");
		int contact = Helper.readInt("Enter your contact number > ");

		Parent parent = new Parent(studentID, student_Name, student_Class, teacher, name, email, contact);
		return parent;

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
		if (retrieveAllParent(parentList) == "") {
			System.out.println("No parents found!");

		} else {
			String output = String.format("%-15s %-15s %-30s %-15s %-15s %-15s %-15s %-15s\n", "POSITION",
					"Parent Name", "Email", "Contact Number", "Student ID", "Student Name", "Student Class",
					"Student Grade", "Class Teacher", "Contact Number");
			output += retrieveAllParent(parentList);
			System.out.println(output);
		}
	}

	public static void deleteAllParent(ArrayList<Parent> parentList) {
		viewAllParent(parentList);
		int delOption = Helper.readInt("Choose option to delete > ");
		if (delOption <= 0 || delOption > parentList.size()) {
			System.out.println("Invalid option");
		} else {
			for (int i = 0; i < parentList.size(); i++) {

				if (delOption == (i + 1)) {
					parentList.remove(i);
					System.out.println("Parent deleted");
					Helper.line(160, "-");
					break;
				}
			}
		}

		viewAllParent(parentList);
	}
	// ===========================================================================================

	// For maintaining CCAs
	// ==========================================================

	public static void ccaMenu() {
		C206_CaseStudy.setHeader("Maintaining CCAs");
		System.out.println("1. Add CCA detail");
		System.out.println("2. View CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. Quit");
		Helper.line(160, "-");
	}

	// add cca details
	public static CCA inputCCA() {

		String catName = Helper.readString("Enter the CCA category > ");
		String ccaName = Helper.readString("Enter the CCA name > ");
		String ccaDesc = Helper.readString("Enter the CCA description > ");
		int ccaSize = Helper.readInt("Enter the class size > ");
		String ccaDay = Helper.readString("Enter the CCA day > ");
		String ccaTime = Helper.readString("Enter the CCA time > ");
		String ccaVenue = Helper.readString("Enter the CCA venue > ");
		String ccaInstructor = Helper.readString("Enter the CCA instructor > ");

		CCA cca = new CCA(catName, ccaName, ccaDesc, ccaSize, ccaDay, ccaTime, ccaVenue, ccaInstructor);
		return cca;

	}

	public static void addCCA(ArrayList<CCA> ccaList, CCA cca) {

		ccaList.add(cca);
	}

	// view ccas
	public static String retrieveAllCCAs(ArrayList<CCA> ccaList) {
		String output = "";
		for (int i = 0; i < ccaList.size(); i++) {

			output += String.format("%-15s %-20s %-40s %-20d %-10s %-10s %-20s %-30s \n", i + 1,
					ccaList.get(i).getTitle(), ccaList.get(i).getDescription(), ccaList.get(i).getClassSize(),
					ccaList.get(i).getDay(), ccaList.get(i).getTime(), ccaList.get(i).getVenue(),
					ccaList.get(i).getInstructor());

		}
		return output;
	}

	public static void viewAllCCAs(ArrayList<CCA> ccaList) {

		if (retrieveAllCCAs(ccaList) == "") {
			System.out.println("No CCAs found!");

		} else {
			String output = String.format("%-15s %-20s %-40s %-20s %-10s %-10s %-20s %-30s \n", "POSITION", "TITLE",
					"DESCRIPTION", "CLASS SIZE", "DAY", "TIME", "VENUE", "INSTRUCTOR");
			output += retrieveAllCCAs(ccaList);
			System.out.println(output);
		}
	}

	// delete CCA
	public static void deleteCCA(ArrayList<CCA> ccaList, int delOption) {

		if (delOption <= 0 || delOption > ccaList.size()) {
			System.out.println("Invalid option");
		} else {
			for (int i = 0; i < ccaList.size(); i++) {

				if (delOption == (i + 1)) {
					ccaList.remove(i);
					System.out.println("CCA deleted");
					Helper.line(160, "-");
					break;

				}
			}
		}
		viewAllCCAs(ccaList);

	}
	// ===========================================================================================

	// For maintaining CCA
	// categories==========================================================

	public static void ccaCatMenu() {
		C206_CaseStudy.setHeader("Maintaining CCA Categories");
		System.out.println("1. Add Category");
		System.out.println("2. View Category");
		System.out.println("3. Delete Category");
		System.out.println("4. Quit");
		Helper.line(160, "-");
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
	public static void deleteCategory(ArrayList<Category> catList, int delOption) {
		

//		int delOption = Helper.readInt("Choose position to delete > ");
		if (delOption <= 0 || delOption > catList.size()) {
			System.out.println("Invalid option");
		} else {
			for (int i = 0; i < catList.size(); i++) {

				if (delOption == (i + 1)) {
					catList.remove(i);
					System.out.println("Category deleted");
					Helper.line(160, "-");
					break;

				}
			}
		}
		viewAllCategories(catList);

	}
	
	// ===========================================================================================

}
