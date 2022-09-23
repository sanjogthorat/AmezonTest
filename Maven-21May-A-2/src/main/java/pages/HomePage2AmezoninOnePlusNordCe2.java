package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage2AmezoninOnePlusNordCe2 {
private WebDriver driver;
	@FindBy (xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement selectMobile;
	
	
	

	public HomePage2AmezoninOnePlusNordCe2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void selectOnePlusMobile() {
//		WebDriverWait wait = new WebDriverWait(driver,15);
//		wait.until(ExpectedConditions.visibilityOf(selectMobile));
		selectMobile.click();
	}
	
	
	
	
	
	
	
	
	
	
}
