package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import wrappers.LinkedInWrapper;

import org.testng.annotations.BeforeClass;

public class TC001_Connections extends LinkedInWrapper{
	@Test(dataProvider="fetchData")
	public void login(String userName, String passWord, 
			String vUser,String keyword) throws InterruptedException {

		new LoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.verifyUserName(vUser)
		.clickAdvancedLink()
		.enterKeyword(keyword)
		.clickSearch()
		.getSearchResults()
		.getConnectionName()
		.getConnectionNumber()
		.clickLogout();
	}
	@BeforeClass
	public void beforeClass() {
		dataSheetName="TC001";
		browserName="chrome";
		testCaseName="TC001_Connections";
		testDescription="Connection Details Based on Search Keyword ";
	}

}
