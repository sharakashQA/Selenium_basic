package selenium_basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstDemo  {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Public\\driver\\chromedriver-win64\\chromedriver.exe");
   
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
		// maximize the browser window
		driver.manage().window().maximize();

	}

	@Test
	public void launchurl() {
		// navigate to the url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// retriving title and url of the page
		String title = driver.getTitle();

		System.out.println("Title of the page is: " + title);

		String window = driver.getWindowHandle();

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
