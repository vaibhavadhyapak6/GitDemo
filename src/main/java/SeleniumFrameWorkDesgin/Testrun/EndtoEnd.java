package SeleniumFrameWorkDesgin.Testrun;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import DesignFrameWork.SeleniumFrameWorkDesgin.cartPage;
import DesignFrameWork.SeleniumFrameWorkDesgin.checkoutpage;
import DesignFrameWork.SeleniumFrameWorkDesgin.confirmationPage;
import DesignFrameWork.SeleniumFrameWorkDesgin.landingPage;
import DesignFrameWork.SeleniumFrameWorkDesgin.productCatloag;
import SeleniumFrameWorkDesgin.testcomponet.baseTest;

public class EndtoEnd extends baseTest{

	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
	@Test
		
	public void sumbitOrder() throws IOException, InterruptedException
	{
	
		String prodname = "ZARA COAT 3";
		String exptdmsg = "THANKYOU FOR THE ORDER.";
        String CountryName="India";
      //  landingPage Landpage= launchApplication();
       
		 productCatloag Prodcatloag=Landpage.loginApplication("Vaiadhyapak@gmail.com", "Takshvi@2024");
         List<WebElement> product=Prodcatloag.getProductList();
         Prodcatloag.addProductToCart(prodname);
         
        // Thread.sleep(5);
         cartPage cartpage=  Prodcatloag.goTocartsection();
        //Validate cart
		Boolean Match=cartpage.verifyProdDisplayed(prodname);
		Assert.assertTrue(Match);
        // click on checkout
		checkoutpage checkout=cartpage.checkout();
        // checkout page
		checkout.selectCountry(CountryName);
		confirmationPage confirmpage= checkout.submitOrder();
      //  WebElement successMsg=confirmpage.confirmtheOrderMsg();
      //  Assert.assertTrue(successMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       // Assert.assertEquals(successMsg, exptdmsg);
        

	//	Thread.sleep(5);
	//	driver.quit();

	}
	
		
	

}
