package wordCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Dict {

    public static HashMap<String, String> readDict(String filename) {
        String dict = ReadFile.read(filename);
        // <变种, 原型>
        HashMap<String, String> dictMap = new HashMap<>();
        // 匹配开始的四个空格
        Pattern pt = Pattern.compile("\\s{4}.+");
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(dict);
        while (scanner.hasNext()) {
            arrayList.add(scanner.nextLine());
        }
        for (int i = 1; i < arrayList.size(); i++) {
            if (pt.matcher(arrayList.get(i)).matches()) {
                // 根据逗号分词
                String[] spl = arrayList.get(i).split(",");
                for (String string : spl) {
                    string = string.replaceAll("\\s{4}", "");
                    string = string.replaceAll(" ", "");
                    dictMap.put(string, arrayList.get(i - 1));
                }
            }
        }
        scanner.close();
        System.out.println(dictMap);
        return dictMap;
    }
}
