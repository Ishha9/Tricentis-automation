package Automobile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class motorcycle {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://sampleapp.tricentis.com/101/");

        WebElement cl =driver.findElement(By.id("nav_motorcycle"));
        cl.click();

        WebElement f =driver.findElement(By.xpath("//option[@value='Skoda']"));
        		f.click();


        WebElement model=driver.findElement(By.xpath("//*[@id=\"model\"]/option[2]"));
        model.click();
        		

        WebElement cap= driver.findElement(By.xpath("//*[@id=\"cylindercapacity\"]"));
        cap.sendKeys("100");
        
        WebElement ep =driver.findElement(By.xpath("//input[@id='engineperformance']"));
        ep.sendKeys("250");
        
        WebElement dom = driver.findElement(By.xpath("//input[@id='dateofmanufacture']"));
        dom.sendKeys("01/01/2025");
    

        WebElement no=driver.findElement(By.xpath("//option[@value='2']"));
        no.click();
		
      
		driver.findElement(By.xpath("//input[@id='listprice']")).sendKeys("2000");
		driver.findElement(By.xpath("//input[@id='annualmileage']")).sendKeys("125");
		driver.findElement(By.xpath("//button[@id='nextenterinsurantdata']")).click();

		//

        WebElement fn = driver.findElement(By.id("firstname"));
        fn.sendKeys("isha");
        WebElement ln = driver.findElement(By.id("lastname"));
        ln.sendKeys("More");
        WebElement dob = driver.findElement(By.id("birthdate"));
        dob.sendKeys("03/21/2002");

        List<WebElement> gen = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div/div/form/div/section[2]/div[4]/p/label"));
        for (WebElement ele3 : gen) gen.get(1).click();
        WebElement sadd = driver.findElement(By.id("streetaddress"));
        sadd.sendKeys("At.Pune");

        WebElement coun = driver.findElement(By.id("country"));
        Select cnt = new Select(coun);
        cnt.selectByValue("India");

        WebElement zpcd = driver.findElement(By.id("zipcode"));
        zpcd.sendKeys("411030");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Pune");

        WebElement occu = driver.findElement(By.id("occupation"));
        Select oc = new Select(occu);
        oc.selectByValue("Selfemployed");

        List<WebElement> hb = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div/div/form/div/section[2]/div[10]/p/label"));
        for (WebElement ele : hb) {
            if (ele.isSelected() == false) {
                hb.get(0).click();
                hb.get(1).click();
                hb.get(2).click();
                break;
            }
        }

        WebElement nxt1 = driver.findElement(By.id("nextenterproductdata"));
        nxt1.click();
        ///
        
        
        WebElement sd = driver.findElement(By.id("startdate"));
        sd.sendKeys("03/28/2025");

        WebElement insum = driver.findElement(By.id("insurancesum"));
        Select ins = new Select(insum);
        List<WebElement> i1 = ins.getOptions();
        for (WebElement e : i1) i1.get(5).click();

        WebElement damins = driver.findElement(By.id("damageinsurance"));
        Select d = new Select(damins);
        List<WebElement> i2 = d.getOptions();
        for (WebElement e : i2) i2.get(2).click();

        WebElement op = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/form/div/section[3]/div[4]/p/label[1]"));
        op.click();


        WebElement nxt2 = driver.findElement(By.id("nextselectpriceoption"));
        nxt2.click();
        //price
        
        String expPrice = "1,066.00";
        String expOnlineClaim ="Submit";
        String expClaimDiscount = "5";
        String expCover = "Limited";


         String actPrice = driver.findElement(By.id("selectplatinum_price")).getText();
         String actOnlineClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[4]")).getText();
         String actClaimDiscount = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[4]")).getText();
         String actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[4]")).getText();


        if((expPrice.equals(actPrice)) && (expOnlineClaim.equals(actOnlineClaim)) && (expClaimDiscount.equals(actClaimDiscount)) && (expCover.equals(actCover)))
        {
        	driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]/span")).click();
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
FileUtils.copyFile(srcFile, new File("E:\\Automation\\Automation_project\\src\\Automobile\\email3.jpg"));

driver.findElement(By.xpath("//button[@class='confirm']")).click();

//home page
driver.findElement(By.xpath("//a[@id='nav_home']")).click();

       
	}

}
