package in.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Croma {
	WebDriver driver;
	
	public Croma(WebDriver driver, String url)
	{
		driver.get(url);
		this.driver=driver;
	}
	
	By cromaSearchTextbox = By.xpath("//input[@name='search']");
	By cromaProductPrice = By.xpath("//div[@class='content-wrap']//following::h3//a[text()='Samsung Galaxy Z Fold 2 (256GB ROM, 12GB RAM, Mystic Bronze)']//following::div[@class='price-rating-wrap']//following::span[@class='amount']//ancestor::span[@class='new-price']");
	
	public void searchCromaProduct() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Samsung Galaxy Z Fold2 5G Mystic Bronze, 12GB RAM, 256GB Storage");
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public int getCromaProductPrice() throws InterruptedException
	{
		WebElement cromaProduct = driver.findElement(By.xpath("//div[@class='content-wrap']//following::h3//a[text()='Samsung Galaxy Z Fold 2 (256GB ROM, 12GB RAM, Mystic Bronze)']//following::div[@class='price-rating-wrap']//following::span[@class='amount']//ancestor::span[@class='new-price']"));
		Thread.sleep(500); 
	
		String croma = cromaProduct.getText();
		String newCromePrice = croma.substring(1, 8);
		String newCromaPrice = newCromePrice.replace(",", "");
		int cromaPrice = Integer.parseInt(newCromaPrice);
		System.out.println("Croma Price = "+cromaPrice);
		
		return cromaPrice;
	}

}
