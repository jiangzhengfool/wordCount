package wordCount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveWord {
    private final static String removeWord = "txt/stopwords.txt";
    private static  ArrayList<String> arrayList = new ArrayList<>();
    public static void readWord() throws IOException {

        String input = FileIO.read(removeWord);

        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            String s = scanner.next();
            arrayList.add(s);
        }


    }
    public static boolean find(String string){
        string =string.toLowerCase();
        return arrayList.indexOf(string)>-1?true:false;
    }

    public static void main(String[] args) throws IOException {
        readWord();
        System.out.println(find("by"));
    }
}
