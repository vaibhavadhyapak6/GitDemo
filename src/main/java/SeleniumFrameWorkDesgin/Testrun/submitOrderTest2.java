package SeleniumFrameWorkDesgin.Testrun;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DesignFrameWork.SeleniumFrameWorkDesgin.OrderPage;
import DesignFrameWork.SeleniumFrameWorkDesgin.cartPage;
import DesignFrameWork.SeleniumFrameWorkDesgin.checkoutpage;
import DesignFrameWork.SeleniumFrameWorkDesgin.confirmationPage;
import DesignFrameWork.SeleniumFrameWorkDesgin.productCatloag;
import SeleniumFrameWorkDesgin.testcomponet.baseTest;





public class submitOrderTest2 extends baseTest{

String prodname = "ZARA COAT 3";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
		
	public void sumbitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
	
		
		String exptdmsg = "THANKYOU FOR THE ORDER.";
        String CountryName="India";
      //  landingPage Landpage= launchApplication();
        
        productCatloag Prodcatloag=Landpage.loginApplication(input.get("email"),input.get("password"));
       
		// productCatloag Prodcatloag=Landpage.loginApplication(emailid, pwd);
        // List<WebElement> product=Prodcatloag.getProductList();
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
	
	@Test(dependsOnMethods= {"sumbitOrder"})
	
	public void orderHistory() 
	{
	
		 productCatloag Prodcatloag=Landpage.loginApplication("Vaiadhyapak@gmail.com", "Takshvi@2024");
		 OrderPage orderpage= Prodcatloag.goToOrderPage();
		 Assert.assertTrue(orderpage.orderList(prodname));
		
		
	}
	
	@DataProvider
	
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data =getJsonreaderTomap("C:\\Users\\vaibhava\\Desktop\\my learning\\Framework\\SeleniumFrameWorkDesgin\\src\\main\\java\\Datareader\\jsondata.json");
        return new Object[][] {{data.get(0)}};
		
		//return new Object[][] {{"Vaiadhyapak@gmail.com","Takshvi@2024","ZARA COAT 3"},{"Vaiadhyapak@gmail.com","Takshvi@2024","Addidas"}};
	}
	
}


		