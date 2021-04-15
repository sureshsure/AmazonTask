package com.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	public static WebDriver driver;
	/*public void lauchBrowser(String browserName) 
	{
		switch(browserName)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "F:\\Friends Files\\suresh\\software\\chromedriver1\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions chromeoption = new ChromeOptions();
			chromeoption.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeoption);
			break;
		case "firefox":
			System.out.println("the firefox browser run");
			break;

		case "IE":
			System.out.println("the internet explorer browser run");
			break;
		default:
			System.out.println("invalid browser name ");
		}
	}*/
	
	public BaseClass() {
		System.setProperty("webdriver.chrome.driver", "F:\\Friends Files\\suresh\\software\\chromedriver1\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeoption);
		//driver.manage().window().maximize();
	}
	
	public void launchURL(String url)
	{
		driver.get(url);
		
	}

}
