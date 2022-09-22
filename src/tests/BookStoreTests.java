package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import pages.BooksPage;
import pages.LoginPage;
import pages.ProfilePage;
import testdata.URL;
import testdata.User;
import testmessages.Messages;

public class BookStoreTests {
	
	static WebDriver driver;
	
	public static LoginPage loginPage;
	public static ProfilePage profilePage;
	public static BooksPage booksPage;
	
	public static User userTD = new User("mainuser");

	
	@BeforeClass
	public static void beforeAll() throws AWTException {
		
		System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
		driver = new ChromeDriver();									// o singura data creez instanta de browser
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		loginPage = new LoginPage(driver);
		profilePage = new ProfilePage(driver);
		booksPage = new BooksPage(driver);
				
		Robot robot = new Robot();
		
		for (int i = 0; i < 5; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}
	
	@AfterClass
	public static void afterAll() {
		driver.close();
		driver.quit();
	}
	
	@Before
	public void before() {
		driver.navigate().to(URL.LOGIN);
	}
	
	@After
	public void after() {
	}
	
	@Test
	public void loginLogoutValidCredentials() throws InterruptedException {
		
		// valid login
		
		Assert.assertEquals(Messages.CHECK_TITLE_URL, loginPage.getInfosTitleURL());
		Assert.assertEquals(Messages.WELCOME, loginPage.getInfosH2());
		Assert.assertEquals(Messages.LOGIN_BOOK_STORE, loginPage.getInfosH5());
		
		loginPage.authenticate(userTD.getUserName(), userTD.getPassword());
				
		loginPage.checks();
//		loginPage.bookNameFind();
		loginPage.clickLogout();

	}
	
	@Test
	public void invalidLogin1() {
		
		// Invalid_login_1
		
		loginPage.authenticate(userTD.getUserName_invalid_1(), userTD.getPassword_invalid_1());
		Assert.assertTrue(loginPage.userInvalidCheck().contains("is-invalid"));		
		
	}
	
	@Test
	public void invalidLogin2() {
		
		// Invalid_login_2
		
		loginPage.authenticate(userTD.getUserName_invalid_2(), userTD.getPassword_invalid_2());
		Assert.assertEquals("Invalid username or password!", loginPage.loginErrorMessage());
		
	}
	
	@Test
	public void findBook() {
		
		// Book finding!

		loginPage.authenticate(userTD.getUserName(), userTD.getPassword());
				
		Assert.assertTrue(loginPage.bookNameFind().contains(Messages.SPEAKING_JAVASCRIPT));
		loginPage.clickLogout();

	}
	
	@Test
	public void checksMyList() {
		
		// Profile!
		
		loginPage.authenticate(userTD.getUserName(), userTD.getPassword());
						
		// printing elements of the books wrapper
		
		Assert.assertEquals(Messages.BOOKS, profilePage.checkBookLabel());
		Assert.assertEquals(Messages.USERNAME_AURA, profilePage.checkUserNameLabel() + " " + profilePage.checkUser());
		Assert.assertEquals(Messages.LOG_OUT, profilePage.checkLogOutButton());
		
		profilePage.checkBooksWrapper();	// assertions
		
		profilePage.searchBox();			// sending 'Java' word for searching
		profilePage.clickSearchBook();		// clicking search		
		loginPage.bookNameFind();			// printing all books + after name
		profilePage.bookInfosAuthor();
		Assert.assertEquals(Messages.ALEX_RAUSCH, profilePage.bookInfosAuthor());
		Assert.assertEquals(Messages.OREILLY_MEDIA, profilePage.bookInfosPublisher());
		Assert.assertEquals(Messages.JPG_BOOKIMAGE0, profilePage.bookInfosAttribute());
		Assert.assertEquals(Messages.COLOR, profilePage.bookInfosColor());
		Assert.assertTrue(profilePage.bookInfosDisplayed());
		Assert.assertTrue(profilePage.bookInfosLocation().contains(","));
		Assert.assertEquals(Messages.PICTURE_SIZE, profilePage.bookInfosPictSize());
		Assert.assertEquals(Messages.STATIC, profilePage.bookInfosPictPosition());

		loginPage.clickLogout();

	}
	
	@Test
	public void loginAddDeleteLogout() throws AWTException {
			
			// Book deleting!
			
			Robot robot = new Robot();
			
			for (int i = 0; i < 5; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}

			loginPage.authenticate(userTD.getUserName(), userTD.getPassword());
						
			Assert.assertEquals(Messages.GO_BOOK_STORE, profilePage.goToStore());
			profilePage.goToStoreDisplayed();
			Assert.assertTrue(profilePage.goToStoreDisplayed());
			profilePage.goToStoreClick();
			Assert.assertEquals(Messages.YOU_DONT_KNOW_JS, profilePage.clickBookText());
			Assert.assertTrue(profilePage.clickBookDisplayed());
			profilePage.clickBook();
			Assert.assertEquals(Messages.AURA, booksPage.checkUserName());
			Assert.assertTrue(booksPage.checkBookInfo().contains(Messages.KYLE_SIMPSON));
			Assert.assertTrue(booksPage.checkBookInfo().contains(Messages.CODE));
			Assert.assertEquals(Messages.ADD_TO_COLLECTION, booksPage.addToCollection());
			booksPage.addBookAlert();			// explicit wait added + accept alert print text and class of the alert
			
			driver.navigate().to(URL.PROFILE);
			
			profilePage.delButtonText();
			Assert.assertEquals(Messages.YOU_DONT_KNOW_JS, profilePage.delButtonText());
			profilePage.delButtonClick();
			Assert.assertEquals(Messages.DELETE_BOOK_ASK, profilePage.modalBodyText());
			Assert.assertTrue(profilePage.modalHeaderText().contains("Delete Book"));	
			Assert.assertEquals(Messages.OK, profilePage.modalFooterTextOk());
			Assert.assertTrue(profilePage.modalFooterTextOkDisplayed());
			profilePage.modalFooterOkClick();						
			profilePage.delBookAlert();			// explicit wait added + accept allert and print it's text
			Assert.assertEquals(Messages.LOG_OUT, profilePage.clickLogoutProfileText());
			Assert.assertTrue(profilePage.clickLogoutProfileDisplayed());
			profilePage.clickLogoutProfile();
	}
	
	@Test
	public void searchBook() throws AWTException {
			
			// Book searching!
			
			Robot robot = new Robot();
			
			for (int i = 0; i < 5; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}

			loginPage.authenticate(userTD.getUserName(), userTD.getPassword());
									
			profilePage.goToStoreClick();	
			booksPage.searchBookSendK();
//			System.out.println(booksPage.searchBook());		
			Assert.assertTrue(booksPage.searchBook().contains(Messages.LEARNING_JAVASCRIPT));
			Assert.assertTrue(booksPage.searchBook().contains(Messages.SPEAKING_JAVASCRIPT));
			Assert.assertTrue(booksPage.searchBook().contains(Messages.PROGRAMMING_JAVASCRIPT));
			Assert.assertTrue(booksPage.searchBook().contains(Messages.ELOQUENT_JAVASCRIPT));
			Assert.assertTrue(booksPage.searchBook().contains(Messages.UNDERSTANDING_ECMASCRIPT));

			booksPage.searchEditionBooks();			
			booksPage.searchGuideBooks();
			booksPage.searchBooksClear();
//			System.out.println(booksPage.searchJBooks());	
			booksPage.searchJBooksSendK();
			Assert.assertTrue(booksPage.searchJBooks().contains(Messages.PROGRAMMING_JAVASCRIPT));
			booksPage.searchBooksClear();
			System.out.println(booksPage.searchBlankBooks());			
			profilePage.clickLogoutProfile();
			
	}	
	
	@Test
	public void searchBookDetails() throws AWTException {
		
		// Book details!
		
		Robot robot = new Robot();
		
		for (int i = 0; i < 5; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

		loginPage.authenticate(userTD.getUserName(), userTD.getPassword());
		
		profilePage.goToStoreClick();
		booksPage.clickSpeakingBook();
		booksPage.detailsSpeakingBook();
		
		booksPage.checkLabel();
		
		profilePage.clickLogoutProfile();

		
	}
			
}
