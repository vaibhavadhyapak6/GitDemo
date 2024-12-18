package DesignFrameWork.SeleniumFrameWorkDesgin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractCompenet{

	
	 WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
@FindBy(xpath="//td[2]")
List<WebElement> prodOrderedName;

public Boolean orderList(String prodname)
{
	Boolean orderMatch =prodOrderedName.stream().anyMatch(s->s.getText().equalsIgnoreCase(prodname));
	return orderMatch;
}

}







/*public landingPage(WebDriver driver)
{
super(driver);
this.driver=driver;
PageFactory.initElements(driver, this); */