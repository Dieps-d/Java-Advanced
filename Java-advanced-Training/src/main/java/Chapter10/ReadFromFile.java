package Chapter10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/15
 **/

public class ReadFromFile {
    public static void main(String[] args) {
        String filePath="src/main/resources/Modules.txt";
        File modulefile= new File(filePath);

        try {
            //opens the file for reading
            FileReader fileReader=new FileReader(modulefile);
            //read contents of the file
            BufferedReader reader= new BufferedReader(fileReader);

            String text = reader.readLine();

            while (text!=null){
                System.out.println(text);
                text= reader.readLine();
            }
            //System.out.println(text);
            reader.close();
            fileReader.close();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }



    }
}
