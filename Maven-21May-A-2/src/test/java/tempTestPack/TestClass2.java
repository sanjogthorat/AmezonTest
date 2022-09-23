package tempTestPack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AmezonHomePage;
import pages.AmezonPasswordPage;
import pages.AmezonSignInPage;
import pages.ScreenShotPage;

public class TestClass2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sanjog\\\\Desktop\\\\Mannual And Automation Testing\\\\Selenium Libarary\\\\105\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		AmezonSignInPage amezonSignInPage = new AmezonSignInPage(driver);
		amezonSignInPage.sendUserName();
		
		amezonSignInPage.clickOnContinueButton();
		
		
		AmezonPasswordPage amezonPasswordPage = new AmezonPasswordPage(driver);
		amezonPasswordPage.sendPassword();
		amezonPasswordPage.clickOnSignInButton();
		
		
		AmezonHomePage amezonHomePage = new AmezonHomePage(driver);
		String amezonHomePageTitle = driver.getTitle();
		if(amezonHomePageTitle.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
		{
			System.out.println("open");
		}
		else
		{
			System.out.println("not open");
		}
		amezonHomePage.clickOnAllButton();
		
		amezonHomePage.scrollIntoMensFashion();
		amezonHomePage.clickOnmensFashionButton();
		amezonHomePage.clickOnWatchButton();
		
		
		
		ScreenShotPage ScreenShotPage = new ScreenShotPage(driver);
		ScreenShotPage.takeScreenshot();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
