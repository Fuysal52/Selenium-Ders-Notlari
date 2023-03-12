package ders01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C01_SeleniumGiris {
    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");


        WebDriver driver = new ChromeDriver(ops);
        driver.get("https://www.amazon.com");
    }
}
