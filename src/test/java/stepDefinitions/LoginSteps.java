package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Base_PO;
import pageObject.LoginPO;

public class LoginSteps extends Base_PO {

    private LoginPO loginPo; // dependency Injection: used to use pageoobject methods in Step defination class
    public LoginSteps(LoginPO loginPo) { // dependency Injection
        this.loginPo = loginPo;  // dependency Injection
    }

    @Given("I access the webdriver university Login page")
    public void i_access_the_webdriver_university_login_page() {
        loginPo.navigateToLoginPageUrl();
    }
    @When("I enter username {word}")
    public void i_enter_username(String userName) {
        loginPo.setUsername(userName);
    }
    @And("I enter password {}")
    public void i_enter_password(String password) {
        loginPo.setPassword(password);
    }
    @And("I click on Login button")
    public void i_click_on_login_button() {
        loginPo.clickOnLoginButton();
    }

    @Then("I should be present with {} Login message")
    public void i_should_be_present_with_login_message(String validationMessage) {
        loginPo.validatelLoginMessage(validationMessage);
    }

}
