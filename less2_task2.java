import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        Logger logger = Logger.getLogger("BubbleSortLog");
        FileHandler fh;
        
        try {
            // Задаем имя и формат лог-файла
            fh = new FileHandler("BubbleSortLog.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.addHandler(fh);
            
            logger.info("Original Array: " + Arrays.toString(arr));

            // Реализация алгоритма сортировки пузырьком
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                logger.info("Iteration " + (i + 1) + ": " + Arrays.toString(arr));
            }
            
            logger.info("Sorted Array: " + Arrays.toString(arr));
            fh.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
