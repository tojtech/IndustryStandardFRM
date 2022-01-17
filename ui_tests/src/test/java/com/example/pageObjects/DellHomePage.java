package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class DellHomePage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h3[text()='Explore Dell Technologies']")));
    }

    private WebElement getSearchBarElement(){
        return getDriver().findElement(By.xpath("//input[@ id='mh-search-input']"));
    }

    private WebElement getSearchButtonElement(){
        return getDriver().findElement(By.xpath("//button[@class='mh-search-btn mh-search-submit']"));
    }

    @And("^User clicks at the search bar$")
    public void clickSearchBar(){
        getSearchBarElement().click();
    }

    @And("^User types a search keyword \"([^\"]*)\" to the search bar$")
    public void sendKeysToSearchBar(String text){
        getSearchBarElement().sendKeys(text);
    }

    @When("^User clicks Search button$")
    public void clickSearchButton(){
        getSearchButtonElement().click();
    }


}
