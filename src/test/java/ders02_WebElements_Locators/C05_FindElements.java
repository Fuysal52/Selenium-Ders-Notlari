package ders02_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C05_FindElemens {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusuna java yazdirip aratin
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("java");
        aramakutusu.submit();

        // arama sonuclarinda cikan resimdeki yazilari yazdirin

        List<WebElement> aramaSonuclariElementList = driver.findElements(By.className("sg-col-inner"));

        System.out.println(aramaSonuclariElementList.size());

        // bu 86 elementi yazdirin

        int elementNo= 1;
        for (WebElement eachElement:aramaSonuclariElementList
             ) {
            System.out.println(elementNo + "---" + eachElement.getText());
            elementNo++;
        }

        Thread.sleep(3000);
        driver.close();

    }
}
