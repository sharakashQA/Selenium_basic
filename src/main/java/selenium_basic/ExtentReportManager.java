package selenium_basic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	// Implement methods to manage Extent Reports
	public ExtentReports extent;
	
	public ExtentTest test;
	
	
		public void onStart(ITestContext context) {
			sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-reports/ExtentReport.html");
			
			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setReportName("Test Execution Report");
			sparkReporter.config().setTheme(Theme.STANDARD);
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("Host Name", "Localhost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Test User");	
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Browser name","chrome");
			
		
		}
		
		
		
		public void onTestSuccess(ITestResult result) { 
			test= extent.createTest(result.getName()); //create new entry in the report
			test.log(Status.PASS, "Test Case Passed is " + result.getName()); //send the passed information to the report with GREEN color highlighted
		}
		
		public void onTestFailure(ITestResult result) { 
			test= extent.createTest(result.getName()); //create new entry in the report
			test.log(Status.FAIL, "Test Case Failed is " + result.getName()); //send the passed information to the report with GREEN color highlighted
		}
		
		public void onTestSkipped(ITestResult result) { 
			test= extent.createTest(result.getName()); //create new entry in the report
			test.log(Status.SKIP, "Test Case Skipped is " + result.getName()); //send the passed information to the report with GREEN color highlighted
		}

	
public void onFinish(ITestContext context) { 
	extent.flush();

}
}
