package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RowCountColumnCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> columnsInTable= driver.findElements(By.xpath("//caption[text()='The Three Most Popular JavaScript Libraries']/following-sibling::thead/tr/th"));
		List<String> columnHeaders= new ArrayList<String>();
		for (WebElement string : columnsInTable) {
			String values= string.getText();
			columnHeaders.add(values);
		}
		System.out.println(" Coulumn count is " + " " + columnHeaders.size() );
		
		List<WebElement> rows= driver.findElements(By.xpath("//caption[text()='The Three Most Popular JavaScript Libraries']/following-sibling::tbody/tr"));
		List<String> rowsCount= new ArrayList<String>();
		for (WebElement element : rows) {
			String value= element.getText();
			rowsCount.add(value);
		}
		
		System.out.println("Rows Count in Table is " + " "+ rowsCount.size() );
		driver.close();

	}

}
