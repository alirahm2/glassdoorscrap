package JsonParser;

import com.google.gson.Gson;
import crawler.Scraper;

import java.io.InputStream;
import java.io.InputStreamReader;

public class JobFileParser {
    public static void main(String[] args) {
        Gson gson = new Gson();
        InputStream resourceAsStream = Scraper.class.getClassLoader().getResourceAsStream("job.json");
        InputStreamReader reader = new InputStreamReader(resourceAsStream);
        Job job = gson.fromJson(reader, Job.class);
        System.out.println();

    }
}
