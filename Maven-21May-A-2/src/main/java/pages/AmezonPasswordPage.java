package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmezonPasswordPage {

	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement signInButton ;
	
	
	public AmezonPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
