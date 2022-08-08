import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//================ For testing ==============================
		ArrayList<Category> categoriesList = new ArrayList<Category>();

		categoriesList.add(new Category("Performing arts"));
		categoriesList.add(new Category("Uniform Groups"));
		categoriesList.add(new Category("Information Technology"));
		categoriesList.add(new Category("Clubs"));
		
		C206_CaseStudy.viewAllCategories(categoriesList);
		//===========================================================

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	// View all categories
	public static String retrieveAllCategories(ArrayList<Category> categoriesList) {
		String output = "";

		for (int i = 0; i < categoriesList.size(); i++) {
			output += String.format("%-84s \n", categoriesList.get(i).getCatName());

		}
		return output;
	}
	
	public static void viewAllCategories(ArrayList<Category> categoriesList) {
		String output = String.format("%-10s \n", "CATEGORY NAME");
		output += retrieveAllCategories(categoriesList);
		System.out.println(output);
		
	}

}
