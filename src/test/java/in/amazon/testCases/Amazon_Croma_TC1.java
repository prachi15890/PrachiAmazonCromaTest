package in.amazon.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.amazon.pageObjects.Amazon;
import in.amazon.pageObjects.Croma;

public class Amazon_Croma_TC1 {
	
		WebDriver driver;

		@BeforeMethod
		public void setup() throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kedar\\eclipse-workspace\\practiceProj\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		@Test
		public void comparePrice() throws InterruptedException
		{
			String amazonURL = "https://www.amazon.in";
			Amazon amazon = new Amazon(driver, amazonURL);
			amazon.searchAmazonProduct();
			int amazonPrice = amazon.getAmazonProductPrice();
			
			String chromaURL = "https://www.croma.com";
			Croma croma = new Croma(driver,chromaURL);
			croma.searchCromaProduct();
			int cromaPrice = croma.getCromaProductPrice();
			
			if(amazonPrice<cromaPrice)
			{
				System.out.println("Final Result = "+amazonPrice);
			}
			else if(amazonPrice>cromaPrice)
			{
				System.out.println("Final Result = "+cromaPrice);
			}
			else 
			{
				System.out.println("Final Result = "+amazonPrice);
			}
			
		}
		
		@AfterMethod
		public void tearDown() {
			driver.close();
		}
		
	}


