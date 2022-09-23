package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage3OnePlusNordCE25G {
	
	  @FindBy (xpath = "//input[@id='add-to-cart-button']")
	  private WebElement addCartButton;
	  
	  
	  public HomePage3OnePlusNordCE25G(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public void clickOnAddToCartButton()
	  {
		  addCartButton.click();
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
