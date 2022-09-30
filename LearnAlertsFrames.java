package week4.day1.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlertsFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		WebElement frame=driver.findElement(By.xpath("//div[@id='iframecontainer']//iframe"));
		driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Prasanth");
        String name2= "Sankar";
        
        alert.sendKeys(name2);
        alert.accept();
        String expectedText= driver.findElement(By.xpath("//button[text()='Try it']/following-sibling::p")).getText();
        if(expectedText.contains(name2))
        	System.out.println("TEST IS PASSED");
        driver.switchTo().defaultContent();
        driver.quit();
        
        
		

	}

}
