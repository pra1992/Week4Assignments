package week4.day2.assignments;



import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssesmentForWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions actions = new Actions(driver);
		WebElement stockMarkertLink= driver.findElement(By.xpath("//a[text()='STOCK MARKET ']"));
		actions.moveToElement(stockMarkertLink).click().perform();
		WebElement nseBulkDeals= driver.findElement(By.xpath("//div[@class='row ch-bar-block']//a[text()='NSE Bulk Deals']"));
		actions.moveToElement(nseBulkDeals).click().perform();
		List<WebElement> webelement= driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//td[2]"));
		List<String> securityList= new ArrayList<String>();
		for (WebElement eachElement : webelement) {
			String values= eachElement.getText();
			securityList.add(values);
		}
		System.out.println("Size of List" + securityList.size());
		
		Set<String> setOfSecurityList= new HashSet<String>(securityList);
		for (String string : setOfSecurityList) {
			
			System.out.println(string);
			
		}
		
		System.out.println("Size of Set" +setOfSecurityList.size() );
		
  driver.close();
	}

}
