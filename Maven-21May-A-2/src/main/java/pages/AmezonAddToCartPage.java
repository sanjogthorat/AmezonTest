package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmezonAddToCartPage {

	@FindBy (xpath = "//input[@id='add-to-cart-button']")
	private WebElement addToCartButton;
	@FindBy (xpath = "//a[@id='nav-logo-sprites']")
	private WebElement clickOnAmezon;
	@FindBy (xpath = "(//input[@type='submit'])[39]")
	private WebElement cartbutton2;
	
	public AmezonAddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCartButton() throws InterruptedException {
		addToCartButton.click();
		Thread.sleep(4000);
		cartbutton2.click();
	}
	
	public void clickOnAmezon()
	{
		clickOnAmezon.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
