import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtils {
    public static final  String TIME_FORMATTER = "HH-mm";
    public static final DateTimeFormatter TIME_FORM = DateTimeFormatter.ofPattern(TIME_FORMATTER);

    public static final  String DATE_FORMATTER = "dd.MM.yyyy";
    public static final DateTimeFormatter DATE_FORM = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    private static Scanner scanner = new Scanner(System.in);

    public static String askString(String msg) {
        System.out.println(msg + " ");
        return scanner.next();
    }

    public static int askInt(String message) {
        System.out.println(message + ":");
        return scanner.nextInt();


    }

    public static LocalTime askTime(String message) {
        System.out.println(message + "  " + TIME_FORMATTER );
        String strTime = scanner.next();
        return  LocalTime.parse(strTime, TIME_FORM);

    }
    public static String timeToString(LocalTime time){
        return TIME_FORM.format(time);

    }
    public static String dateToString(LocalDate date){
        return DATE_FORM.format(date);

    }

    public static LocalDate askDate(String message) {
        System.out.println(message +"   "+  DATE_FORMATTER );
        String strDate = scanner.next();
        return  LocalDate.parse(strDate, DATE_FORM);

    }
}
