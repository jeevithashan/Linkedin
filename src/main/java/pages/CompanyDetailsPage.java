package pages;

import utils.Reporter;
import wrappers.LinkedInWrapper;


public class CompanyDetailsPage extends LinkedInWrapper{

	public CompanyDetailsPage() {
		if(!verifyTitle("Mirakl: Overview | LinkedIn"))
			Reporter.reportStep("This is not CompanyDetails Page", "FAIL");
	}	
	
	public CompanyDetailsPage companySize() {
		getTextByClassName("company-size");
		return this;
	}

}	

