package pages;



import utils.Reporter;
import wrappers.LinkedInWrapper;


public class LoginPage extends LinkedInWrapper{

	public LoginPage(){

		if(!verifyTitle("World’s Largest Professional Network | LinkedIn"))
			Reporter.reportStep("This is not Login Page", "FAIL");
	}

	public LoginPage enterUserName(String data) {
		enterById(prop.getProperty("Login.UserName.Id"),data);
		return this;
	}

	public LoginPage enterPassword(String data) {
		enterById(prop.getProperty("Login.Password.Id"), data);
		return this;
	}

	public HomePage clickLogin() throws InterruptedException {
		clickByName(prop.getProperty("Login.SignIn.Name"));
		return new HomePage();
	}
	public LoginPage clickLoginForFailure() {
		clickByName(prop.getProperty("Login.SignIn.Name"));
		return this;
	}
	public LoginPage verifyErrorMessage(String data) {
		verifyTextContainsByXpath(prop.getProperty("Login.ErrorMsg.Xpath"), data);
		return this;
	}


}
