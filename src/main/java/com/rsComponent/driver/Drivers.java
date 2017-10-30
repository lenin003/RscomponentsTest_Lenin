package com.rsComponent.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Drivers {

    public static WebDriver getChormeDriver() throws Throwable {
        WebDriver driver;

        File file = new File("src/main/java/com/rsComponent/driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();

        return driver;
    }


}
