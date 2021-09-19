package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistration {

	WebDriver driver;
	
	public AccountRegistration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(name="firstname")
	WebElement txtFirstname;
	
	@FindBy(name="lastname")
	WebElement txtLastname;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	

	  @FindBy(name="password")
	  WebElement txtPassword;
	
	  @FindBy(name="confirm")
  	WebElement txtConfirmPassword;
	
    @FindBy(name="agree")
    WebElement chkdPolicy;
	
    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;
    
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
	
    public void setFirstName(String fname) {
    	txtFirstname.sendKeys(fname);
    }
    
    public void setLastName(String lname) {
    	txtLastname.sendKeys(lname);
    }
    public void setEmail(String email) {
    	txtEmail.sendKeys(email);
    }
    public void setTelephone(String phone) {
    	txtTelephone.sendKeys(phone);
    }
	
    public void setPassword(String password) {
    	txtPassword.sendKeys(password);
    }
    public void setConfirmPassword(String cpwd) {
    	txtConfirmPassword.sendKeys(cpwd);
    }
    public void setPrivacyPolicy() {
    	chkdPolicy.click();
    }
    public void clickContinue() {
    	btnContinue.click();
    }
    public String getConfirmationMsg() {
    	try {
    		return(msgConfirmation.getText());
    	}
    	catch(Exception e)
    	{
    		return (e.getMessage());
    	}
    }
}
