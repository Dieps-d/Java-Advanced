package Chapter9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/14
 **/

public class DataStore {

    //random numbers
    public static List<Integer> randomNumbers(){
        Random rnd= new Random();
        List<Integer> numbers= new ArrayList<>();

        int count=rnd.nextInt(5,12);//6
        for (int i = 0; i < count; i++) {
            numbers.add(rnd.nextInt(10,70));//6 nrs between 10 and 70

        }
        return  numbers;
    }
}
