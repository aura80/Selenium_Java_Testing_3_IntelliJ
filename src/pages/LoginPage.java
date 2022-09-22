package pages;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InterruptedNamingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class LoginPage {

	WebDriver driver;				// driverul se va instantia dupa ce voi crea obiectul si nu inainte
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators , UI mapper
	
	private By usernameInput = By.id("userName");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login");
	private By checkUser = By.xpath("//div[@id=\"books-wrapper\"]/descendant::label[contains(.,\"User Name : \")]");
	private By userNameValue = By.id("userName-value");
	private By logOut = By.xpath("//div[@id=\"books-wrapper\"]/descendant::button[contains(.,\"Log out\")]");
	private By userInvalid = By.xpath("//input[@class=\"mr-sm-2 is-invalid form-control\"][@id=\"userName\"]");
	private By bookSearch = By.xpath("//div[@class=\"rt-tbody\"]/div/div/div[2]");
	private By loginErrorMsg = By.xpath("//form[@id=\"userForm\"]/div[5]//p");
	
	//Actions
	
	public void enterUsername(String name) {
		driver.findElement(usernameInput).sendKeys(name);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public void clickLogout() {
		
		Assert.assertEquals("Log out", driver.findElement(logOut).getText());
		Assert.assertTrue(driver.findElement(logOut).isDisplayed());
		driver.findElement(logOut).click();
		
	}
	
	public void authenticate(String name, String password ) {
		enterUsername(name);
		enterPassword(password);
		clickLogin();
	}
	
	public String userInvalidCheck() {
		return driver.findElement(userInvalid).getAttribute("class");
	}
	
	public String loginErrorMessage() {
		return driver.findElement(loginErrorMsg).getText();
	}
	
	public void checks() {	
		Assert.assertEquals("User Name :", driver.findElement(checkUser).getText());
		Assert.assertTrue(driver.findElement(checkUser).isDisplayed());		
		Assert.assertEquals("aura", driver.findElement(userNameValue).getText());	
	}
	
	public String getInfosTitleURL() {	
		return driver.getTitle() + " " + driver.getCurrentUrl();
	}
	
	public String getInfosH2() {
		WebElement text1 = driver.findElement(By.tagName("h2"));
		return text1.getText();		
	}
	
	public String getInfosH5() {
		WebElement text2 = driver.findElement(By.tagName("h5"));
		return text2.getText();		
	}
	
	public List<String> bookNameFind() {
		System.out.println();
		List<WebElement> books =  driver.findElements(bookSearch);
		List<String> bookListText = new ArrayList<String>();
		
		// returning all the books from my list + white spaces
		for(WebElement book:books) {
			bookListText.add(book.getText());
//			System.out.println("Book:  " + book.getText());
		}
		
		System.out.println();
		
		// returning only the searched books
		for (int i = 0; i < bookListText.size(); i++) {
			// printing books as Strings
//			System.out.println(bookListText.get(i));
			// if it finds the word 'Speaking' in my list it prints the entire name of the book
			if(bookListText.get(i).contains("Speaking")) {
//				System.out.println("Book - " + bookListText.get(i) + " was found ");
				Assert.assertEquals("Speaking JavaScript", bookListText.get(i));
				break;
			}
		}
		
		// printing all the books in list format + white spaces
//		System.out.println(bookListText);
				
		return bookListText;
	}
	
}
