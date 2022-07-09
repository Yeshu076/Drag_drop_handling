package DragnDrop;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

import Base.Base;

public class DandD extends Base{
	
public void OpenUrl(){
	
	driver.get("https://demoqa.com/droppable/");
}

//To search for the details
public void search() throws InterruptedException, IOException{
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Please select Browser choice below :-");
	System.out.println("a) Enter 1 for Google Chrome\n"
			+ "b) Enter 2 for Mozilla FireFox ");
	int ch= sc.nextInt();
	
	if(ch==1) {
		driver=new ChromeDriver();
	} else if(ch==2){
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("Wrong Input entered");
	}
	OpenUrl();
	WebElement drag =driver.findElement(By.id("draggable"));
	WebElement drop=driver.findElement(By.id("droppable"));
	System.out.println("location is"+drag.getLocation());
	
	Actions actions = new Actions(driver);
	actions.dragAndDrop(drag, drop).perform();
	
	String textTo = drop.getText();
	if(textTo.equals("Dropped!")) {
	System.out.println("PASS: File is dropped to target as expected");
	}
	else {
	System.out.println("FAIL: File couldn't be dropped to target as expected");
	}
	driver.get("https://demoqa.com/date-picker/");
	WebElement dateBox = driver.findElement(By.id("datePickerMonthYearInput"));
	dateBox.click();
	driver.findElement(By.xpath("//div[text()='20']")).click();
	driver.findElement(By.id("dateAndTimePickerInput")).click();
	driver.findElement(By.xpath("//div[text()='20']")).click();
	driver.findElement(By.xpath("//li[text()='06:00']")).click();
	TakesScreenshot capture = (TakesScreenshot) driver;
	File srcFile = capture.getScreenshotAs(OutputType.FILE);
	File destFile = new File(System.getProperty("user.dir")
			+ "/Screenshot/Date.png");
	Files.copy(srcFile, destFile);
    Thread.sleep(5000);
}

public static void main(String[] args) throws InterruptedException, IOException{
	DandD ha= new DandD();
	ha.search();
	ha.closeBrowser();
}
}

