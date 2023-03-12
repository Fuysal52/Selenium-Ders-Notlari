package ders02_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C04_WebElement {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfa ya gidin.

        driver.get("https://www.amazon.com");

        // arama kutusunu locate edip bir web element olarak kaydedin
        // id'si twotabsearchtextbox olan webelelemnt seklinde locate edecegiz

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));


        // arama kutusuna "Nutella" yazip aratin

        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        Thread.sleep(3000);
        driver.close();
    }
}
