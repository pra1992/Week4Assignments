package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions actions = new Actions(driver);
		WebElement source= driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement target= driver.findElement(By.xpath("//p[text()='Drop here']"));
		actions.dragAndDrop(source, target).perform();
		WebElement dragMeAround= driver.findElement(By.xpath("//span[text()='Drag me around']"));
		actions.dragAndDropBy(dragMeAround, 10, 20).perform();
		
		driver.close();
		
		

	}

}
