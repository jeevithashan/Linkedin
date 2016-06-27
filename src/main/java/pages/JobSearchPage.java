package pages;

import utils.Reporter;
import wrappers.LinkedInWrapper;


public class JobSearchPage extends LinkedInWrapper{

	public JobSearchPage() {
		if(!verifyTitle("Search | LinkedIn"))
			Reporter.reportStep("This is not JobSearch Page", "FAIL");
	}	
	
	public JobSearchPage verifyJobSearchPage(String data) {
		verifyTextContainsByXpath("//*[@id='advs-link']", data);
		return this;
	}

	public JobSearchPage verifyButtonColour(String buttonColor) {
		String color = verifyColor(0, "View");
		System.out.println(buttonColor);
		if (color.equals(buttonColor)) {
			System.out.println("color matches with the button color  " + color);
			Reporter.reportStep("Color"+color+ "Matches Button Color"+buttonColor, "PASS");
		} else {
			Reporter.reportStep("Color did not "+color+ "Match Button Color "+buttonColor, "PASS");
			System.out.println("color did not match  " + color);
		}
		return this;
	}
	public JobDetailsPage selectViewButton() throws InterruptedException {
		clickViewListButton(1, "View");
		return new JobDetailsPage();
	}
	
}
