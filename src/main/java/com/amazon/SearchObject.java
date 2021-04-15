package com.amazon;

import java.awt.List;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchObject extends BaseClass{

	@FindBy(id="twotabsearchtextbox")
	private WebElement searchbox;
	
	
	
	
	public SearchObject() {
		PageFactory.initElements(driver,this);
	}

	public WebElement getSearchbox() {
		return searchbox;
	}
	
	
}
