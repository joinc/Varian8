/*
 * Составить регулярное выражение, определяющее является ли заданная строка IP адресом, записанным в десятичном виде.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LaboratoryWork2 {
    public static void main(String[] args) {

        System.out.print("Введите ip-адрес для проверки: ");
        Scanner scanner = new Scanner(System.in);
        String str_in = scanner.nextLine();
        Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\" +
                ".([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        Matcher matcher = pattern.matcher(str_in);
        if (matcher.matches()) {
            System.out.println("Строка " + str_in + " является ip-адресом.");
        } else {
            System.out.println("Строка " + str_in + " не является ip-адресом.");
        }
    }
}
