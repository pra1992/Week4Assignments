package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame1= driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Learn Frames");
		//switching to frame 3 to select the checkbox//
		WebElement frame3= driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame3);
		//selecting the checkbox//
		driver.findElement(By.xpath("//input[@id='a']")).click();
		//returning to default page and switching to the frame 2//
		
		driver.switchTo().defaultContent();
		//selecting Animals option in frame 2
		WebElement frame2= driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);		
		WebElement dd= driver.findElement(By.xpath("//select[@id='animals']"));
		Select seelct= new Select(dd);
		seelct.selectByValue("babycat");
		System.out.println(dd.getAttribute("value"));
		
		
		//return to default page
		driver.switchTo().defaultContent();
		driver.close();
		
		

	}

}
