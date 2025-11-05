package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static step_definitions.Hooks.driver;

public class Helpers {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void scrollToElement(WebElement element) {

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollDown(){
        js.executeScript("window.scrollBy(0, 500)");
    }


}
