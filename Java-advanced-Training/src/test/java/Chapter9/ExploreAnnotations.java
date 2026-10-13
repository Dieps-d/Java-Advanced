package Chapter9;

import org.junit.jupiter.api.*;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/13
 * this class demonstrates the use of different annotations from JUnit5
 * <ol>
 *     <li>Sanity Test: Test for basic functionality after fix, change or addition of a feature</li>
 *     <li>Regression test: Test unchanged parts of the system</li>
 *     <li>Integration test: Test individual units when they are connected to internal or external components</li>
 * </ol>
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExploreAnnotations {


    @BeforeAll
    static void setup(){
        System.err.println("setup");
    }

    @AfterAll
    static void tearDown(){
        System.err.println("Realising all resources");
    }

    @BeforeEach
    void beforeAnyTest(){
        System.out.println("Before a test case");
    }
    @AfterEach
    void afterEachTest(){
        System.out.println("After each test");
    }


    @Test
    @DisplayName("TC1- First Test")
    @Order(1)
    @Tag("Sanity")
    void firstTest(){
        System.out.println("-----First Test Method------");
    }

    @Test
    @DisplayName("TC2- Second Test")
    @Order(4)
    @Tag("integration")
    @Tag("Regression")
    void secondTest(){
        System.out.println("_____Second Test Method-----");
    }
    @Test
    @DisplayName("TC3- Third Test")
    @Order(2)
    @Tag("Sanity")
    void ThirdTest(){
        System.out.println("_____Third Test Method-----");
    }
    @Test
    @DisplayName("TC4- Sum Test")
    @Order(3)
    @Tag("Regression")
    void testsum(){
        //Arrange-define Inputs and expected results
        int num1=6;
        int num2=3;
        int expectedsum=9;
        System.out.println("Test Sum");

    }
}
