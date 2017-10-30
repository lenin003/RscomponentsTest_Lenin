package com.rsComponent.helper;

import com.rsComponent.custom.Category;
import com.rsComponent.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageGeneratorHelper {

    private static Page getBatteriesPage(WebDriver driver) {

        Page batteriesPage = new Page();
        batteriesPage.getCategoryList().add(new Category("Battery Chargers & Battery Accessories", driver.findElement(By.partialLinkText("Battery Chargers & Battery Accessories"))));
        batteriesPage.getCategoryList().add(new Category("Non-Rechargeable Batteries", driver.findElement(By.partialLinkText("Non-Rechargeable Batteries"))));
        batteriesPage.getCategoryList().add(new Category("Rechargeable Batteries", driver.findElement(By.partialLinkText("Rechargeable Batteries"))));
        batteriesPage.getCategoryList().add(new Category("Automotive Battery Maintenance", driver.findElement(By.partialLinkText("Automotive Battery Maintenance"))));

        return batteriesPage;
    }

    private static Page getNonRechargeableBatteriesPage(WebDriver driver) {
        Page nonRechargeable = new Page();
        nonRechargeable.getCategoryList().add(new Category("9 Volt Batteries", driver.findElement(By.partialLinkText("9 Volt Batteries"))));

        return nonRechargeable;
    }

    private static Page getHomePage(WebDriver driver) {
        Page homePage = new Page();
        homePage.getCategoryList().add(new Category("All Products", driver.findElement(By.cssSelector(".menu.product-menu"))));
        homePage.getCategoryList().add(new Category("Our Brands", driver.findElement(By.cssSelector(".menu.brands-menu"))));

        return homePage;
    }

    private static Page getBrandsCategoryPage(WebDriver driver) throws Exception {

        Page brandsCategoryPage = new Page();
        brandsCategoryPage.getCategoryList().add(new Category("busbar",  driver.findElement(By.xpath("//a[@href='http://uk.rs-online.com/web/c/automation-control-gear/circuit-protection-circuit-breakers/busbars/?applied-dimensions=4294967273']"))));
        brandsCategoryPage.getCategoryList().add(new Category("blanking-plates", driver.findElement(By.xpath("//a[@href='http://uk.rs-online.com/web/c/automation-control-gear/circuit-protection-circuit-breakers/blanking-plates/?applied-dimensions=4294967273']"))));

        return brandsCategoryPage;
    }


    public static Page getPage(String pageName, WebDriver driver) throws Exception {
        switch (pageName) {
            case "HomePage":
                return getHomePage(driver);
            case "Rechargeable Batteries":
                return getBatteriesPage(driver);
            case "9 Volt Batteries":
                return getNonRechargeableBatteriesPage(driver);
            case "busbar":
                return getBrandsCategoryPage(driver);
            default:
                return null;
        }
    }


}
