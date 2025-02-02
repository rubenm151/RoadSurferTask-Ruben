package automationFramework.pages;

import automationFramework.TestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectCamperPage extends GenericPage {

    @FindBy(xpath = "//div[@class='results']")
    public WebElement campersList;

    @FindBy(xpath = "//div[contains(@class, 'results')]//h3")
    public List<WebElement> campersModels;

    private static final Logger logger = LogManager.getLogger(SelectCamperPage.class);

    public SelectCamperPage(TestContext testContext) {
        super(testContext);
        currentClass = this.getClass();
    }

    public void seeResults() {
        boolean isVisible = isVisible("campersList");
        Assert.assertTrue("⚠️ No camper results were found.", isVisible);
        logger.info("✅ Camper list is visible.");
    }

    public void verifyAtLeastTwoDifferentModels() {
        Set<String> uniqueModels = new HashSet<>();

        for (WebElement camper : campersModels) {
            uniqueModels.add(camper.getText().trim());
        }
        Assert.assertTrue("⚠️ There are not at least two different camper models.", uniqueModels.size() >= 2);
        logger.info("✅ At least two different camper models were found.");
    }
} 