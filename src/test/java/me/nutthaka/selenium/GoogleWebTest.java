package me.nutthaka.selenium;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class GoogleWebTest {

    @Test
    public void testGoogleSearch() {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        String url = "http://www.google.com.au";
        driver.get(url);

        WebElement searchTextBox = driver.findElement(By.id("lst-ib"));
        searchTextBox.sendKeys("arclight");
        WebElement searchButton = driver.findElement(By.name("btnG"));

        searchButton.click();
//        wait.until();

        String pageTitle = driver.getTitle();
        assertThat(pageTitle, is("arclight - Google Search"));

        driver.close();
    }

    @Test
    public void testGoogleSearchUsingPageObject() throws InterruptedException {
        GoogleSearchPage page = PageFactory.initElements(new FirefoxDriver(), GoogleSearchPage.class);
        page.open("http://www.google.com.au");

        page.enterSearchKeyword("arclight");
        page.clickSearchButton();
        Thread.sleep(2000);

        assertThat(page.getPageTitle(), is("arclight - Google Search"));
        page.close();
    }


}
