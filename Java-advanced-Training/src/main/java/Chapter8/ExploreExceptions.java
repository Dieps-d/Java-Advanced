package Chapter8;

import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/13
 **/

public class ExploreExceptions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int numerator, denominator;
        double quotient;

        try {

            System.out.print("Enter your name...");
            name = sc.next();
            System.out.print("Enter numerator...");
            numerator = sc.nextInt();
            System.out.print("Enter denominator...");
            denominator = sc.nextInt();

            name="Joy";
            quotient = numerator / denominator;

            System.out.format("""
                    Name            :   %s
                    The last letter of your name( %s ) is: %s
                    Numeartor       :   %d
                    denominator     :   %d
                    Quotent         :   %.2f""", name,name.substring(4), numerator, denominator, quotient);
        } catch(InputMismatchException ex){
            System.err.println("Incorrect input type. "+ ex.getCause());

        }catch(ArithmeticException ex){
            System.err.println("Cannot divide by zero");
        }catch(StringIndexOutOfBoundsException ex){
            System.err.println("The last letter of your name should be( "+ "y" + ")");
        }
    }

}
