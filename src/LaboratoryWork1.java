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
        int[] overlap = new int[str_split.length];
        int count = 0;

        for (int i = 0; i < str_split.length; i++ ) {
            String str_invert = new StringBuffer(str_split[i]).reverse().toString();
            for (int j = 0; j < str_split.length; j++ ) {
                if (i != j && str_split[j].equals(str_invert)) {
                    Boolean flag = true;
                    for (int c = 0; c < count; c++) {
                        if (i == overlap[c]) {
                            flag = false;
                        }
                    }
                    if ((flag) && (count < str_split.length)) {
                        overlap[count] = i;
                        count++;
                        overlap[count] = j;
                        count++;
                    }
                }
            }
        }
        if (count > 0) {
            System.out.println("Найдены совпадения:");
            for (int c = 0; c < count; c+=2) {
                System.out.println(str_split[overlap[c]] + "[" + overlap[c] + "]" + " и " + str_split[overlap[c + 1]]+ "[" + overlap[c + 1] + "]");
            }
        } else {
            System.out.println("Не найдено совпадений!");
        }
    }
}
