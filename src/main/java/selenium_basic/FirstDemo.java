package selenium_basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstDemo {
	public void test() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\driver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//maximize the browser window
		driver.manage().window().maximize();
		//navigate to the url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//retriving title and url of the page
		String title = driver.getTitle();
		
		System.out.println("Title of the page is: " + title);
		driver.close();
		driver.quit();
	}
	
	

	
}
