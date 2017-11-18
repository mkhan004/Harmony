package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import base.PageBase;

public class RegisterPage extends PageBase {

	@FindBy(name = "FirstName")
	public WebElement firstNameField;
	
	@FindBy(name = "submit")
	public WebElement submitButton;
	
	@FindBys( @FindBy(id = "error") )
	public List<WebElement> errorElementList;
	
	@FindBy(name = "Gender")
	public WebElement genderDropdownElement;
	
	
	// supporting methods
	
	public void textFieldHelper( WebElement element, String value ) {
		element.clear();
		element.sendKeys(value);
		submitButton.click();
	}
	
}
