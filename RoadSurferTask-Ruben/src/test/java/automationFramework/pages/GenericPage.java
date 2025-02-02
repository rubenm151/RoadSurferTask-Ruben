package automationFramework.pages;

import automationFramework.TestContext;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class GenericPage extends AbstractPage {

    protected TestContext testContext;
    protected Class<?> currentClass;
    protected final String URL = "https://booking.roadsurfer.com/en/rent";

    public GenericPage(TestContext testContext) {
        super(testContext.getDriver());
        this.testContext = testContext;
        this.currentClass = this.getClass();
    }

    private WebElement getWebElement(String propertyName) {
        List<Field> fields = Arrays.asList(currentClass.getDeclaredFields());
        return fields.stream()
                .filter(field -> field.getType().equals(WebElement.class) &&
                        field.getName().equalsIgnoreCase(propertyName))
                .findFirst()
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        return (WebElement) field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Could not acces the field: " + propertyName, e);
                    }
                })
                .orElseThrow(() -> new RuntimeException("Element not found: " + propertyName));
    }

    public void clickOn(String itemName) {
        click(getWebElement(itemName));
    }

    public boolean isVisible(String itemName) {
        try {
            WebElement webElement = getWebElement(itemName);
            return waitForVisibilityOfElement(webElement);
        } catch (Exception e) {
            return false;
        }
    }
}