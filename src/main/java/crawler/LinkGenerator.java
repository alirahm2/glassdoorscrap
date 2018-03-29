package crawler;

public class LinkGenerator {
    public static void main(String[] args) {
        String link = "https://www.glassdoor.com/Job/norway-data-engineer-jobs-SRCH_IL.0,6_IN180_KO7,20_IP%s.htm";
        for (int i = 1; i < 6; i++) {
            System.out.println(String.format(link, i));
        }
    }
}
