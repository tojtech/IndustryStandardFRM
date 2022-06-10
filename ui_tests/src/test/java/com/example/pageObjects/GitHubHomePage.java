package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

public class GitHubHomePage extends BasePage {

    // LOCATORS
    private static final String MAIN_PAGE_TITLE_LOCATOR = "//h1";
    private static final String EMAIL_TEXTFIELD_LOCATOR = "input.form-control.border-0";
    public static final String GREEN_BUTTON_LOCATOR = "//button[@class='btn-mktg width-full width-sm-auto btn-signup-mktg']";

    // TEST DATA
    private static final String MAIN_PAGE_TITLE_EXPECTED_TEXT = "Where the world builds software";
    private static final String EMAIL_TO_SIGN_UP = "test@test.test";

    /**
     * Checks if page opened
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    @Override
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleIs("GitHub: Where the world builds software · GitHub"));
    }

    private static WebElement getMainPageTitleElement(){
        return getDriver().findElement(By.xpath(MAIN_PAGE_TITLE_LOCATOR));
    }

    @And("^I should see Home Page Title displayed$")
    public static void isTextVisible(){
        Assert.assertTrue(getMainPageTitleElement().isDisplayed());
    }

    public static String getTitleText(){
        return getMainPageTitleElement().getText();
    }

    @And("^Home Page Title should contain text 'Where the world builds software'$")
    public static void isTitleTextEqualsToExpected(){
        Assert.assertEquals(MAIN_PAGE_TITLE_EXPECTED_TEXT, getTitleText());
    }

    private static WebElement getEmailTextField(){
        return getDriver().findElement(By.cssSelector(EMAIL_TEXTFIELD_LOCATOR));
    }

    private static WebElement getGreenButtonElement(){
        return getDriver().findElement(By.xpath(GREEN_BUTTON_LOCATOR));
    }

    @When("^I type \"([^\"]*)\" to Email address field$")
    public void typeEmail(String email){
        getEmailTextField().sendKeys(EMAIL_TO_SIGN_UP);
    }

    @And("^I see Green button is displayed$")
    public void isGreenButtonVisible(){
        Assert.assertTrue(getGreenButtonElement().isDisplayed());
    }

    @And("click the Green button")
    public static void clickGreenButton(){
        getGreenButtonElement().click();
    }


}
