package tempTestPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

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

public class TestNgTestClass2 extends Base {
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
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@Parameters ("browser")
    @BeforeTest
    public void launchTheBrowser(String browserName)
    {
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
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
		amezonPasswordPage = new AmezonPasswordPage(driver);
		amezonHomePage = new AmezonHomePage(driver);
		
		
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
	
	@Test
	public void test1() throws InterruptedException, IOException
	{
		testId = 12333;
		Thread.sleep(10000);
//		String uRLOfHomePage = driver.getCurrentUrl();
//		soft.assertEquals(uRLOfHomePage, "https://www.amazon.in/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&useRedirectOnSuccess=1&signIn=1&action=sign-out&ref_=nav_AccountFlyout_signout");
		Thread.sleep(4000);
	    amezonHomePage.clickOnAllButton();
	    Thread.sleep(4000);
		amezonHomePage.scrollIntoMensFashion();
		Thread.sleep(4000);
		amezonHomePage.clickOnmensFashionButton();
		Thread.sleep(4000);
		amezonHomePage.clickOnWatchButton();
		System.out.println(" Test 1 is pass");
		Thread.sleep(5000);
//		String titleOfWatchPage = driver.getTitle();
//		soft.assertEquals(titleOfWatchPage, "Buy Authentic, Branded, Best Priced Watches & Smart Watches for Men Online in India: Amazon.in");
//		soft.assertAll();
		 
	}
	
	@Test
	public void test2() throws InterruptedException, IOException
	{
		testId = 12444;
		amezonHomePage.clickOnHealthButtonOnHeader();
		System.out.println(" Test 2 is pass");
		Thread.sleep(5000);
//		String titleOfHealthCarePage = driver.getTitle();
//		soft.assertEquals(titleOfHealthCarePage, "Amazon.in: Health & Personal Care");
//		soft.assertAll();
		 
	}
	
	@AfterMethod
	public void logOutThePage(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, testId);
		}
		Thread.sleep(7000);
		amezonHomePage.clickOnSignOut();
	}
	
	@AfterClass
	public void cleanPOMObjects()
	{
		amezonSignInPage = null;
		amezonPasswordPage = null;
		amezonHomePage = null;
	}
	
	@AfterTest
	public void closedBrower()
	{
		driver.close();
		driver = null;
		System.gc();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
