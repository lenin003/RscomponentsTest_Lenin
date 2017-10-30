package com.rsComponent.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(id = "searchTerm")
    private WebElement searchText;

    @FindBy(id = "btnSearch")
    private WebElement searchButton;

    @FindBy(css = ".keyValue.bold")
    private WebElement rsPartnoCheck;

    @FindBy(css = ".searchResults")
    private WebElement searchResultsFound;

    @FindBy(css = "#zeroResultBody>h2")
    private WebElement searchResultsNotFound;

    public void enterTextinsearch(String rspartno) {
        searchText.sendKeys(rspartno);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void checkResultsForRspartno(String rspartno) {
        String rsPartValueBefore = rspartno;
        String searchAfterValue = rsPartnoCheck.getText();
        System.out.println("searchAfterValue:" + searchAfterValue);
        Assert.assertEquals(searchAfterValue, rsPartValueBefore);
    }

    public void checkSearchResultsFound() {
        searchResultsFound.isDisplayed();
    }

    public void checkSearchResultsNotFound() {
        searchResultsNotFound.isDisplayed();
    }

    private WebDriver driver;

    public SearchPage(WebDriver driver) throws Throwable {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}