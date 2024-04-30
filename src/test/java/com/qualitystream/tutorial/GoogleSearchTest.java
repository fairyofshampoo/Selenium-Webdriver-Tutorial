package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {
	
	private WebDriver driver;
	By videoLinkLocator = By.cssSelector("a[href='https://youtube.com/watch?v=R_hh3jAqn8M']");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@Test
	public void testGooglePage() {
		
	    WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
		searchBox.submit();

		//Descomentar el tipo de espera que se quiera ocupar tomando en cuenta que solo se puede uno a la vez.

		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Explicit wait
		/*WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.titleContains("quality-stream"));*/

		//Fluent Wait
		/*Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement video = fwait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(videoLinkLocator);
			}

		});*/
		assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google",driver.getTitle());
	}

	//Explicación de localizadores
	/*@Test
	public void localizadores() {
		 
		By locator = By.id("id_del_elemento");
		
		By locator_name = By.name("name_elemnt");
		
		By locator_className = By.className("clase_elemento");
		
		By locator_tagName = By.tagName("tag");
		
		By locator_linktext = By.linkText("texto_link");
		
		By locator_partialLinkText = By.partialLinkText("parte_texto");
		
		By locator_cssSelector = By.cssSelector("input[name='q']");
		
		By locator_Xpath = By.xpath("//input[@name='q']");
		
		// JavaScript
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement searchBox = (WebElement)js.executeScript("return document.getElementsByName('q')[0]");
		
	}*/
	
	@After
	public void tearDown() {
		//driver.quit();
	}

}
