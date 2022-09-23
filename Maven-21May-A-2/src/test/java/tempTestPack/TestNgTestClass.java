package tempTestPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AmezonAddToCartPage;
import pages.AmezonHomePage;
import pages.AmezonPasswordPage;
import pages.AmezonSignInPage;
import pages.HomePage2AmezoninOnePlusNordCe2;
import pages.HomePage3OnePlusNordCE25G;
import pages.HomePage4AmezoninShoppingCart;
import pages.ScreenShotPage;
import setup.Base;
import utils.Utility;

public class TestNgTestClass extends Base {
private WebDriver driver;
private AmezonSignInPage amezonSignInPage;
private AmezonPasswordPage amezonPasswordPage;
private AmezonHomePage amezonHomePage;
private HomePage2AmezoninOnePlusNordCe2 homePage2AmezoninOnePlusNordCe2;
private HomePage3OnePlusNordCE25G homePage3OnePlusNordCE25G;
private HomePage4AmezoninShoppingCart homePage4AmezoninShoppingCart;
private AmezonAddToCartPage amezonAddToCartPage;
private SoftAssert soft;
int testId;
    @Parameters ("browser")
    @BeforeTest
    public void launchTheBrowser(String browserName)
    {
    	if(browserName.equals("Chrome"))
    	{
    		driver = openChromeBrowser();
    	}
    	if(browserName.equals("FireFox"))
    	{
    		driver = openfireFoxBrowser();
    	}
    	 driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
	@BeforeClass
	public void createObjects()
	{
		amezonSignInPage = new AmezonSignInPage(driver);
		 amezonHomePage = new AmezonHomePage(driver);
		 amezonPasswordPage = new AmezonPasswordPage(driver);
		 homePage4AmezoninShoppingCart = new HomePage4AmezoninShoppingCart(driver);
		 homePage2AmezoninOnePlusNordCe2 = new HomePage2AmezoninOnePlusNordCe2(driver);
		 
	}
	
	@BeforeMethod
	public void signIn() throws InterruptedException, EncryptedDocumentException, IOException
	{
	     driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		 Thread.sleep(5000);
		 String data = Utility.fetchDataFromExelsheet("details", 1, 0);
		 amezonSignInPage.sendUserName(data);
		 amezonSignInPage.clickOnContinueButton();
		 String data1 = Utility.fetchDataFromExelsheet("details", 1, 1);
		 amezonPasswordPage.sendPassword(data1);
		 amezonPasswordPage.clickOnSignInButton();
		 soft = new SoftAssert();
	}
	@Test (priority = 0)
	public void addTheQuantityOfProductInCart() throws InterruptedException, IOException
	{
	    testId = 12111;
		Thread.sleep(10000);
		amezonHomePage.clickOnCartButton();
		String titleOfCartPage = driver.getTitle();
		soft.assertEquals(titleOfCartPage, "Amazon.in Shopping Cart");
	    homePage4AmezoninShoppingCart.addTheQuantityOfProduct();
	    soft.assertAll();
	    Thread.sleep(7000);
	   
	}
	@Test (priority = 1)
	public void addMobileInCart() throws IOException, InterruptedException
	{
		testId = 12222;
	//	String uRLOfHomePage = driver.getCurrentUrl();
		
	//	soft.assertEquals(uRLOfHomePage, "https://www.amazon.in/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&useRedirectOnSuccess=1&signIn=1&action=sign-out&ref_=nav_AccountFlyout_signout");
		amezonHomePage.sendMobibeNameInSearchField();
		amezonHomePage.clickOnSearchButton();
//		String titleOfhomePage2AmezoninOnePlusNordCe2 = driver.getTitle();
//		soft.assertEquals(titleOfhomePage2AmezoninOnePlusNordCe2, "Amazon.in : oneplus nord ce 2 5g");
		
		Thread.sleep(5000);
		homePage2AmezoninOnePlusNordCe2.selectOnePlusMobile();
		
		ArrayList <String> listOfAdresses = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(listOfAdresses.get(1));
//		String titleOfhomePage3OnePlusNordCE25G = driver.getTitle();
		
//		homePage3OnePlusNordCE25G = new HomePage3OnePlusNordCE25G(driver);
//		homePage3OnePlusNordCE25G.clickOnAddToCartButton();
		System.out.println("Test is pass");
	//	soft.assertAll();
		 
	}

	@AfterMethod
	public void logOutThePage(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.captureScreenshot(driver, testId);
		}
		Thread.sleep(7000);	
		amezonHomePage.clickOnSignOut();
	}
	
	@AfterClass
	public void cleanPOMobjects()
	{
		 amezonSignInPage = null;
		 amezonHomePage = null;
		 amezonPasswordPage = null;
		 homePage4AmezoninShoppingCart = null; 
		 homePage2AmezoninOnePlusNordCe2 = null;
	}
	
	@AfterTest
	public void closedBrowser()
	{
		driver.close();
		driver = null ;
		System.gc();
	}
	
}
