package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import pages.JobDetailPage;
import pages.JobSearchPage;
import pages.MenuBar;
import pages.RegisterPage;
import pages.SignInPage;

@Listeners(listener.EliteListener.class)
public class TestBase extends SauceLabs {
	
	public static MenuBar menuBar;
	public static SignInPage signInPage;
	public static RegisterPage registerPage;
	public static JobSearchPage jobSearchPage;
	public static JobDetailPage jobDetailPage;
	
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
		jobSearchPage = PageFactory.initElements(driver, JobSearchPage.class);
		jobDetailPage = PageFactory.initElements(driver, JobDetailPage.class);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
}
