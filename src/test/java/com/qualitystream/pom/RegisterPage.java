package com.qualitystream.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends  Base{
    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");

    By usernameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");

    By registerBtnLocator = By.name("submit");
    By registeredMessage = By.tagName("font");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser() throws InterruptedException{
        click(registerLinkLocator);
        Thread.sleep(2000);
        if(isDisplayed(registerPageLocator)) {
            type("lincesAdmin", usernameLocator);
            type("password", passwordLocator);
            type("password", confirmPasswordLocator);

            click(registerBtnLocator);
        }
        else {
            System.out.print("Register pages was not found");
        }
    }

    public String registerMessage(){
        List<WebElement> fonts = findElements(registeredMessage);
        return getText(fonts.get(5));
    }
}
