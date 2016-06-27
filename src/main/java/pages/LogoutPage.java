package pages;

import utils.Reporter;
import wrappers.LinkedInWrapper;


public class LogoutPage extends LinkedInWrapper {
	
	public LogoutPage()
	{
		if(!verifyTitle("Signed Out | LinkedIn"))
			{
			Reporter.reportStep("This is not the logout page", "FAIL");
				}
		else
			Reporter.reportStep("Successfully Logged out", "PASS");
	}
	
	



	

}
