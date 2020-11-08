package wordCount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import  com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Main {

    private final static String dict = "txt/2-2-3lem.txt";
    private final static String input_txt = "txt/input.txt";
    private final static String temp_txt = "txt/temp.json";
    private final static String output_txt = "txt/output.json";
    private  final static int NUMBER =10;

    public static void main(String args[]) throws IOException {

        HashMap<String, String> dictMap = Dict.readDict(dict);
        String inPut = FileIO.read(input_txt);
        HashMap<String, Integer> freqMap = ParseFile.getFreq(inPut, dictMap);
        Map<String, Integer> sortMap=SortMap.sortMap(freqMap);
        Map<String, Integer> resMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : sortMap.entrySet()) {
            resMap.put(entry.getKey(), entry.getValue());
            if (resMap!=null & resMap.size()>=NUMBER) break;

        }
        String json_temp=JSON.toJSONString(sortMap, SerializerFeature.PrettyFormat);
        String json_out=JSON.toJSONString(resMap, SerializerFeature.PrettyFormat);

        FileIO.write(temp_txt,json_temp);
        FileIO.write(output_txt,json_out);

    }
}
