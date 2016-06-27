package pages;

import utils.Reporter;
import wrappers.LinkedInWrapper;

public class AdvancedSearchPage extends LinkedInWrapper {

	
	public AdvancedSearchPage() {
		if(!verifyTitle("Search | LinkedIn"))
			Reporter.reportStep("This is not Advance link Page", "FAIL");
	}	

	public AdvancedSearchPage enterKeyword(String data) {
		enterById(prop.getProperty("AdvancePageSearch.Keyword.Id"), data);
		return this;
	}

        public AdvancedSearchResultPage clickSearch() {
		clickByClassName(prop.getProperty("AdvancePageSearch.Search.Class"));
		return new AdvancedSearchResultPage();
	}
	
	
	
    public AdvancedSearchResultPage clickclosebutton() {

		try {
			sleep(5000);
			
			clickByXpath("//*[@id='advs']/div[1]/button");
			//clickByXpath("//div[@class='advs-controls']/button");

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new AdvancedSearchResultPage();
	}
}
