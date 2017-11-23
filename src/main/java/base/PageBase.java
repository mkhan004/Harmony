package base;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase extends Driver {

	public String getTargetWebElementText( List<WebElement> elementList, int index ) {
		String text = null;
		
		text = elementList.get(index).getText();
		
		return text;
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public String randomlySelectFromDropdownList( WebElement dropdownElement ) {
		String selectedOption = null;
		Select select = new Select(dropdownElement);
		
		int minIndex = 1;
		int maxIndex = select.getOptions().size() - 1;
		int index = getRandomNumber(minIndex, maxIndex);
		select.selectByIndex( index );
		
		selectedOption = select.getFirstSelectedOption().getText();
		return selectedOption;
	}
	
	public String randomlyClickFromListOfElement( List<WebElement> elementList, boolean nestedLink ) {
		String clickedElementText = null;
		
		int minIndex = 0;
		int maxIndex = elementList.size() - 1;
		int randomIndex = getRandomNumber(minIndex, maxIndex);
		
		WebElement randomlySelectedElement = elementList.get(randomIndex);
		clickedElementText = randomlySelectedElement.getText();
		
		if (nestedLink) {
			randomlySelectedElement.findElement(By.tagName("a")).click();
		} else {
			randomlySelectedElement.click();
		}
		
		return clickedElementText;
	}
	
	public int getRandomNumber( int min, int max ) {
		int randomNumber = 0;
		Random random = new Random();
		randomNumber = random.nextInt( max + 1 - min ) + min;
		return randomNumber;
	}
	
}
