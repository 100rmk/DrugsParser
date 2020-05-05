import Entity.HibernateUtil;
import builder.Drug;
import builder.DrugBuilder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static List <String> abcSiteList = new ArrayList<>();
    static List <String> currentList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int count = 0;

        Parser parser = new Parser();
        Document doc = parser.getMainPage();

        Element tableAbc = doc.select("div[class=wrap-abc-words clearfix]").first();
        Elements abcLinks = tableAbc.select("a");

        /**
         * Парсим все ссылки с нижней части сайта в список abcSiteList.
         */
        abcSiteList.add(parser.getUrl()); // FIRST PAGE
        for (Element i : abcLinks) {
            abcSiteList.add(i.attr("href"));
        }

        /**
         *
         */
        HibernateUtil util = new HibernateUtil();
        util.setup();

        for (String abc : abcSiteList) {
            // Парсим текущуюю страницу
            Document document = Jsoup.connect(abc).get();
            Elements currentPage = document.select("div[class=wrap-title-tn]");
            Elements currentLink = currentPage.select("a");

            // Добавляем спрашенные ссылки в список
            for (Element j : currentLink) {
                currentList.add(j.attr("href"));
            }

            // Парсим все необходимые нам компоненты и создаем объект TableDrug
            for (String list : currentList) {
                Date startTime = new Date();

                Document currentDoc = Jsoup.connect(list).get();

                String name = currentDoc.select("span[class=name-preparat-text]").first().text();
                String manufacturer = currentDoc.select("span[class=current-tn-manufactury]").text();
                String dosageForm = currentDoc.select("section[class=ls-dosage-form general-section]")
                        .select("span[class=value]").text();
                String indication = currentDoc.select("section[class=ls-pokazaniya general-section]")
                        .select("span[class=value]").text();
                String contraIndication = currentDoc.select("section[class=ls-protivopokazaniya general-section]")
                        .select("span[class=value]").text();
                String sideEffect = currentDoc.select("section[class=ls-pobochniye-effecti general-section]")
                        .select("span[class=value]").text();
                // Проверка на наличие
                String overdose = currentDoc.select("section[id=peredozirovka]").hasText() ?
                        currentDoc.select("section[id=peredozirovka]").select("span[class=value]").text()
                        : null;
                String warning = currentDoc.select("section[id=ostorozhno]").hasText() ?
                        currentDoc.select("section[id=ostorozhno]").select("span[class=value]").text()
                        : null;
                String pregnancy = currentDoc.select("section[id=beremennost]").hasText() ?
                        currentDoc.select("section[id=beremennost]").select("span[class=value]").text()
                        : null;

                DrugBuilder drugBuilder = new DrugBuilder();
                drugBuilder.setName(name);
                drugBuilder.setManufacturer(manufacturer);
                drugBuilder.setDosageForm(dosageForm);
                drugBuilder.setMedicalIndication(indication);
                drugBuilder.setMedicalContraindication(contraIndication);
                drugBuilder.setSideEffect(sideEffect);
                drugBuilder.setOverdose(overdose);
                drugBuilder.setWarning(warning);
                drugBuilder.setPregnancy(pregnancy);

                Drug drug = drugBuilder.getResult();
                util.create(drug);

//                int randomSecs = ThreadLocalRandom.current().nextInt(15, 30 + 1);
//                System.out.println("count: " + (count = ++count) + " | secs: " + randomSecs);
                Date endTime = new Date();
                float resultTime = endTime.getTime() - startTime.getTime();
                float time = resultTime / 1000;
                System.out.println("count: " + (count = ++count) + "  time :" + time);

            }
            currentList = new ArrayList<>();
            System.out.println("==================================new_page==================================");
        }
                util.exit();
    }
}