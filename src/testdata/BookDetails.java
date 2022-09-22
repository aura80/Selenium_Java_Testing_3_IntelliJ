package testdata;

import util.Reader;

public class BookDetails {
	
	private String isbn_label;
	private String isbn_ID;
	private String title_label;
	private String title;
	private String subtitle_label;
	private String subtitle;
	private String author_label;
	private String author;
	private String publisher_label;
	private String publisher;
	private String pages_label;
	private String pages;
	private String description_label;
	private String description;
	private String website_label;
	private String website;
	
	// constructor
	
	public BookDetails(String fileName) {
		this.isbn_label = Reader.json(fileName).get("isbn_label").toString();
		this.isbn_ID = Reader.json(fileName).get("isbn_ID").toString();
		this.title_label = Reader.json(fileName).get("title_label").toString();
		this.title = Reader.json(fileName).get("title").toString();
		this.subtitle_label = Reader.json(fileName).get("subtitle_label").toString();
		this.subtitle = Reader.json(fileName).get("subtitle").toString();		
		this.author_label = Reader.json(fileName).get("author_label").toString();
		this.author = Reader.json(fileName).get("author").toString();
		this.publisher_label = Reader.json(fileName).get("publisher_label").toString();
		this.publisher = Reader.json(fileName).get("publisher").toString();
		this.pages_label = Reader.json(fileName).get("pages_label").toString();
		this.pages = Reader.json(fileName).get("pages").toString();		
		this.description_label = Reader.json(fileName).get("description_label").toString();
		this.description = Reader.json(fileName).get("description").toString();
		this.website_label = Reader.json(fileName).get("website_label").toString();
		this.website = Reader.json(fileName).get("website").toString();
	}
	
	public void set_isbn_label(String isbn_label) {
		this.isbn_label = isbn_label;
	}
	public void set_isbn_ID(String isbn_ID) {
		this.isbn_ID = isbn_ID;
	}
	public void set_title_label(String title_label) {
		this.title_label = title_label;
	}
	public void set_title(String title) {
		this.title = title;
	}
	public void set_subtitle_label(String subtitle_label) {
		this.subtitle_label = subtitle_label;
	}
	public void set_subtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public void set_author_label(String author_label) {
		this.author_label = author_label;
	}
	public void set_author(String author) {
		this.author = author;
	}
	public void set_publisher_label(String publisher_label) {
		this.publisher_label = publisher_label;
	}
	public void set_publisher(String publisher) {
		this.publisher = publisher;
	}
	public void set_pages_label(String pages_label) {
		this.pages_label = pages_label;
	}
	public void set_pages(String pages) {
		this.pages = pages;
	}	
	public void set_description_label(String description_label) {
		this.description_label = description_label;
	}
	public void set_description(String description) {
		this.description = description;
	}
	public void set_website_label(String website_label) {
		this.website_label = website_label;
	}
	public void set_website(String website) {
		this.website = website;
	}
	
	
	public String get_isbn_label() {
		return this.isbn_label;
	}
	public String get_isbn_ID() {
		return this.isbn_ID;
	}
	public String get_title_label() {
		return this.title_label;
	}
	public String get_title() {
		return this.title;
	}
	public String get_subtitle_label() {
		return this.subtitle_label;
	}
	public String get_subtitle() {
		return this.subtitle;
	}
	public String get_author_label() {
		return this.author_label;
	}
	public String get_author() {
		return this.author;
	}	
	public String get_publisher_label() {
		return this.publisher_label;
	}
	public String get_publisher() {
		return this.publisher;
	}
	public String get_pages_label() {
		return this.pages_label;
	}
	public String get_pages() {
		return this.pages;
	}	
	public String get_description_label() {
		return this.description_label;
	}
	public String get_description() {
		return this.description;
	}
	public String get_website_label() {
		return this.website_label;
	}
	public String get_website() {
		return this.website;
	}

}
