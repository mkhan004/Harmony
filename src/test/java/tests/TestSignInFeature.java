package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestSignInFeature extends TestBase {
	
	@BeforeClass
	public void classSetUp() {
		menuBar.signInLink.click();
	}
	
	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchLink.click();
	}
	
	@Test
	public void testSignInWithValidCredentials() {
		signInPage.signIn("shakil_ipe@yahoo.com", "365827");
		
		Assert.assertTrue( driver.getCurrentUrl().contains("elitecareer.net/profile") );
		
		menuBar.logoutLink.click();
		menuBar.signInLink.click();
	}
	
	@Test
	public void testSignInWithInvalidEmailAndValidPassword() {
		signInPage.signIn("invalid@yahoo.com", "365827");
		
		// make sure signin was not successful
		Assert.assertTrue( driver.getCurrentUrl().contains("elitecareer.net/signin") );
		
		// make sure get proper error message		
		String actualError = signInPage.getTargetWebElementText( signInPage.errorElementList, 0);
		String expectedError = "* Email or Password is incorrect.";
		Assert.assertEquals(actualError, expectedError);
	}
	
	@Test
	public void testSignInWithValidEmailAndInvalidPassword() {
		signInPage.signIn("shakil_ipe@yahoo.com", "invalid");
		
		// make sure signin was not successful
		Assert.assertTrue( driver.getCurrentUrl().contains("elitecareer.net/signin") );
		
		// make sure get proper error message		
		String actualError = signInPage.getTargetWebElementText( signInPage.errorElementList, 0);
		String expectedError = "* Email or Password is incorrect.";
		Assert.assertEquals(actualError, expectedError);
	}
	
	@Test
	public void testSignInWithInvalidEmailAndInvalidPassword() {
		signInPage.signIn("invalid@yahoo.com", "invalid");
		
		// make sure signin was not successful
		Assert.assertTrue( driver.getCurrentUrl().contains("elitecareer.net/signin") );
		
		// make sure get proper error message		
		String actualError = signInPage.getTargetWebElementText( signInPage.errorElementList, 0);
		String expectedError = "* Email or Password is incorrect.";
		Assert.assertEquals(actualError, expectedError);
	}
	
	@Test
	public void testSignInWithEmptyEmailAndValidPassword() {
		signInPage.signIn("", "365827");
		
		// make sure signin was not successful
		Assert.assertTrue( driver.getCurrentUrl().contains("elitecareer.net/signin") );
		
		// make sure get proper error message		
		String actualError = signInPage.getTargetWebElementText( signInPage.errorElementList, 0);
		String expectedError = "* Email can not be empty.";
		Assert.assertEquals(actualError, expectedError);
	}
	
	@Test
	public void testSignInWithValidEmailAndEmptyPassword() {
		signInPage.signIn("shakil_ipe@yahoo.com", "");
		
		// make sure signin was not successful
		Assert.assertTrue( driver.getCurrentUrl().contains("elitecareer.net/signin") );
		
		// make sure get proper error message		
		String actualError = signInPage.getTargetWebElementText( signInPage.errorElementList, 0);
		String expectedError = "* Email or Password is incorrect.";
		Assert.assertEquals(actualError, expectedError);
		
		actualError = signInPage.getTargetWebElementText( signInPage.errorElementList, 1);
		expectedError = "* Password can not be empty.";
		Assert.assertEquals(actualError, expectedError);
	}
	
	@Test
	public void testSignInWithEmptyEmailAndEmptyPassword() {
		signInPage.signIn("", "");
		
		// make sure signin was not successful
		Assert.assertTrue( driver.getCurrentUrl().contains("elitecareer.net/signin") );
		
		// make sure get proper error message		
		String actualError = signInPage.getTargetWebElementText( signInPage.errorElementList, 0);
		String expectedError = "* Email can not be empty.";
		Assert.assertEquals(actualError, expectedError);
		
		actualError = signInPage.getTargetWebElementText( signInPage.errorElementList, 1);
		expectedError = "* Password can not be empty.";
		Assert.assertEquals(actualError, expectedError);
	}

}
