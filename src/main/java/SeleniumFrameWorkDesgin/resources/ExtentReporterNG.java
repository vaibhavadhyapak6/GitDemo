package SeleniumFrameWorkDesgin.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		
		
		String path=System.getProperty("user.dir")+"//reports/index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		
	     extent.setSystemInfo("Tester", "Vaibhav");
	   //  extent.createTest(path);
	     
	     return extent;
	     
	     

		
	}

}
