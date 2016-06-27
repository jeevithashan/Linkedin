package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LinkedInWrapper;

import org.testng.annotations.BeforeClass;

public class TC003_EditProfile extends LinkedInWrapper{
	@Test(dataProvider="fetchData")
	public void login(String userName, String passWord, String profile) throws InterruptedException {

		new LoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
	    .mouseOverProfileTab()
	    .clickEditProfile()
		.verifyCurrentOrganization()
        .verifyAndAddNewSkill(profile)
        .clickLogout();
		

	}
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC003";
		browserName="chrome";
		testCaseName="TC003_EditProfile";
		testDescription="Edit Profile";
	}

	
	
	
	
	
	
}
