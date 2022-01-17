package com.example.pageObjects;

import com.example.BasePage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.internal.http2.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.example.helpers.ElementsInteraction.getWait;
import static com.example.CucumberHooks.getDriver;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class CustomersPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Customers"));
    }


    @And("API request to Mediyor!")
    public void createAPIRequest() throws IOException, InterruptedException {

        // REMINDER: Data (email, first, last name) should be unique each time!!!
        String data = "{\n" +
                "\t\"firstName\":\"My_name_test\",\n" +
                "\t\"lastName\":\"My_last_test\",\n" +
                "\t\"email\":\"test_newsdsyy1@test.com\",\n" +
                "\t\"plainPassword\":\"testsd_new1\",\n" +
                "\t\"type\":\"doctor\"\n" +
                "\t\n" +
                "}";

        String urlEndpoint = "https://mediyor.com/api/users";

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlEndpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();

        HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.println(response.statusCode());

        Assert.assertEquals(response.statusCode(), 201);
    }

    public void connectToDB(){

    }
}