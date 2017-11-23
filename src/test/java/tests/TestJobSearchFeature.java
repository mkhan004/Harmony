package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.TestBase;

public class TestJobSearchFeature extends TestBase {
	
	@AfterMethod
	public void testDirectoryReset() {
		menuBar.jobSearchLink.click();
	}
	
	@Test
	public void testSearchResultCategory() {
		String selectedCat = jobSearchPage.randomlySelectFromDropdownList( jobSearchPage.jobCategoryDropdownElement );
		jobSearchPage.searchButton.click();
		
		if (jobSearchPage.getSearchResultCount() > 0) {
			jobSearchPage.randomlyClickFromListOfElement(jobSearchPage.jobTitleDivElementList, true);
			String jobSummaryText = jobDetailPage.jobSummary.getText();
			Assert.assertTrue( jobSummaryText.contains( selectedCat ) );
		}
		
	}
}
