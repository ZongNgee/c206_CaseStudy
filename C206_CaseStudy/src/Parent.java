public class Parent {

	private String parentName;
	private String email;
	private int contactNo;
	
	public Parent(String parentName, String email, int contactNo) {
		super();
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