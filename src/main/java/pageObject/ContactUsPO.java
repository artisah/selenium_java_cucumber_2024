package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.GlobalVars;

public class ContactUsPO extends Base_PO {

    private @FindBy(how = How.XPATH, using = "//input[@name='first_name']")
    WebElement firstNameTextField;

    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastNameTextField;

    private @FindBy(xpath = "//input[@name='email']")
    WebElement emailAddressTextField;

    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement commentTextField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submitButton;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement successfulSubmissionMessageText;

    public ContactUsPO() {
        super();
    }

    public void navigateToContactUsPageUrl() {
        navigateToUrl(GlobalVars.BASE_URL + "/Contact-Us/contactus.html");
    }

    public void setUniqueFirstName() {
        typeTextTextbox(firstNameTextField, "AutoFN" + generateRandomNumber(5));
    }

    public void setUniqueLastName() {
        typeTextTextbox(lastNameTextField, "AutoLN" + generateRandomNumber(5));
    }

    public void setUniqueEmailAddress() {
        typeTextTextbox(emailAddressTextField, "AutoEmail" + generateRandomNumber(10) + "@mail.com");
    }

    public void setUniqueComment() {
        typeTextTextbox(commentTextField, "Hello world " + generateRandomString(20));
    }

    public void setSpecificFirstName(String firstName) {
        typeTextTextbox(firstNameTextField, firstName);
    }

    public void setSpecificLastName(String lastName) {
        typeTextTextbox(lastNameTextField, lastName);
    }

    public void setSpecificEmailAddress(String emailAddress) {
        typeTextTextbox(emailAddressTextField, emailAddress);
    }

    public void setSpecificComment(String comment) {
        typeTextTextbox(commentTextField, comment);
    }

    public void clickOnSubmitButton() {
        waitForWebElementAndClick(submitButton);
    }

    public void validateSuccessfulSubmissionMessageText() {
        waitForElement(successfulSubmissionMessageText);
        Assert.assertEquals(successfulSubmissionMessageText.getText(), "Thank You for your Message!");
    }


}
