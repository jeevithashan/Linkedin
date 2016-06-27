package pages;

import utils.Reporter;
import wrappers.LinkedInWrapper;

public class JobsPage extends LinkedInWrapper {

	public JobsPage() {
		if (!verifyTitle("Jobs Home | LinkedIn"))
			Reporter.reportStep("This is not Jobs Page", "FAIL");
	}

	public JobsPage verifyJobsPage(String data) {
		verifyTextContainsByXpath("//*[@id='jobs-home']/div[1]/h1", data);
		return this;
	}

	public JobsPage enterSearchKey(String data) {
		enterById("job-search-box", data);
		return this;
	}

	public JobSearchPage clickSearch() {
		clickByXpath("//*[@id='job-search']/div[1]/input");
		return new JobSearchPage();
	}

}
