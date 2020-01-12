/*
* В тексте найти все пары слов, из которых одно является обращением другого
*/
import java.util.ArrayList;
import java.util.Scanner;

public class LaboratoryWork1 {
    public static void main(String[] args) {

        System.out.print("Введите строку для поиска пар слов палиндромов: ");
        Scanner scanner = new Scanner(System.in);
        String str_in = scanner.nextLine().toLowerCase();
        String[] str_split = str_in.split(" ");
        ArrayList<Integer> overlap = new ArrayList<>();
        for (int i = 0; i < str_split.length; i++ ) {
            String str_invert = new StringBuffer(str_split[i]).reverse().toString();
            for (int j = 0; j < str_split.length; j++ ) {
                if (i != j && str_split[j].equals(str_invert)) {
                    overlap.add(i);
                    overlap.add(j);
                }
            }
        }
        if (overlap.isEmpty()) {
            System.out.println("Не найдено совпадений!");
        } else {
            System.out.println("Найдены совпадения:");
            for (int c = 0; c < overlap.size(); c+=2) {
                System.out.println(str_split[overlap.get(c)] + "[" + overlap.get(c) + "]" + " и "
                        + str_split[overlap.get(c + 1)]+ "[" + overlap.get(c + 1) + "]");
            }
        }
    }
}
