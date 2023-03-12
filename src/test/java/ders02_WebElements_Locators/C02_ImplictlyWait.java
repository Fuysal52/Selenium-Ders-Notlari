package ders02_WebElements_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_ImplictlyWait {
    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }
}
