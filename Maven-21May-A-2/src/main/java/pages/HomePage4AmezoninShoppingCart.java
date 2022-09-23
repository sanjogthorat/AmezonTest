package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage4AmezoninShoppingCart {

       private WebDriver driver;
	  @FindBy (xpath = "(//span[@class='a-button-text a-declarative'])[1]")
	  private WebElement quantityButton;
	  @FindBy (xpath = "//a[@id='quantity_1']")
	  private WebElement addQuantity;
	  
	
	  public HomePage4AmezoninShoppingCart(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
		  this.driver = driver;
	  }
	  
	  public void addTheQuantityOfProduct() 
	  {
		  quantityButton.click();
		  addQuantity.click();
	  }
}
