import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class lab3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        //System.out.println(urlToString"https://www.bls.gov/tus/charts/chart9.txt");
        //System.out.println("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");
        System.out.println(wordSearch("Hamlet Jessica is Hamlet how you Hamlet", "Hamlet"));
    }



    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

   public static long wordCount(final String url) {
       String words = urlToString(url);
       //String words = url;
       long length = words.length();
       long numWords = 1;
       for (int i=0; i < length; i++) {
           if(words.charAt(i)==(char)32) {
               numWords++;
           }
       }

       return numWords;
   }

   public static int wordSearch(final String url, final String word) {
       String searchWord = word;
       //String words = urlToString(url);
       String words = url;
       int numInstances = 0;
       int wordLength = 0;
       for(int i=0; i<words.length(); i++) {
           for(int j=0; j<searchWord.length(); j++) {
               if (!(words.charAt(i)==searchWord.charAt(j))) {
                   wordLength = 0;
                   break;
               }
               if (searchWord.length() == wordLength) {
                   numInstances+=1;
                   wordLength = 0;
                   break;
               }
               if (words.charAt(i)==searchWord.charAt(j)) {
                   wordLength++;
               }
           }
       }


       return 0;

   }
}