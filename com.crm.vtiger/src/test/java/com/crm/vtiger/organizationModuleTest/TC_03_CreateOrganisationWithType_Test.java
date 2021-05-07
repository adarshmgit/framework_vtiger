package com.crm.vtiger.organizationModuleTest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.objectrepository.HomePage;
import com.crm.vtiger.organizationPomClass.CreateOrganizationPage;
import com.crm.vtiger.organizationPomClass.OrganizationInformationPage;
import com.crm.vtiger.organizationPomClass.OrganizationPage;




public class TC_03_CreateOrganisationWithType_Test extends BaseClass {
	@Test(groups="Regression test")
	public void createOrgWithType() throws Throwable{
		JavaUtility jutil=new JavaUtility();
		
		//fetch the test case data
		
		String OrganizationName=EUtil.getExcelsheetData("TC001", 5, 2)+"_"+jutil.getRandomData();
		String Type=EUtil.getExcelsheetData("TC001", 5, 3);

		//create organization with industry
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOrganisation();

		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOrganisationImg();

		CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
		createOrg.createOrgWithType(OrganizationName, Type);
	
		//verification of type and organization
		OrganizationInformationPage orgInfo=new OrganizationInformationPage(driver);
		String actualType=orgInfo.getTypeText();
		Assert.assertEquals(Type, actualType);
		String actualOrgName=orgInfo.getOrgInfoText();
		Assert.assertTrue(actualOrgName.contains(OrganizationName));
		
		Reporter.log("Organization is created with type",true);
		
	}

}
