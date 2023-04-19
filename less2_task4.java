import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculatorWithLogging {
    private static final Logger logger = LogManager.getLogger(CalculatorWithLogging.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber, secondNumber;
        char operation;

        logger.info("Calculator is started");

        while (true) {
            logger.info("Enter first number:");
            firstNumber = scanner.nextDouble();

            logger.info("Enter second number:");
            secondNumber = scanner.nextDouble();

            logger.info("Enter operation (+, -, *, /):");
            operation = scanner.next().charAt(0);

            double result = 0;

            switch (operation) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    break;
                default:
                    logger.error("Invalid operation entered: " + operation);
                    System.out.println("Invalid operation. Try again.");
                    continue;
            }

            logger.info("Result: " + result);
            System.out.println("Result: " + result);

            logger.info("Do you want to continue? (y/n)");
            if (scanner.next().charAt(0) != 'y') {
                logger.info("Calculator is stopped");
                break;
            }
        }

        scanner.close();
    }
}
