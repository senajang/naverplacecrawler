package navercrawler2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class crawling {

	public static void main(String[] args) {
		// WebDriver 경로 설정
				System.setProperty("webdriver.chrome.driver", "C:\\javastudy\\navercrawler2/chromedriver.exe");
				
				// WebDriver 옵션 설정
			    ChromeOptions options = new ChromeOptions();
			    options.addArguments("--start-maximized");            // 전체화면으로 실행
			    options.addArguments("--disable-popup-blocking");    // 팝업 무시
			    options.addArguments("--disable-default-apps"); // 기본앱 사용안함
				
			    //WebDriver 객체 생성
			    ChromeDriver driver = new ChromeDriver( options );
			    
			    driver.get("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%B6%A9%EB%B6%81%EB%8C%80+%EB%A7%9B%EC%A7%91");
			    			    
			    try {

			    	Thread.sleep(1000); //1초 대기

			       } catch (InterruptedException e) {

			    	e.printStackTrace();

			       }
			    
			    WebElement button=driver.findElementByXPath("//*[@id=\"place_main_ct\"]/div/section[1]/div/div[3]/a");
		        button.click();
		
		        try {

		        	Thread.sleep(1000); //1초 대기

		           } catch (InterruptedException e) {

		        	e.printStackTrace();

		           }
		        
		        for(int i=1; i<20; i++)
		        {
		        	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        			.ignoring(NoSuchElementException.class);
		        	
		        			
		        	String names_xpath = String.format("//*[@id=\"_pcmap_list_scroll_container\"]/ul/li[1]/div[1]/a/div[1]/div",i);
		        	String ratings_xpath = String.format("//*[@id=\"content\"]/div/div[4]/div/div[2]/div[%d]/div/table/tbody/tr/td[2]/div/div[2]/span[1]/span",i);
		        	String reviews_xpath = String.format("//*[@id=\"content\"]/div/div[4]/div/div[2]/div[%d]/div/table/tbody/tr/td[2]/div/div[2]/span[2]",i);
		        	
		        	WebElement names = driver.findElementByXPath(names_xpath);
		        	WebElement ratings = driver.findElementByXPath(ratings_xpath);
		        	WebElement reviews = driver.findElementByXPath(reviews_xpath);
		        	
		        	String name = names.getText();
		        	String rate = ratings.getText();
		        	String review = reviews.getText();
		        	
		        	String rate_intStr = rate.replaceAll("[^0-9.]", "");
		        	String review_intStr = review.replaceAll("[^0-9]", "");
		        	
		        	float rate_int = Float.parseFloat(rate_intStr);
		        	int review_int = Integer.parseInt(review_intStr);
			        
		        	System.out.println(name);
		        	System.out.println(rate_int);
		        	System.out.println(review_int);
		      
			        
		        }
		        
		        
		        
		        try {
		            Thread.sleep(5000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } finally {
		            // WebDriver 종료
		            driver.quit();
		    }
	}
}
    