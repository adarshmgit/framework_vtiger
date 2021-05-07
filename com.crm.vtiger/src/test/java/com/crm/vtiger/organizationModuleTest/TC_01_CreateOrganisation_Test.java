package com.crm.vtiger.organizationModuleTest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.organizationPomClass.CreateOrganizationPage;
import com.crm.vtiger.organizationPomClass.OrganizationInformationPage;
import com.crm.vtiger.organizationPomClass.OrganizationPage;

@Listeners(com.crm.vtiger.GenericUtils.ListenerImplimentationClass.class)
public class TC_01_CreateOrganisation_Test extends BaseClass {
	@Test(groups="Smoke test")
	public void createOrganisation() throws Throwable {
		
		// fetch the test case data
		String organizationName=EUtil.getExcelsheetData("TC001", 1, 2)+"_"+jUtil.getRandomData();
		
		//create organization
		HomePage homepage=new HomePage(driver);
		homepage.clickOrganisation();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOrganisationImg();
		
		CreateOrganizationPage createOrg=new CreateOrganizationPage(driver) ;
		createOrg.createorg(organizationName);
		
		//verification
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualText=orgInfoPage.getOrgInfoText();
		Assert.assertTrue(actualText.contains(organizationName));
		
		Reporter.log("Organization is created",true);
		
	}

}



