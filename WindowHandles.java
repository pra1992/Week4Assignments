package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.get("https://www.irctc.co.in/nget/train-search");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
    
    Set<String> windows=driver.getWindowHandles();
    List<String> openWindows= new ArrayList<String>(windows);
    
    driver.switchTo().window(openWindows.get(1));
  System.out.println(driver.getTitle()); 
    driver.close();
    
    
    
    
    
	}

}
