package pages;

import utils.Reporter;
import wrappers.LinkedInWrapper;


public class HomePage extends LinkedInWrapper{
	

	public HomePage() throws InterruptedException {
		Thread.sleep(4000);
		if(!verifyTitle("Welcome! | LinkedIn"))
		{
	Reporter.reportStep("This is not the Home page", "FAIL");
		}
	}	

	public HomePage verifyUserName(String data) {
		verifyTextContainsByXpath(prop.getProperty("Home.UserName.Xpath"), data);
		return this;
	}

	

	public HomePage mouseOverProfileTab()
	{
		mouseOverByLinkText(prop.getProperty("Home.Profile.linkText"));
		return this;
	}
	

    public AdvancedSearchPage clickAdvancedLink() {
	clickById(prop.getProperty("HomePage.AdvancedLink.Id"));
	return new AdvancedSearchPage();
    }
	
	
	public EditProfile clickEditProfile()
	{
		clickByLink(prop.getProperty("Home.EditProfile.linkText"));
		return new EditProfile();
	}
	public JobsPage clickJobs() {
		clickByLink("Jobs");
		return new JobsPage();
	}
	
	












}
