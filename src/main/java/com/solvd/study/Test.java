package com.solvd.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/rstoliar/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        File myFile = new File("src/main/resources/config.properties");
        Properties properties = new Properties();

        try {
            properties.load(new FileReader(myFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.get(properties.getProperty("url"));
        driver.findElement(By.cssSelector(".hekEU")).sendKeys("мотоцикл хонда");
        driver.findElement(By.cssSelector("header button[type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> webElementList = driver.findElements(By.cssSelector("span.uvIdx.tg78x.WZVc3.GI6Pu"));
        webElementList.forEach(el -> System.out.println(el.getText()));
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.quit();

    }
}
