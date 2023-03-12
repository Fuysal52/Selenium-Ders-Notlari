package ders02_WebElements_Locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C01_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");


        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(ops);

        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getPosition());

        // olculeri ve konumu degistirelim

        driver.manage().window().setSize(new Dimension(800,800));
        driver.manage().window().setPosition(new Point(40,100));


        Thread.sleep(2000);
        driver.close();
    }

}
