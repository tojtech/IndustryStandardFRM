package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.example.helpers.ElementsInteraction.getWait;
import static com.example.CucumberHooks.getDriver;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class DoctorsPage extends BasePage{
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Doctors"));
    }

    /// TODO: add locators and data once feature implemented
    private WebElement getDoctorFirstNameFieldElement() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.cssSelector(""));
    }

    @When("User types first name of the Doctor")
    public void typeDoctorFirstName() throws InterruptedException {
        getDoctorFirstNameFieldElement().sendKeys("");
        Thread.sleep(2000);
    }

    @Then("^User should see first name field$")
    public void verifyFirstNameFieldIsVisible() throws InterruptedException {
        Assert.assertTrue(getDoctorFirstNameFieldElement().isDisplayed());
    }


}
