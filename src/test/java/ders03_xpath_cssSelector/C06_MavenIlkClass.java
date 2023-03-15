package ders03_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class C06_MavenIlkClass {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- httpss://www.amazon.com sayfasina gidelim

        driver.get("https://www.amazon.com");

        // 2- arama kutusunu locate edelim

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        // 3- "Samsung headphones" ile arama yapalim

        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        // 4- Bulunan sonuc sayisini yazdiralim

        System.out.println(driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText());

        // 5- ilk urunu tiklayalim

        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        // 6- sayfadaki tum basliklari yazdiralim
        // soldaki aramayi daraltabilecegimiz basliklar

        driver.navigate().back();

        List<WebElement> baslikElementlerListesi =
                driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));

        int baslikNo1=1;

        for (WebElement eachElement:baslikElementlerListesi
             ) {
            System.out.println(baslikNo1 + "-----" + eachElement.getText());
            baslikNo1++;
        }

        Thread.sleep(3000);
        driver.close();
    }

}
