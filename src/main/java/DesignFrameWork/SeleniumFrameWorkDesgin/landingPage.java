package DesignFrameWork.SeleniumFrameWorkDesgin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import SeleniumFrameWorkDesgin.EndtoEnd.AbstractCompenet;

public class landingPage extends AbstractCompenet{
	
	
	WebDriver driver;
	
public landingPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
//paefactory
//driver.findElement(By.cssSelector("input[formcontrolname='userEmail']"));
	@FindBy(css="input[formcontrolname='userEmail']")
	WebElement userEmail;
	
//	driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Takshvi@2024");
	@FindBy(css="input[type='password']")
	WebElement password;
	
//	driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement sumbit;
	
	 //.ng-tns-c4-4.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	 
	
	@FindBy(css="[class*='flyInOut']")
    WebElement Errortoaster;
	

public productCatloag loginApplication(String email,String pwd)
{
	userEmail.sendKeys(email);
	password.sendKeys(pwd);
	sumbit.click();
	 productCatloag Prodcatloag=new productCatloag(driver);
	 return Prodcatloag;
}

public String invalidCred()
{
	waitforWebElemetToApper(Errortoaster);
	return Errortoaster.getText();
}

public void URL()

{
	driver.get("https://rahulshettyacademy.com/client");
}
	

}
