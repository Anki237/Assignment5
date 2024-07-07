package test3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
	WebDriver driver;
	@BeforeTest
	public void bt() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	@Test
	public void t1() {
		WebElement searchbox=driver.findElement(By.cssSelector("input[placeholder=\"Search products & brands\"]"));
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchbox.click();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='laptop';", searchbox);
		WebElement searchbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[onclick=\"submitSearchForm('go_header');\"]")));
		//js.executeScript("arguments[0].click();", searchbtn);
		searchbtn.click();

}
	@AfterTest
	public void end() {
		driver.close();
	}
}
