package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement firstAlert= driver.findElement(By.xpath("//h5[text()=' Alert (Simple Dialog)']/following-sibling::button//span[text()='Show']"));
		firstAlert.click();
		// managing simple Dialog
		Alert alert=driver.switchTo().alert();
		alert.accept();
		WebElement secondAlert= driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following-sibling::button//span[text()='Show']"));
		secondAlert.click();
		// managing confirm Dialog
		Alert alert2=driver.switchTo().alert();
		System.out.println(alert2.getText());
		
		alert2.dismiss();
		System.out.println(driver.findElement(By.xpath("//span[text()='User Clicked : Cancel']")).getText());
		
		//Handling Simple Sweet Alert//
		WebElement sweetAlert=driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']/following-sibling::button//span[text()='Show']"));
		sweetAlert.click();
		System.out.println(driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']/following-sibling::div//p")).getText());
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		
		//Handling Sweet Modal Dialog//
		
		WebElement sweetModalDialog=driver.findElement(By.xpath("//h5[text()='Sweet Modal Dialog']/following-sibling::button//span[text()='Show']"));
		sweetModalDialog.click();
		System.out.println(driver.findElement(By.xpath("//h5[text()='Sweet Modal Dialog']/following-sibling::div//p")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h5[text()='Sweet Modal Dialog']/following-sibling::div//p/../..//a//span")).click();
		
		//Handling Alert Prompt
		WebElement promptAlert= driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::button//span[text()='Show']"));
		promptAlert.click();
		Alert prompt= driver.switchTo().alert();
		System.out.println(prompt.getText());
		String inputText= "Prasanth";
		prompt.sendKeys(inputText);
		prompt.accept();
		String confirmationText= driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::button/following-sibling::span")).getText();
		if(confirmationText.contains(inputText))
			System.out.println("Test is Passed");
		//Sweet Alert (Confirmation)//
		WebElement sweetAlertConfirm= driver.findElement(By.xpath("//span[text()='Delete']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sweetAlertConfirm).click().perform();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		driver.close();
		
		
		
		
		

	}

}
