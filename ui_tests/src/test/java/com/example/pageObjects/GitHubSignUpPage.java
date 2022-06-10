package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.example.helpers.ElementsInteraction.getWait;

public class GitHubSignUpPage extends BasePage {

    /**
     * Checks if page opened
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    @Then("^I should see SignUp page widget$")
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleIs("Join GitHub · GitHub"));
    }
}
