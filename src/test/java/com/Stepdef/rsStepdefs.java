package com.Stepdef;

import com.rsComponent.driver.Drivers;
import com.rsComponent.helper.PageGeneratorHelper;
import com.rsComponent.pages.Page;
import com.rsComponent.pages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.support.FindBy;

public class rsStepdefs {

    private WebDriver driver;
    private SearchPage searchPage = null;

    private final static String rsComponentUrl = "http://uk.rs-online.com";

    public rsStepdefs() throws Throwable {
    }


    @Given("^I navigate to rscomponents homepage$")
    public void iNavigateToRscomponentsHomepage() throws Throwable {
        driver = Drivers.getChormeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(rsComponentUrl);
        searchPage = new SearchPage(driver);
    }

    @When("^I select \"([^\"]*)\" from All products$")
    public void iSelectFromAllProducts(String arg0) throws Throwable {
        Page homePage = PageGeneratorHelper.getPage("HomePage", driver);
        homePage.getCategoryList().stream().filter(e -> e.getName().equalsIgnoreCase("All Products")).findFirst().get().getElement().click();
        driver.findElement(By.partialLinkText(arg0)).click();
    }

    @And("^I select subcategory1 \"([^\"]*)\"$")
    public void iSelectSubCategory(String arg0) throws Throwable {
        PageGeneratorHelper.getPage(arg0, driver).getCategoryList().stream().filter(e -> e.getName().equalsIgnoreCase(arg0)).findFirst().get().getElement().click();
    }

    @And("^I select subcategory2 \"([^\"]*)\"$")
    public void iSelectSubCategory2(String arg0) throws Throwable {
        PageGeneratorHelper.getPage(arg0, driver).getCategoryList().stream().filter(e -> e.getName().equalsIgnoreCase(arg0)).findFirst().get().getElement().click();
    }

    @And("^I click on item \"([^\"]*)\"$")
    public void iClickOnProduct(String arg0) throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText(arg0)).click();

    }

    @And("^Add item to basket$")
    public void Add_item_to_basket() throws Throwable {
        driver.findElement(By.className("cartButton")).click();
        String basketvalue = driver.findElement(By.id("js-basketQty")).getText();
        String basketIntailValue = "0";
        Assert.assertEquals(basketvalue, basketIntailValue);

    }

    @Then("^Check out the item$")
    public void check_out_the_item() throws Throwable {
        driver.findElement(By.id("js-basketQty")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("checkoutSecurelyAndPuchBtn")).click();
        driver.close();
    }

    @When("I select \"([^\"]*)\" from Our Brands$")
    public void iSelectFromOurBrand(String brand) throws Exception {
        Page homePage = PageGeneratorHelper.getPage("HomePage", driver);
        homePage.getCategoryList().stream().filter(e -> e.getName().equalsIgnoreCase("Our Brands")).findFirst().get().getElement().click();
        if("abb".equals(brand)){
            driver.findElement(By.cssSelector(".sprite.sprite-brand-0")).click();
        }
    }

    @And("I select category \"([^\"]*)\"$")
    public void iSelectCategoryOnOurBrands(String category) throws Exception  {
       WebElement element = PageGeneratorHelper.getPage(category, driver).getCategoryList().stream().filter(e -> e.getName().equalsIgnoreCase(category)).findFirst().get().getElement();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(734, 1094)");
        element.click();
    }

    @When("^I enter \"(.*?)\"$")
    public void i_enter(String rspartno) throws Throwable {
        searchPage.enterTextinsearch(rspartno);
    }


    @When("^search for results$")
    public void search_for_Rspartno() throws Throwable {
        searchPage.clickSearch();

    }

    @Then("^Check Results for \"(.*?)\"$")
    public void check_Results(String rspartno) throws Throwable {
        searchPage.checkResultsForRspartno(rspartno);
        driver.close();
    }

    @Then("^Check Results search results found$")
    public void check_Results_search_results_found() throws Throwable {
        searchPage.checkSearchResultsFound();
        driver.close();

    }
    @Then("^Check Results for no search results found$")
    public void check_Results_for_no_search_results_found() throws Throwable {
        searchPage.checkSearchResultsNotFound();
        driver.close();

    }

}
