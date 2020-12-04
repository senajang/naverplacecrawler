package navercrawler2;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawling {

	public static void main(String[] args) throws Exception{
		String url = "https://map.naver.com/v5/search/%EC%B6%A9%EB%B6%81%EB%8C%80%20%EB%A7%9B%EC%A7%91?placeSearchOption=entry=pll%26filterId=r02465107%26from=nx%26fromNxList=true%26sessionid=jfUx%252FAHkEnEnJpSYtxWglg%253D%253D";
		Document doc =  null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elements = doc.select("span");
		for(Element element:elements) {
			System.out.println(elements.attr("content"));
		
		}}}