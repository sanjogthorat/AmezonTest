package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmezonHomePage {
     private WebDriver driver;
	@FindBy (xpath = "//input[@type='text']")
	private WebElement searchBox;
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchButton ;
	@FindBy (xpath = "//span[@class='hm-icon-label']")
	private WebElement allButton ;
	@FindBy (xpath = "(//a[@class='hmenu-item'])[12]")
	private WebElement mensFashionButton ;
	@FindBy (xpath = "(//a[text()='Watches'])[1]")
	private WebElement watchButton ;
	@FindBy (xpath = "//div[@id='nav-cart-text-container']")
	private WebElement CartButton ;
	@FindBy (xpath = "//a[text()='Health, Household & Personal Care']")
	private WebElement healthButton ;
	@FindBy (xpath = "(//span[@class='a-size-base a-color-base'])[5]")
	private WebElement surfExcelButton ;
	@FindBy (xpath = "//span[@class='nav-line-2 ']")
	private WebElement accountsAndLists ;
	@FindBy (xpath = "//span[text()='Sign Out']")
	private WebElement signout ;
	
	
	
	public AmezonHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnAllButton() {
		allButton.click();
	}
	public void scrollIntoMensFashion() {
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", mensFashionButton);
	}
	public void clickOnmensFashionButton() {
		mensFashionButton.click();
	}
	public void clickOnWatchButton() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement wathchButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Watches'])[1]")));
		wathchButton1.click();
	}
	public void clickOnCartButton() {
		CartButton.click();
	}
	public void clickOnHealthButtonOnHeader() {
		 WebDriverWait wait = new WebDriverWait(driver , 15);
		 WebElement health = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Health, Household & Personal Care']")));
		 health.click();
	}
	public void sendMobibeNameInSearchField() {
		searchBox.sendKeys("oneplus nord ce 2 5g");
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public void clickOnSurfExcelButton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", surfExcelButton);
		surfExcelButton.click();
	}
	public void clickOnSignOut() {
		Actions act = new Actions(driver);
		act.moveToElement(accountsAndLists).moveToElement(signout).click().build().perform();
	}
}
