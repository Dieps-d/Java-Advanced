package Chapter9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/14
 **/

public class DataDrivenTests {

    @ParameterizedTest(name="Test Exam Score - [{index}]: {arguments}")
    @ValueSource(doubles ={77.5, 63.8, 66.5, 57.8, 78.9})
    void testExamPassSCore(double examMark){

        boolean actual= examMark>=65;

      //  assertEquals(true,actual);

        assertTrue(actual, "Pass mark should be greater or 65 ["+ examMark+"]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Kate","Jane","Jessica","Morgan"})
    void testNameStartsWithJ(String name){
        assertTrue(name.startsWith("J"),name+ " doesnt start with J");
    }

    @ParameterizedTest
    @CsvSource(value={"Milk,20.00,50", "Bread,18.55,25", "cheese,55.35,17","eggs,80.55,60"})
    void testLowStockProducts(String product, double price, int qtyInStock){
        assertTrue(qtyInStock<50,"There is enough stock for ["+product+"] ");

        System.out.println("product = " + product + ", price = " + price + ", qtyInStock = " + qtyInStock);
    }

    @ParameterizedTest
    @MethodSource("randomNumbers")
    void testEvenNumbers(int number){
        assertTrue(number %2==0,number+" is not even");
    }
@ParameterizedTest
@MethodSource("Chapter9.DataStore#randomNumbers")
void testExternatRandomNumbers(int number){
        assertTrue(number >=45, number+ "is less than 45");

}
@ParameterizedTest
@CsvFileSource(files="src/test/resources/Student Results.csv",numLinesToSkip = 1)
void testExamMark(String module, int testMark){
        assertTrue(testMark>=65,"You have failed ["+module+"] with ["+testMark+"]. you need 65 to pass");
}
   //random numbers
    static List<Integer> randomNumbers(){
        Random rnd= new Random();
        List<Integer> numbers= new ArrayList<>();

        int count=rnd.nextInt(5,12);//6
        for (int i = 0; i < count; i++) {
            numbers.add(rnd.nextInt(10,70));//6 nrs between 10 and 70

        }
        return  numbers;
    }
}

