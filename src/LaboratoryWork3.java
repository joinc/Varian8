/*
* Задать два стека, поменять информацию местами.
 */
import java.util.Random;
import java.util.Stack;

public class LaboratoryWork3 {
    public static void main(String[] args) {

        Random random = new Random();
        int sizeStack = random.nextInt(10) + 5;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < sizeStack; i++) {
            stack1.push(random.nextInt(50));
            stack2.push(random.nextInt(50));
        }
        System.out.println("Первый стек (начальный): " + stack1);
        System.out.println("Второй стек (начальный): " + stack2);
        Stack<Integer> stack1buffer = new Stack<>();
        Stack<Integer> stack2buffer = new Stack<>();
        while (!stack1.empty() || !stack2.empty()) {
            stack1buffer.push(stack1.pop());
            stack2buffer.push(stack2.pop());
        }
        while (!stack1buffer.empty() || !stack2buffer.empty()) {
            stack1.push(stack2buffer.pop());
            stack2.push(stack1buffer.pop());
        }
        System.out.println("Первый стек (поменненый): " + stack1);
        System.out.println("Второй стек (поменненый): " + stack2);
    }
}
