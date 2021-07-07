package in.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Amazon {
	
	WebDriver driver;
	
	public Amazon(WebDriver driver,String url)
	{
		driver.get(url);
		this.driver=driver;
	}
	
	By amazonSearchTextbox = By.xpath("//input[@id='twotabsearchtextbox']");
	By amazonProductPrice = By.xpath("//span[text()='Samsung Galaxy Z Fold2 5G Mystic Bronze, 12GB RAM, 256GB Storage']//ancestor::div[contains(@class,'a-section') and contains(@class,'a-spacing-none')][1]//following-sibling::div[@class='sg-row']//child::span[@class='a-price-whole']");
	
	public void searchAmazonProduct() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Samsung Galaxy Z Fold 2 (256GB ROM, 12GB RAM, Mystic Bronze)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}
	
	public int getAmazonProductPrice() throws InterruptedException
	{
		WebElement amazonProduct = driver.findElement(By.xpath("//span[text()='Samsung Galaxy Z Fold2 5G Mystic Bronze, 12GB RAM, 256GB Storage']//ancestor::div[contains(@class,'a-section') and contains(@class,'a-spacing-none')][1]//following-sibling::div[@class='sg-row']//child::span[@class='a-price-whole']"));
		String amazon = amazonProduct.getText();
		String newAmazonPrice = amazon.replace(",", "");
		int amazonPrice = Integer.parseInt(newAmazonPrice);
		System.out.println("Amazon Price = "+ amazonPrice);
		return amazonPrice;
	}
}
