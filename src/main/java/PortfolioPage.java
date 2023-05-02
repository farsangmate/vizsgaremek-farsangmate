import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class PortfolioPage extends BasePage {
    public PortfolioPage(WebDriver driver) {
        super(driver);
    }

    private final By ITEMS = By.xpath("//*[@class=\"site-project-item-content\"]");
    private final By BUTTON_NEXT = By.xpath("//*[@aria-label=\"Next\"]");

    public void navigateToPortfolioPage() {
        driver.findElement(BUTTON_PORTFOLIO).click();
    }


    public String[] getItemNames() {
        List<String> itemsName = new ArrayList<String>();
        while (true) {
            List<WebElement> elements = driver.findElements(ITEMS);
            for (WebElement items : elements) {
                WebElement element = items.findElement(By.xpath(".//h3"));
                itemsName.add(element.getText());
            }
            try {
                driver.findElement(BUTTON_NEXT).click();
            } catch (ElementNotInteractableException e) {
                break;
            }
        }
        return itemsName.toArray(new String[0]);
    }


}
