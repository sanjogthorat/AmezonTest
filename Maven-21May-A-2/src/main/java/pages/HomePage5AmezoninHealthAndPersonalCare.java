package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage5AmezoninHealthAndPersonalCare {

	@FindBy (xpath = "(//span[@class='a-size-base a-color-base'])[5]")
	private WebElement surfExcelbutton;
	
	
	
	
	public HomePage5AmezoninHealthAndPersonalCare(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void clickOnSurfExcelButton() {
		surfExcelbutton.click();
	}
	
	
	
	
	
	
	
	
	
}
