package pages;

import utils.Reporter;
import wrappers.LinkedInWrapper;

public class EditProfile extends LinkedInWrapper{
	
	public EditProfile()
	{
		if(!verifyTitle("Edit Profile | LinkedIn"))
				{
			Reporter.reportStep("This is not the Edit Profile page", "FAIL");
				}
	}
	
	public EditProfile verifyCurrentOrganization()
	{
		verifyTextByXpath(prop.getProperty("EditProfile.verifyCurrentOrganization.Xpath"), "Indium Software");
		return this;
	}
	
	public EditProfile verifyAndAddNewSkill(String skill) throws InterruptedException
	{
		if (!compareListValueByXPath(prop.getProperty("EditProfile.CompareSkillsListValue.Xpath"), skill))
		{
			clickByXpath(prop.getProperty("EditProfile.AddSkillbutton.Xpath"));
			enterById(prop.getProperty("EditProfile.NewSkill.ID"), skill);
			clickById(prop.getProperty("EditProfile.NewSkillAddButton.ID"));
			clickByXpath(prop.getProperty("EditProfile.SkillSaveButton.Xpath"));	
			
			if (compareListValueByXPath(prop.getProperty("EditProfile.CompareSkillListValueAfterAdd.Xpath"),skill))
			{
			System.out.println("Successfully added the new skill ");
			Reporter.reportStep("Skill Added Successfully", "PASS");
			}	
			}
      else {
		System.out.println("Duplicate Skill");
		Reporter.reportStep("Duplicate Skill", "INFO");
	   }
	
	return this;
	}
}
