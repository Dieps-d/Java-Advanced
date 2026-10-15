package Chapter10;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/15
 **/

public class WitetoExcel {
    public static void main(String[] args) {

        String filepath="src/main/resources/Cities.xlsx";


        try {
            OutputStream filewriter= new FileOutputStream(filepath);

            //create a workbook object
            XSSFWorkbook workbook=new XSSFWorkbook();
            //Create a spreadsheet inside the workbook
            XSSFSheet sheet= workbook.createSheet("Cities");
            //Create a header row
            XSSFRow header= sheet.createRow(0);//row at position 0
            header.createCell(0).setCellValue("City");
            header.createCell(1).setCellValue("Population");
            //Create row1
            XSSFRow rowl= sheet.createRow(1);//row at position 0
            rowl.createCell(0).setCellValue("Centurion");
            rowl.createCell(1).setCellValue(500000);
            //create row2
            XSSFRow row2= sheet.createRow(2);//row at position 0
            row2.createCell(0).setCellValue("Midrand");
            row2.createCell(1).setCellValue(500000);

            workbook.write(filewriter);
            filewriter.close();
            workbook.close();


        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
