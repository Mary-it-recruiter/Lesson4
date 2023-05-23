
//
//        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
//        Отсортировать по убыванию популярности Имени.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                "Иван Мечников", "Петр Петин", "Иван Ежов"
        );

        Map<String, Integer> nameCounts = new HashMap<>();
        for (String employee : employees) {
            String firstName = employee.split(" ")[0];
            nameCounts.put(firstName, nameCounts.getOrDefault(firstName, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedNameCounts = new ArrayList<>(nameCounts.entrySet());
        Collections.sort(sortedNameCounts, Collections.reverseOrder(Map.Entry.comparingByValue()));

        for (Map.Entry<String, Integer> entry : sortedNameCounts) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
