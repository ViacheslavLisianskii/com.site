package com.semrush.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by fier on 4/3/2016.
 */
public class SiteAuditSettingsPage extends Page {

    private final String LIMIT_TYPE_SELECT_NAME = "limitType";
    private final String PAGE_LIMIT_SELECT_NAME = "pageLimit";
    private final String START_AUDIT_BUTTON_XPATH = "//button[@type='button' and contains(@class, 'btn')]";
    private final String MASKS_BUTTON_XPATH = "//div[@data-step='masks']";
    private final String DISALLOW_TEXTAREA_NAME = "disallow";
    private final String PARAMETERS_BUTTON_XPATH = "//div[@data-step='parameters']";
    private final String PARAMETERS_TEXTAREA_NAME = "removedParameters";

    @FindBy(name = PAGE_LIMIT_SELECT_NAME)
    private WebElement limitOfCheckedPagesInput;
    @FindBy(xpath = START_AUDIT_BUTTON_XPATH)
    private WebElement startSiteAudit;
    @FindBy(name = LIMIT_TYPE_SELECT_NAME)
    private WebElement limitTypeSelect;
    @FindBy(xpath = MASKS_BUTTON_XPATH)
    private WebElement masksWizardButton;
    @FindBy(name = DISALLOW_TEXTAREA_NAME)
    private WebElement disallowTextarea;
    @FindBy(xpath = PARAMETERS_BUTTON_XPATH)
    private WebElement parametersWizardButton;
    @FindBy(name = PARAMETERS_TEXTAREA_NAME)
    private WebElement parametersTextarea;

    public SiteAuditSettingsPage(PageManager pages) {
        super(pages);
    }

    public SiteAuditSettingsPage selectLimitType(String limitType){
        Select dropDown = new Select(limitTypeSelect);
        dropDown.selectByValue(limitType);

        return this;
    }

    public SiteAuditSettingsPage setPageLimit(String limit){
        limitOfCheckedPagesInput.clear();
        limitOfCheckedPagesInput.sendKeys(limit);

        return this;
    }

    public SiteAuditSettingsPage chooseMasksWizard(){
        masksWizardButton.click();

        return this;
    }

    public SiteAuditSettingsPage setDisallow(String urls) {
        disallowTextarea.click();
        disallowTextarea.sendKeys(urls);

        return this;
    }

    public SiteAuditSettingsPage chooseParametersWizard(){
        parametersWizardButton.click();

        return this;
    }

    public SiteAuditSettingsPage setRemoveParameters(String urls) {
        parametersTextarea.click();
        parametersTextarea.sendKeys(urls);

        return this;
    }

    public void startSiteAudit() {
        startSiteAudit.click();
    }
}
