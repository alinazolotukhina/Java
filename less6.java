import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Notebook {
    private String brand;
    private int ram;
    private int storage;
    private String operatingSystem;
    private String color;

    public Notebook(String brand, int ram, int storage, String operatingSystem, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        List<Notebook> notebooks = createNotebooks(); // Создание множества ноутбуков

        // Запрос критериев фильтрации от пользователя
        Map<Integer, Object> filters = getFiltersFromUser();

        // Фильтрация и вывод ноутбуков
        List<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);
        if (filteredNotebooks.isEmpty()) {
            System.out.println("Ноутбуки, удовлетворяющие условиям фильтра, не найдены.");
        } else {
            System.out.println("Результаты фильтрации:");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(notebook.getBrand() + " - " + notebook.getOperatingSystem());
            }
        }
    }

    private static List<Notebook> createNotebooks() {
        // Создание и инициализация множества ноутбуков
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("Brand1", 8, 500, "OS1", "Red"));
        notebooks.add(new Notebook("Brand2", 16, 1000, "OS2", "Blue"));
        notebooks.add(new Notebook("Brand3", 16, 500, "OS3", "Black"));
        notebooks.add(new Notebook("Brand4", 8, 1000, "OS2", "Silver"));
        notebooks.add(new Notebook("Brand5", 32, 2000, "OS4", "Red"));
        return notebooks;
    }

    private static Map<Integer, Object> getFiltersFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> filters = new HashMap<>();
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объём ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        int criterion = scanner.nextInt();
        scanner.nextLine(); // Считывание символа новой строки после ввода цифры

        Object filterValue;
        switch (criterion) {
            case 1:
                System.out.print("Введите минимальное значение ОЗУ: ");
                int ram = scanner.nextInt();
                filterValue = ram;
                break;
            case 2:
                System.out.print("Введите минимальное значение объёма ЖД: ");
                int storage = scanner.nextInt();
                filterValue = storage;
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                String os = scanner.nextLine();
                filterValue = os;
                break;
            case 4:
                System.out.print("Введите цвет: ");
                String color = scanner.nextLine();
                filterValue = color;
                break;
            default:
                System.out.println("Некорректный выбор критерия.");
                return filters;
        }

        filters.put(criterion, filterValue);
        return filters;
    }

    private static List<Notebook> filterNotebooks(List<Notebook> notebooks, Map<Integer, Object> filters) {
        List<Notebook> filteredNotebooks = new ArrayList<>();

        for (Notebook notebook : notebooks) {
            boolean isMatch = true;
            for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
                int criterion = entry.getKey();
                Object filterValue = entry.getValue();

                switch (criterion) {
                    case 1:
                        if (notebook.getRam() < (int) filterValue) {
                            isMatch = false;
                        }
                        break;
                    case 2:
                        if (notebook.getStorage() < (int) filterValue) {
                            isMatch = false;
                        }
                        break;
                    case 3:
                        if (!notebook.getOperatingSystem().equals(filterValue)) {
                            isMatch = false;
                        }
                        break;
                    case 4:
                        if (!notebook.getColor().equals(filterValue)) {
                            isMatch = false;
                        }
                        break;
                    default:
                        System.out.println("Некорректный выбор критерия.");
                        break;
                }

                if (!isMatch) {
                    break; // Прекратить проверку остальных критериев, если не соответствует текущий
                }
            }

            if (isMatch) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}
