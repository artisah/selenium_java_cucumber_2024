package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;

public class LoginPO extends Base_PO{

    // Using Page factory
    private @FindBy(id = "text")
    WebElement username_TextField;

    private @FindBy(id = "password")
    WebElement password_TextField;

    private @FindBy(id = "login-button")
    WebElement loginButton;


    public LoginPO() {
        super();
    }
    public void navigateToLoginPageUrl() {
        navigateToUrl(GlobalVars.BASE_URL + "/Login-Portal/index.html?");
    }

    public void setUsername(String username) {
        typeTextTextbox(username_TextField, username);
    }

    public void setPassword(String password) {
        typeTextTextbox(password_TextField, password);
    }

    public void clickOnLoginButton() {
        waitForWebElementAndClick(loginButton);
    }

    public void validatelLoginMessage(String TextToVerify) {
        waitForAlertAndVerifyText(TextToVerify);
    }
}
