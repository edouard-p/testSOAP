package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewUserPage extends NavigationBar {

    @FindBy(how = How.XPATH, using = "//h2[@id='myUserLabel'][child::span[text()='Create or edit a user']]")
    public WebElement newUserTitle;

    @FindBy(how = How.XPATH, using = "//input[@type='text'][@name='login']")
    private WebElement loginInput;

    @FindBy(how = How.XPATH, using = "//input[@type='email'][@name='email']")
    private WebElement emailInput;

    @FindBy(how = How.XPATH, using = "//select[preceding-sibling::label[child::span[text()='Profiles']]]")
    private WebElement profileSelect;

    @FindBy(how = How.XPATH, using = "//button[@type='submit'][descendant::span[text()='Save']]")
    private WebElement saveButton;

    /* Create a new user with the sent information
    *  Args :
    *  - String username : login of the user
    *  - String email : email of the user
    *  Return :
    *  - UserManagementPage
    */
    public UserManagementPage createNewUser(WebDriver driver, String username, String email, String role){
        this.clearAndFillInput(loginInput, username);
        this.clearAndFillInput(emailInput, email);
        Select select = new Select(profileSelect);
        select.selectByVisibleText(role);
        saveButton.click();
        return PageFactory.initElements(driver, UserManagementPage.class);
    }
}
