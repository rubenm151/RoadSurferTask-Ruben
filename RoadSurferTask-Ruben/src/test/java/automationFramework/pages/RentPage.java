package automationFramework.pages;

import automationFramework.TestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RentPage extends GenericPage {

    @FindBy(xpath = "//div[@class='search-inputs']/div")
    private WebElement locationInput;

    @FindBy(id = "modal-station-item-63-step-0")
    private WebElement londonLocation;

    @FindBy(xpath = "//div[@class='search-dates']/div[@class='search-input flex-1'][1]")
    private WebElement selectDate;

    @FindBy(xpath = "//div[@class='calendars-month'][2]/div/table/tbody/tr[2]/td[2]/div/div[@class='calendar__date']")
    private WebElement pickUpDate;

    @FindBy(xpath = "//div[@class='calendars-month'][3]/div/table/tbody/tr[2]/td[2]/div/div[@class='calendar__date']")
    private WebElement dropOffDate;

    @FindBy(xpath = "//div[@class='search-inputs']/button[@class='button button--v2 h-12']")
    private WebElement findCamperButton;

    @FindBy(xpath = "//*[@id='usercentrics-root']//button[@data-testid='uc-accept-all-button']")
    private WebElement acceptCookiesButton;

    private static final Logger logger = LogManager.getLogger(RentPage.class);

    public RentPage(TestContext testContext) {
        super(testContext);
        currentClass = this.getClass();
    }

    public void openPage() {
        driver.get(URL);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("Thread interrupted while waiting for page to load.", e);
        }
    }

    public void acceptCookiesFromShadowDOM() {
        WebElement shadowHost = driver.findElement(By.id("usercentrics-root"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].shadowRoot.querySelector('button[data-testid=\"uc-accept-all-button\"]').click();", shadowHost);
        logger.info("✅ Cookies accepted successfully.");
    }

    public void clickLocation() {
        clickOn("locationInput");
        clickOn("londonLocation");
        logger.info("📍 Location selected: London.");
    }

    public void selectDate() {
        logger.info("⌛ Selecting dates...");
        clickOn("selectDate");
        clickOn("pickUpDate");
        clickOn("dropOffDate");
        logger.info("✅ Dates selected successfully.");
    }

    public void clickFindCamper() {
        clickOn("findCamperButton");
        logger.info("🔍 Searching for campers...");
    }
}