package ders02_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C06_Locators {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.amazon.com sayfasina gidin

        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike" yazdirin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);

        // goruntulenen sonuclarin sayisini yazdirin

        WebElement sonucYaziElementi = driver.findElement(By.className("rush-component"));
        System.out.println(sonucYaziElementi.getText());

        // Listeden ilk urunun resmine tiklayin

        driver.findElement(By.className("s-image")).click();

        Thread.sleep(3000);
        driver.close();
    }
}
