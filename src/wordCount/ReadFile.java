package wordCount;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadFile {

    public static String read(String filename) {
        StringBuffer sb = new StringBuffer();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filename));
            BufferedReader in = new BufferedReader(isr);
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append('\n');
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


    public static String read(String filename, String codeType) {
        StringBuffer sb = new StringBuffer();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filename), codeType);
            BufferedReader in = new BufferedReader(isr);
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append('\n');
                }
            } finally {
                in.close();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return sb.toString();
    }
}
