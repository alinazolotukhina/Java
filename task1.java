import java.util.Scanner;

public class TriangleFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        int triangle = triangleNumber(n);
        long factorial = factorial(n);

        System.out.println("The " + n + "-th triangle number is: " + triangle);
        System.out.println(n + "! = " + factorial);
    }

    // Вычисляет n-ое треугольное число (сумма чисел от 1 до n)
    public static int triangleNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // Вычисляет n! (произведение чисел от 1 до n)
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
