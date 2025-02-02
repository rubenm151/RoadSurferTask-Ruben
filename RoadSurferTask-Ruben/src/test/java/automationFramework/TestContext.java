package automationFramework;

import automationFramework.helper.WebDriverManagement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class TestContext {

    @Getter
    private WebDriverManagement driverManager;

    public TestContext(WebDriverManagement driverManager) {
        this.driverManager = driverManager;
    }

    public WebDriver getDriver() {
        return driverManager.getDriver();
    }
}
