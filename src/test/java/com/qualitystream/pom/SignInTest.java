package com.qualitystream.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SignInTest {
    private WebDriver driver;
    SignInPage signInPage;
    @Before
    public void setUp() throws Exception {
        signInPage = new SignInPage(driver);
        driver = signInPage.chromeDriverConnection();
        signInPage.visit("https://demo.guru99.com/test/newtours/");

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void testSignIn() throws InterruptedException {
        signInPage.signIn();
        Thread.sleep(2000);
        assertTrue(signInPage.isHomePageDisplayed());
    }
    @Test
    public void testSignInUsernameWrong() throws InterruptedException {
        signInPage.signInUsernameWrong();
        Thread.sleep(2000);
        assertTrue(signInPage.isPasswordFailedDisplayed());
    }

    @Test
    public void testSignInPasswordWrong() throws InterruptedException {
        signInPage.signInPasswordWrong();
        Thread.sleep(2000);
        assertTrue(signInPage.isPasswordFailedDisplayed());
    }

    @Test
    public void testSignInWrong() throws InterruptedException {
        signInPage.signInWrongUserAndPassword();
        Thread.sleep(2000);
        assertTrue(signInPage.isPasswordFailedDisplayed());
    }
}
