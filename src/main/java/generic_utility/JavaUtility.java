package generic_utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
    public static double generateRandomNumber(){
        double randouble  = Math.random();
        double random =randouble*10000;
        int ran = (int) random;
        return ran;
    }

    public static String getCurrentDateTime(){
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss_ddMMyyyy"));
        return date;
    }
}
