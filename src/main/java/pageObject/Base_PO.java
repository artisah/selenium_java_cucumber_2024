package pageObject;

import driver.Driverfactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.GlobalVars;

import java.time.Duration;

public class Base_PO {

    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver(){
        return Driverfactory.getDriver();
    }

    public void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public String generateRandomNumber(int randomLength){
        return RandomStringUtils.randomNumeric(randomLength);
    }
    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void typeTextTextbox(By by,String textToType ){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void waitForAlertAndVerifyText(String expectedText) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessageText = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessageText,expectedText );
    }

    public void typeTextTextbox(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}
