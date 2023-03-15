package ders03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {
    public static void main(String[] args) {


        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement berlinElementi = driver.findElement(By.xpath("//*[@*'pid7_thumb']"));
        WebElement ncyElementi = driver.findElement(By.xpath("//*[@*'pid3_thumb']"));
        WebElement bostonElementi = driver.findElement(By.xpath("//*[@*'pid6_thumb']"));
        WebElement sailorElementi = driver.findElement(By.xpath("//*[@*'pid11_thumb']"));


        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(ncyElementi));
        System.out.println("Berlin1 id :" + berlin1.getAttribute("id"));


    }
}
