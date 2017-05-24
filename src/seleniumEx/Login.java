package seleniumEx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	static WebDriver driver;
	
	public static void main(String [] args) throws IOException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://facebook.com/");
		
		loginAndVerify();
		cookieWriter();
		logout();

	}
	
	public static void loginAndVerify(){

		final String userName = "sturner1805@hotmail.co.uk";
		final String password = "renrutmas#1805fb";
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Searching....");
		WebElement usernameBox = driver.findElement(By.id("email"));
		WebElement passwordBox = driver.findElement(By.name("pass"));
		WebElement loginBtn = driver.findElement(By.id("loginbutton"));
		
		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		loginBtn.click();
				
		try{
			
			driver.findElement(By.id("u_ps_0_1_2"));
			System.out.println("Passed");
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Failed");
		}
	}
	
	public static void cookieWriter() throws IOException{
		File f = new File ("C:\\Users\\Administrator\\Desktop\\cookie.data");
		f.delete();
		f.createNewFile();
		BufferedWriter bos = new BufferedWriter (new FileWriter(f));
		
		for (Cookie ck : driver.manage().getCookies()){
			bos.write((ck.getName()+"; "+ck.getValue()+"; "+ck.getDomain()+"; "+ck.getPath()+"; "+ck.getExpiry()+"; "+ck.isSecure()));
			bos.newLine();
			
		}
		bos.close();
	}
	
	public static void logout(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Searching....");
		
		WebElement menu = driver.findElement(By.id("userNavigationLabel"));
		menu.click();
		WebElement logoutBtn = driver.findElement(By.id("js_5c"));
		logoutBtn.click();
		
//		try{	
//			driver.findElement(By.id("u_jsonp_2_8"));
//			System.out.println("Passed");
//		}
//		catch (Exception e){
//			e.printStackTrace();
//			System.out.println("Failed");
//		}
		
		
	}
}
