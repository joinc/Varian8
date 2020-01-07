/*
* В тексте найти все пары слов, из которых одно является обращением другого
*/
import java.util.Scanner;

public class LaboratoryWork1 {
    public static void main(String[] args) {

        System.out.print("Введите строку для поиска пар слов палиндромов: ");
        Scanner scanner = new Scanner(System.in);
        String str_in = scanner.nextLine().toLowerCase();
        String[] str_split = str_in.split(" ");

        for (String s1 : str_split) {
            String s_invert = new StringBuffer(s1).reverse().toString();
            for (String s2 : str_split) {
                if (s2.equals(s_invert)) {
                    System.out.println("Найдено совпадение: " + s1 + " и " + s2);
                }
            }
        }
    }
}
