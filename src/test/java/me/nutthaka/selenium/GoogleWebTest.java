package me.nutthaka.selenium;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class GoogleWebTest {

    @Test
    public void testGoogleSearch() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "/Users/hskogsru/bin/chromedriver");
//        WebDriver driver = new ChromeDriver();
        String url = "http://www.google.com.au";
        driver.get(url);
        WebElement searchTextBox = driver.findElement(By.id("lst-ib"));
        searchTextBox.sendKeys("arclight");
        WebElement searchButton = driver.findElement(By.name("btnG"));
        searchButton.click();
        Thread.sleep(3000);
        String pageTitle = driver.getTitle();
        assertThat(pageTitle, is("arclight - Google Search"));
        driver.close();
    }


}
