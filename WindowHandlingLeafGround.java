package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingLeafGround {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windows=driver.getWindowHandles();
		List<String>  openWindows= new ArrayList<String>(windows);
		// No of windows opened in handles is the size of List
		if(openWindows.size()>0)
			System.out.println("We have more than 1 window opened");
		//switching to child window
		driver.switchTo().window(openWindows.get(1));
		//switching to parent window
		
  /*********Find the number of open tabs*************/
		
		//Switching to parent window and finding new window handles
		driver.switchTo().window(openWindows.get(0));
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windows1=driver.getWindowHandles();
		List<String>  openWindows1= new ArrayList<String>(windows1);
		if(openWindows1.size()>openWindows.size())
			System.out.println(openWindows1.size());
		
		
		/*****wait for 2 tabs to open  AND Open with Delay***********/
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> windows3=driver.getWindowHandles();
		List<String> openWindows3= new ArrayList<String>(windows3);
		System.out.println(openWindows3.size());
		
		/******Close All Windows except primary****/
		
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String>  windows4=driver.getWindowHandles();
		List<String> openWindows4 = new ArrayList<String>(windows4);
		System.out.println(openWindows4.size());
		for (int i=1; i<=(openWindows4.size())-1; i++ ) {
			driver.switchTo().window(openWindows4.get(i));
			driver.close();
		}
		
		// at last quit all windows
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}