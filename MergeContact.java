package week4.day1.assignments;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		String title1=driver.getTitle();
		System.out.println(title1);
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
		Set<String> window1=driver.getWindowHandles();
		List<String> fromContact= new ArrayList<String>(window1);
	
		driver.switchTo().window(fromContact.get(1));
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]")).click();
		driver.switchTo().window(fromContact.get(0));
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		Set<String> window2=driver.getWindowHandles();
		Thread.sleep(5000);
		List<String> toContact= new ArrayList<String>(window2);
	
		driver.switchTo().window(toContact.get(1));
		
		//driver.switchTo().window(fromContact.get(1));
		Thread.sleep(5000);
		WebElement toContactLink= driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[2]"));
		toContactLink.click();
		
		
		//driver.findElement(By.xpath("(//a[@class='linktext'])[2]")).click();
		driver.switchTo().window(toContact.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		String title2=  driver.getTitle();
		boolean flag= title1.equals(title2);
		if(flag==false)
			System.out.println("Test is Passed" +title2 );
		driver.quit();
		
		
		
		

	}

}
