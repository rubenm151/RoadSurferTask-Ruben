package automationFramework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {

    protected WebDriver driver;
    private final WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    private boolean waitFor(ExpectedCondition<WebElement> condition) {
        try {
            wait.until(condition);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void waitForElementToBeClickable(WebElement element) {
        waitFor(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element) {
        waitForElementToBeClickable(element);
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(element).click().perform();
        } catch (WebDriverException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    protected boolean waitForVisibilityOfElement(WebElement element) {
        return waitFor(ExpectedConditions.visibilityOf(element));
    }
}