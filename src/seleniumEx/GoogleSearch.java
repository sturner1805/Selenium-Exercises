package seleniumEx;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	
	static WebDriver driver;
	
	public static void main(String [] args){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://www.google.co.uk/");
		boolean result;
		
		try{
			driver.findElement(By.name("q"));
			result = true;
		}
		catch (NoSuchElementException e){
			System.out.println(e);
			result = false;
		}
		finally{
			driver.close();
		}
		
		if(result){
			System.out.println("---passed---");
		}else{
			System.out.println("---failed---");
		}
	}	
}	