package test3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ebay {
	WebDriver driver;
	@BeforeTest
	public void bt() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	@Test
	public void t1() {
		WebElement search = driver.findElement(By.id("gh-ac"));
		search.sendKeys("Shoes");
		driver.findElement(By.cssSelector("input[value=\"Search\"]")).click();
		WebElement scrollto=driver.findElement(By.id("srp-ipp-label-text"));
		Actions act=new Actions(driver);
		act.moveToElement(scrollto).build().perform();
		WebElement search1 = driver.findElement(By.id("gh-ac"));
		Actions act1=new Actions(driver);
		act1.moveToElement(search1).build().perform();
		search1.sendKeys(Keys.CONTROL+"a");
		search1.sendKeys(Keys.BACK_SPACE);
		
	}
	@AfterTest
	public void end() {
		driver.close();
	}
}
