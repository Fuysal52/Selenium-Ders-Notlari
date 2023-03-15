package ders03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C04_CookiesGecme {
    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://google.com");

        // cookies 'i kabul ederek ekranini kapatin

        driver.findElement(By.xpath("//div[text()='Tümünü kabul et']")).click();

        // arama cucbuguna Java yazin

        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@name='q']"));

        aramaCubugu.sendKeys("Java" + Keys.ENTER);

        // bulunan sonuc sayisinin 100 binden fazla oldugunu test edin

        WebElement sonucSayiElementi = driver.findElement(By.xpath("//div[@id='result-stats']"));

        // Yaklaşık 1.560.000.000 sonuç bulundu (0,31 saniye)

        String sonucYazisi = sonucSayiElementi.getText();
        String[] sonucYaziArr = sonucYazisi.split( " ");

        String sonucSayisiStr = sonucYaziArr[1];
        sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");

        int actualSonucSayisi = Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi = 100000;

        if (actualSonucSayisi>expectedSonucSayisi){
            System.out.println("Arama sonuc sayisi testi PASSED");
        }else {
            System.out.println("Arama sonuc saysis testi FAILED");
        }


        driver.close();
    }
}
