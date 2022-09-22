package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import java.time.Duration;

public class ProfilePage {

	WebDriver driver;				// driverul se va instantia dupa ce voi crea obiectul si nu inainte
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private String bookName;
	
	// locators
	
	private By checkBookLabel = By.xpath("//div[@id=\"books-wrapper\"]/descendant:: label[contains(.,\"Books : \")]");
	private By checkUser = By.id("userName-value");
	private By checkUserNameLabel = By.xpath("//div[@id=\"books-wrapper\"]/descendant:: label[contains(.,\"User Name : \")]");
	private By checkLogOutButton = By.xpath("//div[@id=\"books-wrapper\"]/descendant:: button[contains(.,\"Log out\")]");
	private By searchBox = By.id("searchBox");
	private By clickSearch = By.id("basic-addon2");
	private By gotoStore = By.id("gotoStore");
	private By clickBook = By.id("see-book-You Don't Know JS");
	private By delButtonText = By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\"You Don't Know JS\")]//div[2]//a");
	private By delButtonClick = By.xpath("//div[@class=\"rt-tbody\"]/div/following-sibling::div/descendant::div/descendant::div/following-sibling::div/descendant::span/a[contains(.,\"You Don't Know JS\")]/ancestor::div[@class=\"rt-td\"]/following-sibling::div/descendant::span/*");
	private By modalHeaderText = By.xpath("//div[@class=\"modal-header\"]");
	private By modalBodyText = By.className("modal-body");
	private By modalFooterOk = By.id("closeSmallModal-ok");
	private By modalFooterCancel = By.id("closeSmallModal-cancel");
	private By modalCloseButton = By.className("close");
	private By profileLogOut = By.xpath("//button[@id=\"submit\"][contains(.,\"Log out\")]");
	String name = "Speaking JavaScript";
	//get line data 
	private By author = By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\""+name+"\")]/div/div[3]");
	private By publisher = By.xpath("//div[@class='rt-tbody']/div[contains(.,\""+name+"\")]/div/div[4]");
	private By picture = By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\""+name+"\")]/div/div[1]/img");


	
	// Actions
	
	public String checkBookLabel() {
		return driver.findElement(checkBookLabel).getText();
	}
	
	public String checkUser() {
		return driver.findElement(checkUser).getText();
	}
	
	public String checkUserNameLabel() {
		return driver.findElement(checkUserNameLabel).getText();
	}
	
	public String checkLogOutButton() {
		return driver.findElement(checkLogOutButton).getText();
	}
	
	public void checkBooksWrapper() {
		Assert.assertTrue(checkBookLabel().contains("Books :"));
		Assert.assertTrue(driver.findElement(searchBox).isDisplayed());
		Assert.assertTrue(driver.findElement(searchBox).isEnabled());
		Assert.assertTrue(checkUserNameLabel().contains("r Name :"));
		Assert.assertEquals("aura", checkUser());
		Assert.assertTrue(driver.findElement(checkLogOutButton).isDisplayed());
	}
	
	public void searchBox() {
		driver.findElement(searchBox).sendKeys("Java");
	}
	
	public void clickSearchBook() {
		driver.findElement(clickSearch).click();
	}
	
	public String bookInfosAuthor() {		
		return driver.findElement(author).getText();
	}
	
	public String bookInfosPublisher() {
		return driver.findElement(publisher).getText();	
	}
	
	public String bookInfosAttribute() {
		return driver.findElement(picture).getAttribute("src");			
	}
	
	public Boolean bookInfosDisplayed() {
		return driver.findElement(picture).isDisplayed();	
	}
	
	public String bookInfosLocation() {
//		return driver.findElement(picture).getLocation().getX() + " " + driver.findElement(picture).getLocation().getY();
		return driver.findElement(picture).getLocation().toString();
	}
	
	public String bookInfosColor() {		
		return driver.findElement(picture).getCssValue("color");
	}
	
	public String bookInfosPictSize() {		
		return driver.findElement(picture).getSize().toString();
	}
	
	public String bookInfosPictPosition() {		
		return driver.findElement(picture).getCssValue("position");
	}
	
	public String goToStore() {
		return driver.findElement(gotoStore).getText();
	}
	
	public Boolean goToStoreDisplayed() {
		return driver.findElement(gotoStore).isDisplayed();		
	}
	
	public void goToStoreClick() {
		driver.findElement(gotoStore).click();
	}
	
	public String clickBookText() {
		return driver.findElement(clickBook).getText();
	}
	
	public Boolean clickBookDisplayed() {		
		return driver.findElement(clickBook).isDisplayed();
	}
	
	public void clickBook() {
		driver.findElement(clickBook).click();
	}
		
	public String delButtonText() {
		return driver.findElement(delButtonText).getText();
	}
	
	public void delButtonClick() {
		driver.findElement(delButtonClick).click();
	}
	
	public String modalHeaderText() {
		return driver.findElement(modalHeaderText).getText();
	}
	
	public String modalBodyText() {
		return driver.findElement(modalBodyText).getText();
	}
	
	public String modalFooterTextOk() {	
		return driver.findElement(modalFooterOk).getText();
	}
	
	public Boolean modalFooterTextOkDisplayed() {	
		return driver.findElement(modalFooterOk).isDisplayed();
	}
	
	public void modalFooterTextCancel() {		
		System.out.println(driver.findElement(modalFooterOk).getText());
		System.out.println(driver.findElement(modalFooterCancel).getText());
		Assert.assertTrue(driver.findElement(modalFooterCancel).isDisplayed());
	}
	
	public void modalFooterOkClick() {
		driver.findElement(modalFooterOk).click();
	}
	
	public void delBookAlert() {	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
//		System.out.println(driver.switchTo().alert().getText());
		Assert.assertEquals("Book deleted.", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();		
	}
	
	public String clickLogoutProfileText() {		
		return driver.findElement(profileLogOut).getText();
	}
	
	public Boolean clickLogoutProfileDisplayed() {		
		return driver.findElement(profileLogOut).isDisplayed();
	}
	
	public void clickLogoutProfile() {
		driver.findElement(profileLogOut).click();		
	}
	
}
