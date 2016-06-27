package pages;

import utils.Reporter;
import wrappers.LinkedInWrapper;


public class AdvancedSearchResultPage extends LinkedInWrapper{

	public AdvancedSearchResultPage() {
		if(!verifyTitle("Search | LinkedIn"))
			Reporter.reportStep("This is not Advance link Page", "FAIL");
	}	



        public AdvancedSearchResultPage getSearchResults() {
		String result=getTextByXpath(prop.getProperty("AdvancedLink.SearchResults.Xpath"));
		String resultNum=result.replace(",", "");
		System.out.println("Number of Search results:"+" "+resultNum);
		return this;
	}
        
        public AdvancedSearchResultPage getConnectionName() {
        String conName=getTextByXpath(prop.getProperty("AdvancedLink.ConnectionName.Xpath"));
        Reporter.reportStep("The Connection name:" + conName + " is displayed ", "PASS");
		return this;
	}

        public AdvancedSearchResultPage getConnectionNumber() {
		String conNum=getTextByXpath(prop.getProperty("AdvancedLink.ConnectionNumber.Xpath"));
		if(conNum.contains("1"))
		{
		
			Reporter.reportStep("This is "+conNum+"  Connection:" , "PASS");
		
		}
		else if(conNum.contains("2"))
		{
			Reporter.reportStep("This is "+conNum+ " Connection:" ," PASS");
		}
		return this;
	}


    	public AdvancedSearchResultPage closeSecondConnection() {
    		try {
    			sleep(3000);
    			clickByXpath("//*[@id='pivot-bar']/ul/li[2]/button");

    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return this;
    	}

    	public AdvancedSearchResultPage closegroupconnections() {
    		try {
    			sleep(3000);
    			clickByXpath("//*[@id='pivot-bar']/ul/li[2]/button");

    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return this;
    	}

    	public AdvancedSearchResultPage countonthetop() {
    		try {
    			sleep(3000);
    			getTextByXpathForSearchResults("//*[@id='results_count']/div/p/strong");

    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		return this;
    	}

    	public AdvancedSearchResultPage countAtTheLeftPane() {
    		try {
    			sleep(3000);
    			getTextByXpathForSearchResults("//*[@id='facet-N']/fieldset/div/ol/li[2]/div/span");
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return this;
    	}

    	public AdvancedSearchResultPage compareString() {
    		String sText = getTextByXpathForSearchResults("//*[@id='results_count']/div/p/strong");
    		String sText2 = getTextByXpathForSearchResults("//*[@id='facet-N']/fieldset/div/ol/li[2]/div/span");
    		compareString(sText, sText2);
    		return this;
    	}


	}