package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmezonSignInPage {
   private WebDriver driver;
	@FindBy (xpath = "//input[@id='ap_email']")
	private WebElement userName;
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continueButton;
	
	
	
	public AmezonSignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public void sendUserName(String user) {
		userName.sendKeys(user);
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	
	
	
	
}
