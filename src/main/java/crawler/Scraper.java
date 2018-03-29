package crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Scraper {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Scraper.class.getClassLoader().getResourceAsStream("links");
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        HashMap<String, String> urls = new HashMap<String, String>();
        WebDriver driver = new ChromeDriver();
        String line = fileReader.readLine();
        while (true) {
            if (line == null) break;
            driver.get(line);
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"MainCol\"]/div/ul/li[*]/div[2]"));
            for (WebElement element : elements) {
                WebElement linkElement = element.findElement(By.xpath("div[1]/div[1]/a"));
                String url = linkElement.getAttribute("href");
                String name = element.findElement(By.xpath("div[2]")).getText();
                String title = linkElement.getText().toLowerCase();
                if (title.contains("data")) {
                    urls.put(url, name);
                }
                System.out.println("FETCHED =>" + url);
            }
            System.out.println("-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0");
            System.out.println("DONE =>" + line);
            line = fileReader.readLine();
        }
        BufferedWriter link_Only = new BufferedWriter(new FileWriter("Norway_link_only.txt"));
        BufferedWriter all = new BufferedWriter(new FileWriter("Norway_all.txt"));
        System.out.println(urls.size());
        for (String s : urls.keySet()) {
            link_Only.write(s);
            link_Only.newLine();
            all.write(urls.get(s));
            all.newLine();
            all.write(s);
            all.newLine();
            all.write("--------------");
            all.newLine();

        }
        link_Only.close();
        all.close();
        System.out.println("DOOOOOONNNNNEEEEE");
    }
}
