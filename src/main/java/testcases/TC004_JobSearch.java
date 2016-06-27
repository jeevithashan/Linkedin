package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LinkedInWrapper;

import org.testng.annotations.BeforeClass;

public class TC004_JobSearch extends LinkedInWrapper{
	@Test(dataProvider="fetchData")
	public void login(String userName, String passWord, 
			String Keyword,String color) throws InterruptedException {

		new LoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.clickJobs()
		.enterSearchKey(Keyword)
		.clickSearch()
		.verifyButtonColour(color)
		.selectViewButton()
		.getCompanyName()
		.clickCompanyName()
		.companySize()
		.clickLogout();
		
		
		
	}
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC004";
		browserName="chrome";
		testCaseName="TC004_JobSearch";
		testDescription="Job Search in LinkedIn using POM framework";
	}
	
}
