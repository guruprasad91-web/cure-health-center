package CURAHealthCare;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CuraHealthCareTest {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Seleniumwebdriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.name("q")).sendKeys("https://katalon-demo-cura.herokuapp.com/");
		//driver.findElement(By.name("gNO89b")).click();
		driver.findElement(By.id("menu-toggle")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
		WebElement ddown = driver.findElement(By.name("facility"));
        Select select = new Select (ddown);
        select.selectByValue("Hongkong CURA Healthcare Center");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.tagName("input")).click();
		driver.findElement(By.id("radio_program_medicare")).click();
		driver.findElement(By.id("txt_visit_date")).sendKeys("22/06/2022");
		driver.findElement(By.name("comment")).sendKeys("Please Acknowledge me");
		driver.findElement(By.id("btn-book-appointment")).click();
		
		
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilename);
		

		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(".//screenshot/"+screenshotfilename+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id("menu-toggle")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.quit();
		
		driver.close();
		
	}

}
		

