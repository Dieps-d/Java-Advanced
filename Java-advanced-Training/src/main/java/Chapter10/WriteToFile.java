package Chapter10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/15
 **/

public class WriteToFile {
    public static void main(String[] args) {
        //path
        String filepath="src/main/resources/Hobbies.txt";
        //create a file resource
        File hobbiesFile=new File(filepath);

        try {
            PrintStream pen= new PrintStream(hobbiesFile);
               // hobbiesFile.createNewFile();
                pen.println("Tennis");
                pen.println("Soccer");
                pen.println("pool");

                pen.append("okay cool");
            pen.close();

        } catch (FileNotFoundException ex) {
            System.err.println("File not found..."+ex.getMessage());
        } catch(IOException ex){
            System.err.println("Cannot write to file..."+ex.getMessage());

        }
        System.out.println("Abs path: "+hobbiesFile.getAbsolutePath());
        System.out.println("path: "+hobbiesFile.getPath());
        System.out.println("Parent: "+hobbiesFile.getParent());
        System.out.println("Last Modified: " + hobbiesFile.lastModified());



    }
}
