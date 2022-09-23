package tempTestPack;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AmezonHomePage;
import pages.AmezonPasswordPage;
import pages.AmezonSignInPage;
import pages.HomePage2AmezoninOnePlusNordCe2;
import pages.HomePage3OnePlusNordCE25G;
import pages.ScreenShotPage;

public class TestClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sanjog\\\\Desktop\\\\Mannual And Automation Testing\\\\Selenium Libarary\\\\105\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		AmezonSignInPage amezonSignInPage = new AmezonSignInPage(driver);
		amezonSignInPage.sendUserName();
		String amezonSignInPageTitle = driver.getTitle();
		
		if(amezonSignInPageTitle.equals("Amazon Sign In"))
		{
			System.out.println("open");
		}
		else
		{
			System.out.println("not open");
		}
		amezonSignInPage.clickOnContinueButton();
		
		AmezonPasswordPage amezonPasswordPage = new AmezonPasswordPage(driver);
		amezonPasswordPage.sendPassword();
		String AmezonPasswordPageTitle = driver.getTitle();
		if(AmezonPasswordPageTitle.equals("Amazon Sign In"))
		{
			System.out.println("open");
		}
		else
		{
			System.out.println("not open");
		}
		amezonPasswordPage.clickOnSignInButton();
	
		
		
		
		ScreenShotPage ScreenShotPage = new ScreenShotPage(driver);
		ScreenShotPage.takeScreenshot();
		
		
		AmezonHomePage amezonHomePage = new AmezonHomePage(driver);
		amezonHomePage.sendMobibeNameInSearchField();
		String amezonHomePageTitle = driver.getTitle();
		if(amezonHomePageTitle.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
		{
			System.out.println("open");
		}
		else
		{
			System.out.println("not open");
		}
		amezonHomePage.clickOnSearchButton();

		HomePage2AmezoninOnePlusNordCe2 HomePage2AmezoninOnePlusNordCe2 = new HomePage2AmezoninOnePlusNordCe2(driver);
		HomePage2AmezoninOnePlusNordCe2.selectOnePlusMobile();
		String HomePage2AmezoninOnePlusNordCe2PageTitle = driver.getTitle();
		if(HomePage2AmezoninOnePlusNordCe2PageTitle.equals("Amazon.in : oneplus nord ce 2 5g"))
		{
			System.out.println("open");
		}
		else
		{
			System.out.println("not open");
		}

		System.out.println("----------------------------------------------------");
	
		ArrayList <String> listOfAdresses = new ArrayList <String> (driver.getWindowHandles());
	    driver.switchTo().window(listOfAdresses.get(1));
		
	    
	    
	    
	    HomePage3OnePlusNordCE25G homePage3OnePlusNordCE25G = new HomePage3OnePlusNordCE25G(driver);
	    homePage3OnePlusNordCE25G.clickOnAddToCartButton();
	   
	    ScreenShotPage ScreenShotPage1 = new ScreenShotPage(driver);
		ScreenShotPage1.takeScreenshot();
		 String HomePage3OnePlusNordCE25GPageTitle = driver.getTitle();
		if(HomePage3OnePlusNordCE25GPageTitle.equals("OnePlus Nord CE 2 5G (Gray Mirror, 8GB RAM, 128GB Storage)"))
		{
			System.out.println("open");
		}
		else
		{
			System.out.println("not open");
		}
		
		
		
		

	}

}
