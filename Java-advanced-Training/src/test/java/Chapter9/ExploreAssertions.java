package Chapter9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import  static  org.junit.jupiter.api.Assertions.*;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/13
 **/

public class ExploreAssertions {
    static int num1,num2;
    @BeforeAll
    static  void setup(){
        num1=5;
        num2=3;

    }
    @Test
    void testsumoftwonumbers(){
        //Arrange
        int num1=3;
        int num2=2;
        int expected=6;
        //Act-Actual result
        int actual=num1+num2+1;
        //Assert-compare actual with expected results
        Assertions.assertEquals(expected,actual,"The sum of "+num1+"is" +expected);

    }
    @Test
    @DisplayName("Difference of two numbers")
    void testDiffoftwonumbers(){
        //Arrange
        int expected=4;
        //Act
        int actual =num1-num2;
        //Assert
        assertEquals(expected,actual,"The difference between "+num1+" and "+num2+"is "+expected);
    }

    @Test
    @DisplayName("Compute sum,difference and product")
    void testcomputationofTwoNumbers(){
        //Arrange
        int expectedSum=8;
        int expectedDiff=2;
        int expectedProduct=15;

        //actual
        int actualSum=num1+num2+1;//fail
        int actualDiff=num1-num2;
        int actualProduct=num1*num2+1;//fail

        //assert
        assertAll(
                () ->assertEquals(expectedDiff,actualDiff,"Difference"),
                ()->assertEquals(expectedSum,actualSum,"Sum"),
                ()-> assertEquals(expectedProduct,actualProduct,"Product")
        );
     }
}
