package seleniumEx;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionBuilder {
	
	static WebDriver driver;
	static Actions builder;
		
	public static void main (String [] args){
	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("file:///C:/Users/Administrator/Desktop/HTML/HTML/Sortable.html");	
		WebElement boxOne = driver.findElement(By.name("one"));
		WebElement boxTwo = driver.findElement(By.name("two"));
		WebElement boxThree = driver.findElement(By.name("three"));
		boolean result;		
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.name("six"));
			result = true;
		}catch (NoSuchElementException e){
			System.out.println(e);
			result = false;
		}finally{
			driver.close();
		}
		
		if(result){
			System.out.println("Load Passed");
		}else{
			System.out.println("Load Failed");
		}
		
		System.out.println(boxOne.getLocation());
		
		builder = new Actions(driver);
		
		builder.moveToElement(boxThree).clickAndHold().moveToElement(boxTwo).perform();
		
	}	
}
