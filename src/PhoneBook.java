import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    private final Map<String, String> phoneBook = new HashMap<>();

    public void addNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine().trim();
        System.out.println("Введите номер телефона:");
        String phoneNumber = scanner.nextLine().trim();

        if (phoneBook.containsKey(lastName)) {
            String existingNumbers = phoneBook.get(lastName);
            existingNumbers += ", " + phoneNumber;
            phoneBook.put(lastName, existingNumbers);
        } else {
            phoneBook.put(lastName, phoneNumber);
        }
    }

    public void printAll() {
        for (String lastName : phoneBook.keySet()) {
            String phoneNumbers = phoneBook.get(lastName);
            System.out.println(lastName + ": " + phoneNumbers);
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("Введите 1 для добавления номера, 2 для вывода всего:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (true) {
            if (choice == 1) {
                phoneBook.addNumber();
            } else if (choice == 2) {
                phoneBook.printAll();
            } else {
                System.out.println("Неверный выбор, попробуйте еще раз.");
            }

            System.out.println("Введите 1 для добавления номера, 2 для вывода всего:");
            choice = scanner.nextInt();
        }
    }
}