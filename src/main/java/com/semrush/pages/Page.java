package com.semrush.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by fier on 4/2/2016.
 */
public abstract class Page {

	private final int ELEMENT_TIMEOUT = 10;
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected PageManager pages;

	public Page(PageManager pages) {
		this.pages = pages;
		driver = pages.getWebDriver();
		wait = new WebDriverWait(driver, ELEMENT_TIMEOUT);
	}

	public Page ensurePageLoaded() {
		return this;
	}

	public WebElement getWebElement(By by){
		return driver.findElement(by);
	}
}
