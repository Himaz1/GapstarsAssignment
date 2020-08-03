package com.gapstar.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gapstar.base.TestBase;

public class LandingPage extends TestBase{
	
	@FindBy (xpath="//span[@class='icon-hamburger-animated']")
	WebElement ele_leftMenu;
	
	@FindBy(xpath = "//a[@class='icon-user' and @href='/signin/?signin_redirect=/last/']")
	WebElement lnk_signIn;
	
	@FindBy(xpath = "//a[@class='icon-off']")
	WebElement lnk_signOut;
	
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getLandingPageTitle()
	{
		return driver.getTitle();
	}
	
		
	public void clickLeftMenuIcon()
	{
		ele_leftMenu.click();
	}
	
	public void clickSignInLink()
	{
		lnk_signIn.click();
	}
	
	public void handleWindowDuringRegistration() throws Exception
	{
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("Parent window id is:" + parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Parent window id is:" + childWindowId);
		
		driver.switchTo().window(childWindowId);
		System.out.println("Child window pop up title is :" + driver.getTitle());
		
		Thread.sleep(2000);
		
		WebElement lnk_email = driver.findElement(By.xpath("//a[@class='btn btn-link' and contains(text(),'or use email')]"));
		lnk_email.click();
		
		Thread.sleep(2000);
		
		WebElement tf_email = driver.findElement(By.xpath("//input[@name='email']"));
		tf_email.sendKeys("senasithum@gmail.com");
		
		Thread.sleep(2000);		
		WebElement ele_emailClickIcon = driver.findElement(By.xpath("//button[@class='btn btn-xl btn-success']"));
		ele_emailClickIcon.click();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window pop up title is :" + driver.getTitle());
		
		Thread.sleep(4000);		
		WebElement tf_title = driver.findElement(By.xpath("//input[@name='title']"));
		tf_title.sendKeys("TestHimazPastBook");
		
		Thread.sleep(1000);		
		WebElement btn_createPastBook = driver.findElement(By.xpath("//button[@id='create-button']"));
		btn_createPastBook.click();
		
		Thread.sleep(4000);
		WebElement btn_uploadPic = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary' and contains(text(),'Upload your pictures')]"));
		btn_uploadPic.click();
		
		Thread.sleep(3000);
		WebElement btn_fileUpload = driver.findElement(By.xpath("//div['fsp-select-labels' and contains(text(), 'Select Files to Upload')]"));
		btn_fileUpload.click();
		
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\it17145930\\GapstarWorkspace\\AutoItScript\\imageUpload.exe");
		
		Thread.sleep(8000);
		WebElement btn_upload = driver.findElement(By.xpath("//span[@title='Upload']"));
		btn_upload.click();
		
		Thread.sleep(6000);
		WebElement btn_continue = driver.findElement(By.xpath("//button[@type='button' and @data-bb-handler='addExp']/b[contains(text(),'Continue')]"));
		btn_continue.click();
		
		Thread.sleep(5000);
	}
	
	public void handleWindowDuringLogIn() throws Exception
	{
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("Parent window id is:" + parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Parent window id is:" + childWindowId);
		
		driver.switchTo().window(childWindowId);
		System.out.println("Child window pop up title is :" + driver.getTitle());
		
		Thread.sleep(2000);
		
		WebElement lnk_email = driver.findElement(By.xpath("//a[@class='btn btn-link' and contains(text(),'or use email')]"));
		lnk_email.click();
		
		Thread.sleep(2000);
		
		WebElement tf_email = driver.findElement(By.xpath("//input[@name='email']"));
		tf_email.sendKeys("psandun641@gmail.com");
		
		Thread.sleep(2000);		
		WebElement ele_emailClickIcon = driver.findElement(By.xpath("//button[@class='btn btn-xl btn-success']"));
		ele_emailClickIcon.click();
		
		Thread.sleep(2000);	
		WebElement tf_password = driver.findElement(By.xpath("//input[@name='password']"));
		tf_password.sendKeys("test1234");
		
		Thread.sleep(2000);		
		ele_emailClickIcon.click();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window pop up title is :" + driver.getTitle());
		
		Thread.sleep(3000);		
		
	}
	
	public void clickSignOutLink()
	{
		lnk_signOut.click();
	}
	
	public String getPageTitleFterLogIn()
	{
		return driver.getTitle();
	}
	
}
