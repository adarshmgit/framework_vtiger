package com.crm.vtiger.organizationModuleTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.organizationPomClass.CreateOrganizationPage;
import com.crm.vtiger.organizationPomClass.OrganizationInformationPage;
import com.crm.vtiger.organizationPomClass.OrganizationPage;

public class TC_04_CreateOrganizationWithEmailOptionTest extends BaseClass{
	@Test
	public void createOrgWithEmailOpt() throws Throwable {
		// fetch the test case data
		String organizationName=EUtil.getExcelsheetData("TC001", 7, 2)+"_"+jUtil.getRandomData();

		//create organization
		HomePage homepage=new HomePage(driver);
		homepage.clickOrganisation();

		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOrganisationImg();

		CreateOrganizationPage createOrg=new CreateOrganizationPage(driver) ;
		createOrg.createOrgWithEmail(organizationName);

		//verification of organization names
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualText=orgInfoPage.getOrgInfoText();
		Assert.assertTrue(actualText.contains(organizationName));
		
		//verify email text field
		String actualEmailText=orgInfoPage.getEmailText();
		String expectedEmailText=" yes ";
		Assert.assertEquals(actualEmailText, expectedEmailText);;

	}

}
