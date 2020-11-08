package wordCount;

import java.io.*;

public class FileIO {
    public  static String read (String filename) throws IOException {
        StringBuffer sb = new StringBuffer();
        FileInputStream inputStream = new FileInputStream(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            sb.append(s);
            sb.append('\n');
        }
        inputStream.close();
        bufferedReader.close();
        return sb.toString();
    }
    public  static void   write (String file,String s) throws IOException {


        FileOutputStream fos=new FileOutputStream(new File(file));
        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter  bw=new BufferedWriter(osw);
        bw.write(s);
        bw.close();
        osw.close();
        fos.close();
    }
    public static void main(String[] args) throws IOException {
       //FileIO.read("txt/input.txt");
    }
}
