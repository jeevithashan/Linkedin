package pages;

import utils.Reporter;
import wrappers.LinkedInWrapper;

public class JobDetailsPage extends LinkedInWrapper{

	public JobDetailsPage() throws InterruptedException {
		sleep(3000);
		if(!verifyTitle("Software JAVA Developer Job at Mirakl in PARIS 16 | LinkedIn"))
			Reporter.reportStep("This is not JobDetail Page", "FAIL");
	}	
	
	public JobDetailsPage getCompanyName() {
		getTextByXpath("//*[@id='top-card']/div/div[1]/div[2]/h3[1]/a/span[1]");
		return this;
	}
	
	public CompanyDetailsPage clickCompanyName() {
		clickByXpath("//*[@id='top-card']/div/div[1]/div[2]/h3[1]/a/span[1]");
		return new CompanyDetailsPage();
	}
}
