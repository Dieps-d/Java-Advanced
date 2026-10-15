package Chapter10;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/15
 **/

public class ReadFromExcel {
    public static void main(String[] args) {
        String filepath="src/main/resources/Cities.xlsx";
        try {
            FileInputStream fileinput=new FileInputStream(filepath);

            XSSFWorkbook workbook=new XSSFWorkbook(fileinput);
            XSSFSheet sheet= workbook.getSheetAt(0);

            for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
                //row
                Row row=sheet.getRow(i);
                for (int col = 0; col < row.getLastCellNum(); col++) {
                    Cell cell=row.getCell(col);
                    System.out.print(cell +"\t");

                }
                System.out.println();
            }
            fileinput.close();
            workbook.close();


        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
