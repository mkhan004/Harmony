package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class JobDetailPage extends PageBase {

	@FindBy(id="job_summary_content_style")
	public WebElement jobSummary;
	
	
}
