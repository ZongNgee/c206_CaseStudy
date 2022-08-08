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
		
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ccaList.add(new CCA("Uniform Group", "Red Cross", "Youths learning basic first aid", 20, "Friday", "3PM", "Hall", "Mr Teng"));
		ccaList.add(new CCA("Perfoming Arts", "Dance", "Youths uniting as one to dance", 30, "Friday", "3.30PM", "Dance Studio", "Mrs Woo Woo"));
	
		
		C206_CaseStudy.viewAllCategories(categoriesList);
		
		C206_CaseStudy.viewAllCCAs(ccaList);
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
			output += String.format("%-10s \n", categoriesList.get(i).getCatName());

		}
		return output;
	}
	
	public static void viewAllCategories(ArrayList<Category> categoriesList) {
		setHeader("View All Categories");
		String output = String.format("%-10s \n", "CATEGORY NAME");
		output += retrieveAllCategories(categoriesList);
		System.out.println(output);
		
	}
	
	// View all CCA details
	public static String retrieveAllCCAs(ArrayList<CCA> detailList) {
		String output = "";
		
		for (int i = 0; i < detailList.size(); i++) {
			output += String.format("%-20s %-40s %-20d %-10s %-10s %-20s %-30s \n", 
					detailList.get(i).getTitle(), detailList.get(i).getDescription(), detailList.get(i).getClassSize(), detailList.get(i).getDay(), detailList.get(i).getTime(), detailList.get(i).getVenue(), detailList.get(i).getInstructor());

		}
		return output;
		
	}
	
	public static void viewAllCCAs(ArrayList<CCA> detailList) {
		setHeader("View All CCA details");
		String output = String.format("%-20s %-40s %-20s %-10s %-10s %-20s %-30s \n", "TITLE", "DESCRIPTION", "CLASS SIZE", "DAY", "TIME", "VENUE", "INSTRUCTOR");
		output += retrieveAllCCAs(detailList);
		System.out.println(output);
		
	}

}
