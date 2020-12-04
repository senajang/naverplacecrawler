package navercrawler;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class naver {
		public static void main(String[] args) {

	        // WebDriver 경로 설정
	        System.setProperty("webdriver.chrome.driver", "c:/javastudy/test1/chromedriver.exe");
	        
	        
	        
	        // WebDriver 객체 생성
	        ChromeDriver driver = new ChromeDriver( options );
	       
	        driver.get("https://map.naver.com/v5/");
	        
	        try {
	        	Thread.sleep(1000); //1초 대기
	           } catch (InterruptedException e) {
	        	e.printStackTrace();
	           }
	        
		}		
	}