package tests;

import automationFramework.TestContext;
import automationFramework.helper.WebDriverManagement;
import automationFramework.stepDefinitions.Steps;
import org.junit.Before;
import org.junit.Test;

public class RoadSurferTest {

    private Steps.StepDefinitions steps;

    @Before
    public void setUp() {
        WebDriverManagement driverManager = new WebDriverManagement("chrome");
        TestContext testContext = new TestContext(driverManager);
        steps = new Steps.StepDefinitions(driverManager);
    }

    @Test
    public void testRoadSurferBooking() {
        steps.openRoadSurfer();
        steps.acceptCookies();
        steps.clickLocation();
        steps.selectDates();
        steps.searchForCamper();
        steps.seeResults();
        steps.verifyAtLeastTwoDifferentModels();
        steps.closeDriver();
    }
}