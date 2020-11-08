package wordCount;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveWord {
    private final static String removeWord = "txt/stopwords.txt";
    private static  ArrayList<String> arrayList = new ArrayList<>();
    public static void readWord(){

        String input = ReadFile.read(removeWord);

        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            String s = scanner.next();

            arrayList.add(s);

        }
        System.out.println(arrayList);


    }
    public static boolean find(String string){
        string =string.toLowerCase();
        return arrayList.indexOf(string)>-1?true:false;
    }

    public static void main(String[] args) {
        readWord();
        System.out.println(find("by"));
    }
}
