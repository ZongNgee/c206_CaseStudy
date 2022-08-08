
public class CCA extends Category{
	
	private String title;
	private String description;
	private int classSize;
	private String day;
	private double time;
	private String venue;
	private String instructor;
	
	
	public CCA(String catName, String title, String description, int classSize, String day, double time, String venue,
			String instructor) {
		super(catName);
		this.title = title;
		this.description = description;
		this.classSize = classSize;
		this.day = day;
		this.time = time;
		this.venue = venue;
		this.instructor = instructor;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getClassSize() {
		return classSize;
	}


	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public double getTime() {
		return time;
	}


	public void setTime(double time) {
		this.time = time;
	}


	public String getVenue() {
		return venue;
	}


	public void setVenue(String venue) {
		this.venue = venue;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
	
	

}
