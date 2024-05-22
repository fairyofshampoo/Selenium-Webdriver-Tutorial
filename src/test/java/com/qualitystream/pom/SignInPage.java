package com.qualitystream.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base{


    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By signInBtnLocator = By.name("submit");

    By homePageLocator = By.xpath("//h3[text()='Login Successfully']");

    By passwordFailedLocator = By.xpath("//*[contains(text(), 'Enter your userName and password correct')]");
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(){
        if(isDisplayed(userLocator)){
            type(("lincesAdmin"), userLocator);
            type("password", passLocator);
            click(signInBtnLocator);
        } else {
            System.out.println("username textbox was not present");
        }
    }

    public void signInPasswordWrong(){
        if(isDisplayed(userLocator)){
            type(("lincesAdmin"), userLocator);
            type("password1234", passLocator);
            click(signInBtnLocator);
        } else {
            System.out.println("username textbox was not present");
        }
    }

    public void signInUsernameWrong(){
        if(isDisplayed(userLocator)){
            type(("lincesMiau12"), userLocator);
            type("password", passLocator);
            click(signInBtnLocator);
        } else {
            System.out.println("username textbox was not present");
        }
    }

    public void signInWrongUserAndPassword(){
        if(isDisplayed(userLocator)){
            type(("lincesMiau12"), userLocator);
            type("password123", passLocator);
            click(signInBtnLocator);
        } else {
            System.out.println("username textbox was not present");
        }
    }

    public boolean isPasswordFailedDisplayed(){
        return isDisplayed(passwordFailedLocator);
    }

    public boolean isHomePageDisplayed(){
        return isDisplayed(homePageLocator);
    }
}
