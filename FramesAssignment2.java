package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame1= driver.findElement(By.xpath("//h5[text()=' Click Me (Inside frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		driver.switchTo().defaultContent();
		WebElement frame2= driver.findElement(By.xpath("//h5[text()=' Click Me (Inside Nested frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame2);
		WebElement  nestedFrame= driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(nestedFrame);
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		driver.switchTo().defaultContent();
		driver.close();
	}

}
