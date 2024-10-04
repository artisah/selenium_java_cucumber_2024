package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.ContactUsPO;

public class ContactUsSteps extends Base_PO {
    private ContactUsPO contactUsPo; // dependency Injection: used to use pageoobject methods in Step defination class
    public ContactUsSteps(ContactUsPO contactUsPo) { // dependency Injection
        this.contactUsPo = contactUsPo;  // dependency Injection
    }

    private WebDriver driver = getDriver();

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        contactUsPo.navigateToContactUsPageUrl();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contactUsPo.setUniqueFirstName();
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        contactUsPo.setUniqueLastName();
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contactUsPo.setUniqueEmailAddress();
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contactUsPo.setUniqueComment();
    }


    @And("I click on submit button")
    public void i_click_on_submit_button() {
        contactUsPo.clickOnSubmitButton();
    }

    @Then("I should be present with successfully contact us submission message")
    public void i_should_be_present_with_successfully_contact_us_submission_message() {
        WebElement Message = driver.findElement(By.cssSelector("div#contact_reply > h1"));
        Assert.assertEquals(Message.getText(), "Thank You for your Message!");
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name_priya(String fName) {
        contactUsPo.setSpecificFirstName(fName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name_sanghi(String lName) {
        contactUsPo.setSpecificLastName(lName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address_test_aaa_com(String email) {
        contactUsPo.setSpecificEmailAddress(email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contactUsPo.setSpecificComment(comment);
    }





}
