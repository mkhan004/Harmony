package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import pages.MenuBar;
import pages.RegisterPage;
import pages.SignInPage;

@Listeners(listener.EliteListener.class)
public class TestBase extends SauceLabs {
	
	public static MenuBar menuBar;
	public static SignInPage signInPage;
	public static RegisterPage registerPage;
	
	@BeforeSuite
	public void setup() {
		if( Boolean.valueOf(getProperty("saucelabs")) ) {
			// to run test in SauceLabs			
			setSauceLabs();
		} else {
			// to run test in Local machine
			setDriver();
		}
		
		setDriverProperties();
		
		menuBar = PageFactory.initElements(driver, MenuBar.class);
		signInPage = PageFactory.initElements(driver, SignInPage.class);
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
}
