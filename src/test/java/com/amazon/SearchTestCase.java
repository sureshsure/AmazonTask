package com.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTestCase {

	BaseClass base;
	SearchObject searchobj;
	
	 String getPrice ;
     String getPhoneName ;

	public SearchTestCase() {
		base=new BaseClass();
		searchobj=new  SearchObject();
	}
	@BeforeTest
	public void lauchURL() {

		base.launchURL("https://www.amazon.in/");
	}
	@AfterTest
	public void closeBrowser() {
		BaseClass.driver.quit();
	}

	@Test
	public void searchBox() throws InterruptedException {
		
		searchobj.getSearchbox().sendKeys("iphone",Keys.ENTER);
		
		List<WebElement> name =  BaseClass.driver.findElements(By. xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
		System.out.println("the number of iphone "+name.size());
		
		
		List<WebElement> price =  BaseClass.driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]"));
		System.out.println("the number of iphone price list "+price.size());
        
		
		 
		 Map<String, String> map = new HashMap<String, String>();
				for (WebElement i : name)
				{
					 getPhoneName= i.getText();
					//System.out.print(getPhoneName+" ");

					String priceXpath="//*[text()='"+getPhoneName +
							"']/ancestor::div[@class='sg-row']//span[@class=\"a-price-whole\"]";
					
					List<WebElement> priceiphone =  BaseClass.driver.findElements(By.xpath(priceXpath));
					
					for (WebElement b : priceiphone) {
						  getPrice = b.getText();
						
						//System.out.println("----Rs "+getPrice);
						 
						 map.put(getPrice, getPhoneName);
						break;
					}
				} 
				
				System.out.println("********Before sorting************ \n");
				map.forEach((k,v)->System.out.println(k+"\t"+v));
				
				Set<Entry<String, String>> entrySet = map.entrySet();
				
				List<Entry<String, String>> list = new ArrayList<>(entrySet);
				
				Collections.sort(list, new Comparator<Entry<String, String>>() {

					@Override
					public int compare(Entry<String, String> o1, Entry<String, String> o2) {
					
						//return o1.getValue().compareTo(o2.getValue());
						 
						String s1=o1.getKey();
						String a = s1.replaceAll(",", "");
						int in1= Integer.valueOf(a);
						String s2 = o2.getKey();
						String b = s2.replaceAll(",", "");
						int in2= Integer.valueOf(b);
						
						
						if(in1>in2)
						{
							return +1;
						}
						else if(in1<in2)
						{
							return -1;
						}
						
						else
						{
							return 0;
						}
						
					/*
						if(o1.getKey()>o1.getKey())
						{
							return +1;
						}
						else if(o1.getKey()<o1.getKey())
						{
							return -1;
						}
						else
						{
							return 0;
						}
						*/	
							
						
						
					}
				});
				
				System.out.println("\n\n********after sorting ***********\n\n");
				list.forEach(l->
				{
				   System.out.println(l.getKey()+"\t"+l.getValue());
				});
				
				
				

				
				
				
	}




}


