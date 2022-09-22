package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.BookDetails;

import junit.framework.Assert;
import testdata.BookDetails;

public class BooksPage {
	WebDriver driver;				// driverul se va instantia dupa ce voi crea obiectul si nu inainte
	
	public BooksPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public static BookDetails bookdetailsTD = new BookDetails("bookdetails");

	
	private String nameBook1 = "Script";
	private String nameBook2 = "Edition";
	private String isbnText = "ISBN-wrapper";
	private String titleText = "title-wrapper";
	private String subtitle = "subtitle-wrapper";
	private String author = "author-wrapper";
	private String publisher = "publisher-wrapper";
	private String pages = "pages-wrapper";
	private String description = "description-wrapper";
	private String website = "website-wrapper";

	
	// locators
	
	private By checkUserName = By.id("userName-value");
	private By addToCollectionButton = By.xpath("//div[@class=\"text-right fullButton\"]/button");
	private By searchBook = By.id("searchBox");
	private By foundBooks1 = By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\""+nameBook1+"\")]//a");
	private By foundBooks2 = By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\""+nameBook2+"\")]//a");
	private By foundBooks3 = By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\"Pocket\")]//a");
	private By foundBooks4 = By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\"J\")]//a");
	private By nameBooks = By.xpath("//div[@class=\"rt-tbody\"]/div/div/div[2]/descendant::span");
	private By clickSpeakingBook = By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\"Speaking JavaScript\")]//span");
	
	private By isbnLabel_1 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+isbnText+"\"]/div[1]/label");
	private By isbnLabel_2 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+isbnText+"\"]/div[2]/label");

	private By titleLabel_1 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+titleText+"\"]/div[1]/label");
	private By titleLabel_2 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+titleText+"\"]/div[2]/label");
	
	private By subtitleLabel_1 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+subtitle+"\"]/div[1]/label");
	private By subtitleLabel_2 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+subtitle+"\"]/div[2]/label");
	
	private By authorLabel_1 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+author+"\"]/div[1]/label");
	private By authorLabel_2 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+author+"\"]/div[2]/label");
	
	private By publisherLabel_1 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+publisher+"\"]/div[1]/label");
	private By publisherLabel_2 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+publisher+"\"]/div[2]/label");
	
	private By pagesLabel_1 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+pages+"\"]/div[1]/label");
	private By pagesLabel_2 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+pages+"\"]/div[2]/label");
	
	private By descriptionLabel_1 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+description+"\"]/div[1]/label");
	private By descriptionLabel_2 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+description+"\"]/div[2]/label");
	
	private By websiteLabel_1 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+website+"\"]/div[1]/label");
	private By websiteLabel_2 = By.xpath("//div[@class=\"profile-wrapper\"]/div[@id=\""+website+"\"]/div[2]/label");
	
	// Actions
	
	public String checkUserName() {
		return driver.findElement(checkUserName).getText();
	}
	
	public List<String> checkBookInfo() {

		List<WebElement> infosBook = checkUserName.findElements(driver);
		List<String> infos = new ArrayList<String>();
				
		for (int i = 0; i < infosBook.size(); i++) {
			
			for (WebElement info : infosBook) {			
				infos.add(info.getText());	
			}
			
//			System.out.println(infos.get(i));
//			System.out.println(infosBook.get(i).getText());
			
			Assert.assertEquals(infos.get(i), infosBook.get(i).getText());
		}
		return infos;
	}
	
	public String addToCollection() {
		driver.findElement(addToCollectionButton).click();
		return driver.findElement(addToCollectionButton).getText();
	}
	
	public void addBookAlert() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			
//		System.out.println(driver.switchTo().alert().getText());
		Assert.assertTrue(driver.switchTo().alert().getText().contains("your collection"));
//		Assert.assertTrue(driver.switchTo().alert().getText().contains("Book added to your collection."));

