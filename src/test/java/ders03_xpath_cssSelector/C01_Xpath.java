package ders03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {

        // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");


        // Add element butonuna basin

        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        // Delete butonun gorunur oldugunu test edin

        WebElement deleteButtonElementi = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteButtonElementi.isDisplayed()){
            System.out.println("delete button testi PASSED");
        }else {
            System.out.println("delete button testi FAILED");
        }

        // Delete butonuna basin

        deleteButtonElementi.click();

        // "Add/Remove Elements" yazisinin gorunur oldugunu test edin

        WebElement addRemoveElementi = driver.findElement(By.xpath("//h3"));

        if (addRemoveElementi.isDisplayed()){
            System.out.println("add yazi testi PASSED");
        }else {
            System.out.println("add yazi testi FAILED");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
