package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestRegisterFeature extends TestBase {

	@BeforeClass
	public void calssSetUp() {
		menuBar.registerLink.click();
	}
	
	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchLink.click();
	}
	
	@Test
	public void testFirstNameFieldWithTwoChar() {
		registerPage.textFieldHelper(registerPage.firstNameField, "as");
		
		String actualError = registerPage.getTargetWebElementText(registerPage.errorElementList, 0);
		
		Assert.assertEquals(actualError, "*");
	}
	
	@Test
	public void testFirstNameFieldWithThirtyChar() {
		registerPage.textFieldHelper(registerPage.firstNameField, "asgstagbhkabdjsytretnhvfdsawer");
		
		String actualError = registerPage.getTargetWebElementText(registerPage.errorElementList, 0);
		
		Assert.assertEquals(actualError, "*");
	}
	
	@Test
	public void testFirstNameFieldWithOneChar() {
		registerPage.textFieldHelper(registerPage.firstNameField, "a");
		
		String actualError = registerPage.getTargetWebElementText(registerPage.errorElementList, 0);
		
		Assert.assertEquals(actualError, "* FirstName can not be less than 2 character.");
	}
	
//	@Test(dependsOnMethods = { "testGenderDropdownWithoutSelectedOption" }, alwaysRun = true)
	
	@Test(priority = 1)
	public void testGenderDropdownWithRandomOption() {
		registerPage.randomlySelectFromDropdownList( registerPage.genderDropdownElement );
		registerPage.submitButton.click();
		
		String actualError = registerPage.getTargetWebElementText(registerPage.errorElementList, 2);
		Assert.assertEquals(actualError, "*");
	}
	
	@Test
	public void testGenderDropdownWithoutSelectedOption() {
		registerPage.submitButton.click();
		
		String actualError = registerPage.getTargetWebElementText(registerPage.errorElementList, 2);
		Assert.assertEquals(actualError, "* Gender can not be empty.");
	}
	
	
	
}
