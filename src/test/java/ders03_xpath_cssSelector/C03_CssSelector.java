package ders03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_CssSelector {
    public static void main(String[] args) {

        // 1- amazon adresine gidin

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");


        // 2- Browser'i tam sayfa yapin

        driver.manage().window().maximize();

        // 3- Sayfayi "refresh" yapin

        driver.navigate().refresh();

        // 4- sayfa basliginin "Spend less" ifadesi icerdigini test edin

        String expectedIcerik = "Spend less";
        String actualIcerik = driver.getTitle();

        if (actualIcerik.contains(expectedIcerik)){
            System.out.println("Titel testi PASSED");
        }else {
            System.out.println("Titel testi FAILED");
        }

        // 5- gift cards sekmesine basin

        driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_cs_gc']")).click();

        // 6- birthday butonun basin

        driver.findElement(By.cssSelector("a[aria-label='Birthday']")).click();

        // 7- best seller bolumunden ilk urunu tiklayin

        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();

        // 8- gift card details den 25 secin

        driver.findElement(By.cssSelector("#gc-mini-picker-amount-1")).click();

        // 9- urun ucretinin 25 $ oldugunu test edin

        WebElement ucretElementi = driver.findElement(By.cssSelector("#gc-live-preview-amount"));

        String expectedUcret = "25$";
        String actualUcret = ucretElementi.getText();

        if (expectedUcret==actualUcret){
            System.out.println("Ucret testi PASSED");
        }else {
            System.out.println("Ucret testi FAILED"+
                            "\nActual ucret: " + actualUcret);
        }

        // 10- sayfayi kapatin
        driver.close();
    }
}
