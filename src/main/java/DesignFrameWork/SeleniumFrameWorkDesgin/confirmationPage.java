package DesignFrameWork.SeleniumFrameWorkDesgin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import SeleniumFrameWorkDesgin.EndtoEnd.AbstractCompenet;

public class confirmationPage extends AbstractCompenet{
	
WebDriver driver;
	
	public confirmationPage(WebDriver driver) {
		
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	
	@FindBy(css=".hero-primary")
	WebElement confirmMsg;
	
	public WebElement confirmtheOrderMsg()
	{
	
	
//		/confirmMsg.getText();
	String successMsg= confirmMsg.getText();
     
	return confirmtheOrderMsg();

	}
}
