package ders02_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C06_AutomationExercise {
    public static void main(String[] args) throws InterruptedException {

        // bir test class'i olusturun ilgili ayarlari yapin

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.automationexercise.com adresine gidin

        driver.get("https://www.automationexercise.com");

        // sayfada 147 adet link bulundugunu test edin

        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkElementleriList.size();

        if (expectedLinkSayisi==actualLinkSayisi){
            System.out.println("link sayisi testi PASSED");
        }else {
            System.out.println("link sayisi testi FAILED" +
                    "\nSayfada var olan link sayisi : " + actualLinkSayisi);
        }

        // Products linkine tiklayin

       driver.findElement(By.partialLinkText("Products")).click();

        // special offer yazisinin gprundugunu test edin

        WebElement specialOfferElement = driver.findElement(By.id("sale_image"));
        if (specialOfferElement.isDisplayed()){
            System.out.println("Special offer testi PASSED");
        } else {
            System.out.println("Special offer testi FAILED");
        }

        // sayfayi kapatin

        Thread.sleep(3000);
        driver.close();
    }
}
