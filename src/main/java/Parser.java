import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Parser {
    String url;
    Scanner scanner = new Scanner(System.in);

     protected Document getMainPage() throws IOException {
//        System.out.print("Enter URL: ");
        url = "https://www.lsgeotar.ru/abc-pharma_tn/pg_000dc.html"; //scanner.nextLine();
        scanner.close();

        return Jsoup.parse(new URL(url), 3000);
    }


    public String getUrl() {
        return url;
    }
}
