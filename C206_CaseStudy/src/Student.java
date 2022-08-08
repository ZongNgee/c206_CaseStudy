public class Student{

	private String studentID;
	private String name;
	private String s_Class;
	private String teacher;
	private int registrationID;
	private boolean isRegistered;
	
	public Student (String studentID, String name, String s_Class, String teacher) {
		this.studentID = studentID;
		this.name = name;
		this.s_Class = s_Class;
		this.teacher = teacher;
		this.registrationID = 0;
		this.isRegistered = false;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getS_Class() {
		return s_Class;
	}

	public void setS_Class(String s_Class) {
		this.s_Class = s_Class;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	public int getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(int registrationID) {
		this.registrationID = registrationID;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public String getStatus() {
		if (isRegistered) {
			return "Successful";
		} else {
			return "Waiting list";
		}
	}
	
}