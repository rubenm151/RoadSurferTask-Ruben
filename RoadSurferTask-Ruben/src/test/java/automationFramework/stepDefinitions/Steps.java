package automationFramework.stepDefinitions;

import automationFramework.TestContext;
import automationFramework.pages.RentPage;
import automationFramework.helper.WebDriverManagement;
import automationFramework.pages.SelectCamperPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Steps {

    public static class StepDefinitions {

        private final TestContext testContext;
        private final RentPage bookingPage;
        private final SelectCamperPage selectCamperPage;
        private WebDriver driver;
        private static final Logger logger = LogManager.getLogger(StepDefinitions.class);

        public StepDefinitions(WebDriverManagement driverManagement) {
            this.testContext = new TestContext(driverManagement);
            this.bookingPage = new RentPage(testContext);
            this.selectCamperPage = new SelectCamperPage(testContext);
            this.driver = driverManagement.getDriver();
        }

        public void openRoadSurfer() {
            logger.info("🔹 Opening RoadSurfer...");
            bookingPage.openPage();
        }

        public void acceptCookies() {
            logger.info("🔹 Accepting cookies...");
            bookingPage.acceptCookiesFromShadowDOM();
        }

        public void clickLocation() {
            logger.info("🔹 Entering location...");
            bookingPage.clickLocation();
        }

        public void selectDates() {
            logger.info("🔹 Selecting dates...");
            bookingPage.selectDate();
        }

        public void searchForCamper() {
            logger.info("🔹 Searching for campers...");
            bookingPage.clickFindCamper();
        }

        public void seeResults() {
            selectCamperPage.seeResults();
        }

        public void verifyAtLeastTwoDifferentModels() {
            selectCamperPage.verifyAtLeastTwoDifferentModels();
        }

        public void closeDriver() {
            if (driver != null) {
                driver.close();
                driver.quit();
                logger.info("🔹 WebDriver closed successfully.");
            }
        }
    }
}
