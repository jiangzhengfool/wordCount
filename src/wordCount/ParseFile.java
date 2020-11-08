package wordCount;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ParseFile {

    public static HashMap<String, Integer> getFreq(String input, HashMap<String, String> dictMap) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        String regEx="[`~!@#$%^&*()_\\-+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？[\"][0-9]]";

        Pattern regex = Pattern.compile(regEx);
        input = regex.matcher(input).replaceAll(" ");

        input = input.toLowerCase();
        Scanner scanner = new Scanner(input);
        RemoveWord.readWord();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (dictMap.containsKey(s)) {
                s = dictMap.get(s);
            }

            if (s.length() > 3) {
                if(!RemoveWord.find(s)){
                    Integer freq = freqMap.get(s);
                    freqMap.put(s, freq == null ? 1 : freq + 1);
                }

            }
        }

        scanner.close();

        return freqMap;
    }
}
