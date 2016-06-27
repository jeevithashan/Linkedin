package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import wrappers.LinkedInWrapper;



public class TC002_AdvancedSearch extends LinkedInWrapper{
	@Test(dataProvider="fetchData")
	public void login(String userName, String passWord) throws InterruptedException {

		new LoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.clickAdvancedLink()
		.clickclosebutton()
		.closeSecondConnection()
		.closegroupconnections()
		.countonthetop()
		.countAtTheLeftPane()
		.compareString()
		.clickLogout();
}

	
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC002";
		browserName="chrome";
		testCaseName="TC002_AdvancedSearch";
		testDescription="Login in Linkdin using POM framework";
	}
}
