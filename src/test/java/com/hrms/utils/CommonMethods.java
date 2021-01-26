package com.hrms.utils;

import com.hrms.testBase.PageInitilizer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitilizer {

    /**
     * this method will clear a textbox and send text to it
     * @param element
     * @param textToSend
     */
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     * this method will return an object of Explicit wait with time set to 20 sec
     * @return WebDriverWait
     */
    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * this method will wait until given element becomes clickable
     * @param element
     */
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * this method will wait till and then click
     */
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    /**
     * this method will return an Object of JavascriptExecutor
     * @return JavascriptExecutor
     */
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        return js;
    }

    /**
     * this method will click using JavascriptExecutor
     * @param element
     */
    public static void jsClick(WebElement element){

        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    /**
     *
     * @param fileName
     * @return
     */
    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts=(TakesScreenshot)driver;
        byte[] picture = ts.getScreenshotAs(OutputType.BYTES);
        //the above command will give me an array of bytes



        //these lines are necessary only if we want to store pics in a different folder. cucumber does not work with files like the one below
        //start:
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        //:end
        return picture;
    }

    /**
     *
     * @param pattern
     * @return
     */
    public static String getTimeStamp(String pattern){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void selectFromDropDown(WebElement element, String visibleText){
        Select select= new Select(element);
        List<WebElement> selectOptions= select.getOptions();

        boolean isFound= false;

        for (WebElement option: selectOptions ) {
           if(option.getText().equals(visibleText)){
               select.selectByVisibleText(visibleText);
                isFound=true;
                break;
           }
           if(!isFound){
               System.out.println("Value "+ visibleText + "is not found in the dropdown");
           }

        }
    }

    public static void clickRadio(List<WebElement> options, String selection){
        boolean isSelectionPresent=false;

        for (WebElement element: options) {
                    if(element.getText().equals(selection)){
                        element.click();
                        isSelectionPresent=true;
                        break;
                    }
                    if(!isSelectionPresent){
                        System.out.println("The radio option you entered is not present");
                    }
        }
    }

}
