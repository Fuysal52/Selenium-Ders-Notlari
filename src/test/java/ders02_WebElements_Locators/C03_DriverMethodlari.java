package ders02_WebElements_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_DriverMethodlari {
    public static void main(String[] args) {

        // Yeni bir class olusturalim
        // ChromeDriver olusturarak facebook sayfasina gidin

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com");

        // ve sayfa basligini (title) "facebook"oldugunu dogrulayin (verify)
        // degilse dogru basligi yazdirin

        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("facebook title testi PASSED");
        } else {
            System.out.println("facbook title testi FAILED" +
                              "\nGerceklesen title: " + actualTitle);
        }

        // sayfa URL'nin "facebook" icerdigini dogrulayin
        // icermiyorsa "actual"  URL'yi yazdirin

        String expectedIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Facebook url testi PASSED");
        }else {
            System.out.println("Facebbok url testi FAILED" +
                              "\nGerceklesen url : " + actualUrl);
        }

        // https://www.walmart.com/ sayfasina gidin

        driver.get("https://www.walmart.com");

        // Sayfa basliginin "Walmart.com" icerdigini dogrulayin

        String walMartExpectedIcerik = "Walmart.com";
        String walMartActualTitel = driver.getTitle();

        if (walMartActualTitel.contains(walMartExpectedIcerik)){
            System.out.println("Walmart titel testi PASSED");
        }else {
            System.out.println("Walmart titel testi FAILED");
        }

        // TEKRAR FACEBOOK SAYFASINA DONUN

        driver.navigate().back();

        // sayfayi yenileyin

        driver.navigate().refresh();

        // sayfayi tam sayfa maximlize yapin

        driver.manage().window().maximize();

        // browser i kapatin

        driver.close();

    }

}
