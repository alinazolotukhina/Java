import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Программа завершилась");
                break;
            } else if (input.equalsIgnoreCase("print")) {
                printStack(stack);
            } else if (input.equalsIgnoreCase("revert")) {
                revertStack(stack);
            } else {
                stack.push(input);
            }
        }
    }

    private static void printStack(Stack<String> stack) {
        System.out.print("[");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i));
            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static void revertStack(Stack<String> stack) {
        if (stack.isEmpty()) {
            System.out.println("Ошибка!");
        } else {
            stack.pop();
        }
    }
}
