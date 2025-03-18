package Automobile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class truck {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://sampleapp.tricentis.com/101/");
		driver.findElement(By.id("nav_truck")).click();
		//vehicle data
		driver.findElement(By.xpath("//option[@value='Toyota']")).click();
		driver.findElement(By.xpath("//input[@id='engineperformance']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@id='dateofmanufacture']")).sendKeys("02/21/2024");
		driver.findElement(By.xpath("//option[@value='8']")).click();
		driver.findElement(By.xpath("//option[@value='Petrol']")).click();
		driver.findElement(By.xpath("//input[@id='payload']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@id='totalweight']")).sendKeys("1200");
		driver.findElement(By.xpath("//input[@id='listprice']")).sendKeys("98000");
		driver.findElement(By.xpath("//input[@id='annualmileage']")).sendKeys("150");
		driver.findElement(By.xpath("//button[@id='nextenterinsurantdata']")).click();

//insurant data
		//enter insurant data
		driver.findElement(By.xpath("//input[@id=\"firstname\"]")).sendKeys("Isha");
		driver.findElement(By.xpath("//input[@id=\"lastname\"]")).sendKeys("More");
		driver.findElement(By.xpath("//input[@id='birthdate']")).sendKeys("03/21/2002");//error
		driver.findElement(By.xpath("//option[@value='India']")).click();
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("411030");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("PUNE");
		driver.findElement(By.xpath("//option[@value='Selfemployed']")).click();
		// Click the associated span or label for the checkbox
		WebElement checkboxLabel = driver.findElement(By.xpath("//label[contains(., 'Bungee Jumping')]"));
		checkboxLabel.click();
		driver.findElement(By.xpath("//button[@id='nextenterproductdata']")).click();//next

		//product data
				driver.findElement(By.xpath("//input[@id='startdate']")).sendKeys("03/30/2025");
				driver.findElement(By.xpath("//option[@value='10000000']")).click();
				driver.findElement(By.xpath("//option[@value='Partial Coverage']")).click();
				WebElement op = driver.findElement(By.xpath("//label[@class='ideal-radiocheck-label' and contains(., 'Euro Protection')]"));
				op.click();

				driver.findElement(By.xpath("//button[@id='nextselectpriceoption']")).click();//next
		
				//price option
				  String expPrice = "367.00";
			        String expOnlineClaim ="Submit";
			        String expClaimDiscount = "2";
			        String expCover = "Limited";


			         String actPrice = driver.findElement(By.id("selectgold_price")).getText();
			         String actOnlineClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[3]")).getText();
			         String actClaimDiscount = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[3]")).getText();
			         String actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[3]")).getText();


			        if((expPrice.equals(actPrice)) && (expOnlineClaim.equals(actOnlineClaim)) && (expClaimDiscount.equals(actClaimDiscount)) && (expCover.equals(actCover)))
			        {
			        	driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[2]/span")).click();
			        }
			        else
			        {
			        	System.out.println("We can't procced further");
			        }
					
					 //next 
			        driver.findElement(By.xpath("//button[@id='nextsendquote']")).click();
					 
					 //email 
			         driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ipmore21@gmail.com");
					 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Isha");
					 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Ishm@1234"); 
					 driver.findElement(By.xpath("//input[@id='confirmpassword']")).sendKeys("Ishm@1234");
					 driver.findElement(By.xpath("//button[@id='sendemail']")).click();
					 
					 //screenshot 
					 driver.findElement(By.xpath("//div[@class='sweet-alert showSweetAlert visible']"));
					 
					 //screenshot 
					 File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					 FileUtils.copyFile(srcFile, new File("E:\\Automation\\Automation_project\\src\\Automobile\\email2.jpg"));
					 
					 driver.findElement(By.xpath("//button[@class='confirm']")).click();
					 
					 //home page 
					 driver.findElement(By.xpath("//a[@id='nav_home']")).click();
					
			       
}
}