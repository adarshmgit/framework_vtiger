package com.crm.vtiger.organizationModuleTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.organizationPomClass.CreateOrganizationPage;
import com.crm.vtiger.organizationPomClass.OrganizationInformationPage;
import com.crm.vtiger.organizationPomClass.OrganizationPage;

public class TC_05_CreateOrganizationWithAssignedToGroupTest extends BaseClass {
	@Test
	public void createOrgWithgroup() throws Throwable {
		// fetch the test case data
		String organizationName=EUtil.getExcelsheetData("TC001", 9, 2)+"_"+jUtil.getRandomData();
        String group=EUtil.getExcelsheetData("TC001", 9, 3);
		//create organization
		HomePage homepage=new HomePage(driver);
		homepage.clickOrganisation();

		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOrganisationImg();
		
		CreateOrganizationPage createOrg=new CreateOrganizationPage(driver) ;
		createOrg.createOrgWithGroup(organizationName,group);
		
		//verifications
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualText=orgInfoPage.getOrgInfoText();
		Assert.assertTrue(actualText.contains(organizationName));
		
		//verify assigned to text field
		String actualEmailText=orgInfoPage.getAssignedTFText();
		Assert.assertTrue(actualEmailText.contains(group));
		
		
	}

}
