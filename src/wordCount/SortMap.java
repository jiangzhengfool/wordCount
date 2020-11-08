package wordCount;

import java.io.IOException;
import java.util.*;


public class SortMap {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortMap(Map<K, V> map) throws IOException {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
