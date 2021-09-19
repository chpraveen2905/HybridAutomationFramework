package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{

	@Test(groups= {"regression","master"})
	public void test_account_Registration() {
		logger.info("Starting TC_001_AccountRegistration");
		try {
			driver.get(rb.getString("appURL")); //dynamically get data from the properties file
			logger.info("Home Page Displayed");
			driver.manage().window().maximize();
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			hp.clickRegister();
			logger.info("Click Register");
			
			AccountRegistration regpage = new AccountRegistration(driver);
			regpage.setFirstName("SriLakshmi");
			logger.info("Provided First name");
			regpage.setLastName("Mathukumali");
			logger.info("Provided Last name");
			regpage.setEmail(randomestring()+"@gmail.com");
			logger.info("Provided Email");
			regpage.setPassword("Lakshmi");
			logger.info("Provided Password");
			regpage.setConfirmPassword("Lakshmi");
			logger.info("Provided Confirmed Password");
			regpage.setPrivacyPolicy();
			logger.info("Set Privacy Policy");
			regpage.clickContinue();
			logger.info("Clicked on Continue");
			String confmsg = regpage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!")) 
				// if(confmsg.equals("Your Account Has Been Creaaated!"))//Intensely failing
			{
				logger.info("Account Registration Success");
				Assert.assertTrue(true);
			}
			else {
				logger.error("Account Registration failed");
				captureScreen(driver,"test_account_Registration");// capturing screen shot in the screen shot folder 
				//==> As we mentioned in capture screen method in the base class
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e) {
			logger.fatal("Account Registration Failed"); //Fatal means blocker
			Assert.fail();
		}
		logger.info("Finished TC_001_AccountRegistration");
	}
	
}
