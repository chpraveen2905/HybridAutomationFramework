package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass{
//This is login Test
	
	@Test(groups={"master"})
	public void test_Login() {
		logger.info("Starting TC_002_Login");
		try {
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed");
			driver.manage().window().maximize();
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on my Account");
			hp.clickLogin();
			logger.info("Clicked on Login");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			logger.info("Provided Email");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password");
			
			lp.clickLogin();
			logger.info("clicked login");
			Thread.sleep(5000);
			
			boolean targetPage = lp.isMyAccountPageExists();
			if(targetPage) {
				logger.info("Login Success");
				Assert.assertTrue(true);
			}else {
				logger.error("Login Failed");
				captureScreen(driver,"test_Login");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e) {
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		logger.info(" Finished TC_002_Login ");
	}
}
