package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class JobSearchPage extends PageBase {

	@FindBy(name="JobCategory")
	public WebElement jobCategoryDropdownElement;
	
	@FindBy(name="submit")
	public WebElement searchButton;	
	
	@FindBy(id="job_title_style")
	public List<WebElement> jobTitleDivElementList;
	
	@FindBy(xpath=".//*[@id='application_status_container']/p/b")
	private WebElement searchResultCount;
	
	
	// supporting method
	public int getSearchResultCount() {
		int count = 0;
		count = Integer.valueOf( searchResultCount.getText() );
		return count;
	}
	
}
