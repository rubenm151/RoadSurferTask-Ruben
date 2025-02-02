package automationFramework.helper;

import org.openqa.selenium.WebDriver;

public class WebDriverManagement {

    private final String browser;
    private WebDriver driver;

    public WebDriverManagement(String browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver() {
        driver = new WebDriverFactory().createDriver(browser);
        return driver;
    }

}
