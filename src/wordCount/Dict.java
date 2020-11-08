package wordCount;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Dict {

    public static HashMap<String, String> readDict(String filename) throws IOException {
        String dict = FileIO.read(filename);

        HashMap<String, String> dictMap = new HashMap<>();
        Pattern pt = Pattern.compile("\\s{4}.+");
        Scanner scanner = new Scanner(dict);
        String before =null;
        while (scanner.hasNext()) {
           String s =  scanner.nextLine();
            if (pt.matcher(s).matches()) {
                // 根据逗号分词
                String[] arr = s.split(",");
                for (String string : arr) {
                    string = string.trim();
                    dictMap.put(string, before);
                }
            }
            before =s;

        }
        scanner.close();
        String json_out= JSON.toJSONString(dictMap, SerializerFeature.PrettyFormat);
        FileIO.write("txt/dict.json",json_out);
        return dictMap;
    }
}