//		System.out.println(driver.switchTo().alert().getClass());
		driver.switchTo().alert().accept();
	}
	
	public void searchBookSendK() {
		driver.findElement(searchBook).sendKeys("Script");
	}
	
	public List<String> searchBook() {
		
		List<WebElement> carti = driver.findElements(foundBooks1);
		List<String> carteText = new ArrayList<String>();

		for (WebElement carte : carti ) {
			if (carte.getText().contains("Java")) {
//				System.out.println(" * " + carte.getText());
				carteText.add(carte.getText());
				Assert.assertTrue(carte.getText().contains("Java"));
			}
			else {
//				System.out.println(" ** " + carte.getText());
				carteText.add(carte.getText());
				Assert.assertTrue(carte.getText().contains("Script"));
			}
		}
		
		System.out.println();
		
		return carteText;
		
	}
	
	public void searchEditionBooks() {
		
		List<WebElement> carti = driver.findElements(foundBooks2);
		System.out.println();
		System.out.println(" " + carti.size() + " book containing \"Edition\":");
		for (WebElement carte : carti ) {
			System.out.println(" *** " + carte.getText());
			Assert.assertTrue(carte.getText().contains("Edition"));
		}
		
	}
	
	public void searchGuideBooks() {
		
		driver.findElement(searchBook).clear();
		driver.findElement(searchBook).sendKeys("Guide");
		List<WebElement> carti = driver.findElements(foundBooks3);
		
		System.out.println();
		
		System.out.println(" " + carti.size() + " book containing \"Guide\":");
		for (WebElement carte : carti ) {
			System.out.println(" **** " + carte.getText());
			Assert.assertTrue(carte.getText().contains("Guide"));
		}
		
	}
		
	public void searchBooksClear() {
		
		for (int i = 0; i < 5; i++) {
			driver.findElement(searchBook).sendKeys(Keys.BACK_SPACE);
		}
		
	}
	
	public void searchJBooksSendK() {
		driver.findElement(searchBook).sendKeys("J");
	}
	
	public List<String> searchJBooks() {
		
		List<WebElement> carti = driver.findElements(foundBooks4);
		List<String> carteText = new ArrayList<String>();

		System.out.println();
		
		System.out.println(" " + carti.size() + " books containing \"J\":");
		for (WebElement carte : carti ) {
			System.out.println(" ***** " + carte.getText());
			carteText.add(carte.getText());
			Assert.assertTrue(carte.getText().contains("J"));
		}
		
		System.out.println();
		
		return carteText;

	}
	
	public List<String> searchBlankBooks() {
		
		driver.findElement(searchBook).sendKeys("Java");
		List<WebElement> carti = driver.findElements(nameBooks);
		List<String> carteText = new ArrayList<String>();

		System.out.println();
		
		System.out.println("All the " + carti.size() + " spaces containing \"Java\":");
		
		for (WebElement carte : carti ) {
			
			System.out.println(" ***** " + carte.getText());
			
			if (!carte.getText().isBlank()) {
				carteText.add(carte.getText());
				Assert.assertTrue(carte.getText().contains("Java"));
			}
		}
		
		System.out.println("The list of books containing \"Java\" word has " + carteText.size() + " books ");
		
		return carteText;
		
	}
	
	public void clickSpeakingBook() {
		driver.findElement(clickSpeakingBook).click();
	}

	public void detailsSpeakingBook() {
		Assert.assertTrue(driver.findElement(isbnLabel_1).getText().contains("ISBN :"));
		Assert.assertEquals("ISBN :", driver.findElement(isbnLabel_1).getText());
		Assert.assertEquals("9781449365035", driver.findElement(isbnLabel_2).getText());
		
		Assert.assertTrue(driver.findElement(isbnLabel_1).getText().contains("ISBN :"));
		Assert.assertEquals("ISBN :", driver.findElement(isbnLabel_1).getText());
		Assert.assertEquals("9781449365035", driver.findElement(isbnLabel_2).getText());
		

	}
	
	public void checkLabel() {
		List<WebElement> elemente = new ArrayList<WebElement>();
		List<String> elementeText = new ArrayList<String>();

		elemente.add(driver.findElement(isbnLabel_1));
		elemente.add(driver.findElement(isbnLabel_2));
		elemente.add(driver.findElement(titleLabel_1));
		elemente.add(driver.findElement(titleLabel_2));
		elemente.add(driver.findElement(subtitleLabel_1));
		elemente.add(driver.findElement(subtitleLabel_2));
		elemente.add(driver.findElement(authorLabel_1));
		elemente.add(driver.findElement(authorLabel_2));
		elemente.add(driver.findElement(publisherLabel_1));
		elemente.add(driver.findElement(publisherLabel_2));
		elemente.add(driver.findElement(pagesLabel_1));
		elemente.add(driver.findElement(pagesLabel_2));
		elemente.add(driver.findElement(descriptionLabel_1));
		elemente.add(driver.findElement(descriptionLabel_2));
		elemente.add(driver.findElement(websiteLabel_1));
		elemente.add(driver.findElement(websiteLabel_2));

		
		for (WebElement elem : elemente) {
			elementeText.add(elem.getText());
		}
		
//		for (int i = 0; i < elementeText.size(); i++) {
//			System.out.println(elementeText.get(i));		
//		}
		
//		System.out.println("JSon " + bookdetailsTD.get_isbn_label());
		Assert.assertEquals(elementeText.get(0), bookdetailsTD.get_isbn_label());
//		System.out.println("JSon " + bookdetailsTD.get_isbn_ID());
		Assert.assertEquals(elementeText.get(1), bookdetailsTD.get_isbn_ID());
//		System.out.println("JSon " + bookdetailsTD.get_title_label());
		Assert.assertEquals(elementeText.get(2), bookdetailsTD.get_title_label());
//		System.out.println("JSon " + bookdetailsTD.get_title());
		Assert.assertEquals(elementeText.get(3), bookdetailsTD.get_title());
		Assert.assertEquals(elementeText.get(4), bookdetailsTD.get_subtitle_label());
		Assert.assertEquals(elementeText.get(5), bookdetailsTD.get_subtitle());
		Assert.assertEquals(elementeText.get(6), bookdetailsTD.get_author_label());
		Assert.assertEquals(elementeText.get(7), bookdetailsTD.get_author());
		Assert.assertEquals(elementeText.get(8), bookdetailsTD.get_publisher_label());
		Assert.assertEquals(elementeText.get(9), bookdetailsTD.get_publisher());
		Assert.assertEquals(elementeText.get(10), bookdetailsTD.get_pages_label());
		Assert.assertEquals(elementeText.get(11), bookdetailsTD.get_pages());
		Assert.assertEquals(elementeText.get(12), bookdetailsTD.get_description_label());
		Assert.assertEquals(elementeText.get(13), bookdetailsTD.get_description());
		Assert.assertEquals(elementeText.get(14), bookdetailsTD.get_website_label());
		Assert.assertEquals(elementeText.get(15), bookdetailsTD.get_website());
						
	}

}
