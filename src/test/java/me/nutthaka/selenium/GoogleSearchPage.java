package me.nutthaka.selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {

    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "lst-ib")
    private WebElement searchBox;

    @FindBy(name = "btnG")
    private WebElement searchButton;

    public void open(String url){
        driver.get(url);
    }

    public void close(){
        driver.close();
    }

    public void enterSearchKeyword(String keyword){
        searchBox.sendKeys(keyword);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}
