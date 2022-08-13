
public class Parent extends Student{

	private String parentName;
	private String email;
	private int contactNo;
	
	public Parent(String studentID, String name, String s_Class, String teacher, 
			String parentName, String email, int contactNo) {
		super(studentID, name, s_Class, teacher);
		this.parentName = parentName;
		this.email = email;
		this.contactNo = contactNo;
	}

	public String getParentName() {
		return parentName; 
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	

}