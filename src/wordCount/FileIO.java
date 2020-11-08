package wordCount;

import java.io.*;

public class FileIO {
    public void read () throws IOException {
        FileInputStream inputStream = new FileInputStream("txt/input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str;
        while((str = bufferedReader.readLine()) != null)
        {
            System.out.println(str);
        }

        //close
        inputStream.close();
        bufferedReader.close();
    }
    public  static void   write (String file,String s) throws IOException {

        //写入中文字符时解决中文乱码问题
        FileOutputStream fos=new FileOutputStream(new File(file));
        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter  bw=new BufferedWriter(osw);
        bw.write(s);
        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
    }
    public static void main(String[] args) throws IOException {
//        FileIO.write();
    }
}
