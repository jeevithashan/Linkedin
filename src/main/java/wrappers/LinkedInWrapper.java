package wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pages.LogoutPage;
import utils.DataInputProvider;
import utils.Reporter;

public class LinkedInWrapper extends GenericWrappers {

	protected String browserName;
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;
	
	@BeforeSuite(groups={"AdvancedSearch","Profile"})
	public void beforeSuite() throws FileNotFoundException, IOException{
		Reporter.startResult();
		loadObjects();
		System.out.println("This is inside Before Suite");
	}
	
	@BeforeTest(groups={"AdvancedSearch","Profile"})
	public void beforeTest()
	{
		System.out.println("This is inside BEfore Test , executes after -> before Suite");
	}
	
	@BeforeMethod(groups={"AdvancedSearch","Profile"})
	public boolean beforeMethod()
	{

		boolean flag=true;
		
		try
		{
			Reporter.startTestCase();
			invokeApp(browserName);
		}
		catch(Exception e)
		{
			System.out.println("Error while Launching browser");
			flag=false;
		}
		return flag;
	}
	@AfterMethod(groups={"AdvancedSearch","Profile"},alwaysRun=true)
	public void afterMethod()
	{
	
		quitBrowser();
	}
	
public LogoutPage clickLogout() {
		
		mouseOverByXpath(prop.getProperty("Home.MouseOverLogout.Xpath"));
		clickByXpath(prop.getProperty("Home.Logout.Xpath"));
		return new LogoutPage();
	}

	@AfterClass(groups={"AdvancedSearch","Profile"})
	public void afterClass()
	{
		System.out.println("This is after Class , after->after method ");
	}
	@AfterTest(groups={"AdvancedSearch","Profile"})
	public void afterTest()
	{
		System.out.println("This is after Test , after->after Class ");
	}
	@AfterSuite(groups={"AdvancedSearch","Profile"})
	public void aftersuite()
	{
		Reporter.endResult();
		System.out.println("This is after Class , after->after method ");
	}
	

	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);	
	}
	public String verifyColor(int index, String linkName) {
		String cssValue = null;
		try {
			List<WebElement> viewButtons = driver.findElements(By.linkText(linkName));
			cssValue = viewButtons.get(index).getCssValue("background-color");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cssValue;

	}

	public void clickViewListButton(int index, String linkName) {
		try {

			List<WebElement> viewButtons = driver.findElements(By.linkText(linkName));
			viewButtons.get(index).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public String  verifyColor(int index)
	{
		List<WebElement> viewButtons = driver.findElements(By.linkText("View")); 
		String cssValue=viewButtons.get(index-1).getCssValue("background-color");
		return cssValue;
	}


	public boolean compareListValueByXPath(String XPath, String Value) {
		boolean bReturn = false;
		try {
			List<WebElement> listOptions = driver.findElementsByXPath(XPath);

			System.out.println("size = " + listOptions.size());

			for (WebElement option : listOptions) {
				// System.out.println(skill);
				if (option.getText().equals(Value)) {

					bReturn = true;
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return bReturn;
	}
	public String getTextByClassName(String classNameValue) {
		String text = null;
		String employeeCount = null;
		try {
			text = driver.findElementByClassName(classNameValue).getText();

			if (text.contains(",")) {
				employeeCount = text.replace(",", "");
				text = employeeCount;
			}

			if (text.contains("employees")) {
				text = text.replace("employees", "");
			} else if (text.contains("(")) {
				text = text.substring(1, text.length() - 1);
			}

			System.out.println("No of Employees" + " " + text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public String getTextByXpathForSearchResults(String xpathVal) 
	{
		String text=null;
		String Text1= null;
		try
		{
			text= driver.findElementByXPath(xpathVal).getText();

			if(text.contains(","))
			{
				Text1=text.replace(",","");
			}
			else if(text.contains(" employees"))
			{
				Text1=text.replace(" employees","" );
			}
			else if(text.contains("("))
			{
				Text1=text.substring(1,text.length()-1);
			}else{
				Text1=text;
			}
			Reporter.reportStep("The text:" + Text1 + " is present in xpath "+ xpathVal, "PASS");
			
		}
		catch(NoSuchElementException E)

		{
			System.out.println("Element" + xpathVal + "is not located");
			Reporter.reportStep("The element with xpath "+ xpathVal+" is not present.", "FAIL");
		} 
		catch(NullPointerException E)

		{
			Reporter.reportStep("The element with xpath "+ xpathVal+" is not proper, its NULL.", "FAIL");
			System.out.println(" Text of Element" + xpathVal + "is empty");
		} catch(Exception E)

		{
			System.out.println(E.getMessage());
			Reporter.reportStep("The element with xpath "+ xpathVal+"  could not be located.", "FAIL");
		} return Text1;
}

	public String compareString(String text1, String text2) {
		try {
			if (text1.equalsIgnoreCase(text2)) {
				Reporter.reportStep("The text:" + text1 + " and "+ text2 +"are equal", "PASS");

				System.out.println("Value of " + text1 + " and " + text2 + "are eqaul");
			} else {
				Reporter.reportStep("The text:" + text1 + " and "+ text2 +"are not equal", "PASS");
				System.out.println("Values are not eqaul" + text1 + text2);
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(" String value is null.");
		}
		return text2;
	}
	
	public void sleep(int milliSeconds) throws InterruptedException{
		Thread.sleep(milliSeconds);
	}
}	


