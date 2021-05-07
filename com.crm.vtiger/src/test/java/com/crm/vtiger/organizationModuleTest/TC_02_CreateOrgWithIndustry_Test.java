package com.crm.vtiger.organizationModuleTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.organizationPomClass.CreateOrganizationPage;
import com.crm.vtiger.organizationPomClass.OrganizationInformationPage;
import com.crm.vtiger.organizationPomClass.OrganizationPage;

public class TC_02_CreateOrgWithIndustry_Test extends BaseClass {
	@Test(groups="Smoke test")
	public void createorg() throws Throwable {
		
		// fetch the test case  data
		String OrganizationName=EUtil.getExcelsheetData("TC001", 3, 2);
		String Industry=EUtil.getExcelsheetData("TC001", 3, 3);

		//create organization with industry
		HomePage homepage=new HomePage(driver);
		homepage.clickOrganisation();

		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOrganisationImg();
		
		CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
		createOrg.createOrgWithIndustry(OrganizationName, Industry);
		
		//verification of organization name and industry
		OrganizationInformationPage orgInfo=new OrganizationInformationPage(driver);
		String actualOrgName=orgInfo.getOrgInfoText();
		Assert.assertTrue(actualOrgName.contains(OrganizationName));
		String actualIndustry=orgInfo.getIndustryText();
		Assert.assertEquals(actualIndustry, Industry);
		
		Reporter.log("Organization is created with industry",true);

	}

}
