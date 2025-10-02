package by.gstu.fitness;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== ФИТНЕС-КЛУБ: СИСТЕМА УПРАВЛЕНИЯ ===\\n");
        
        // Демонстрация работы Apache Commons Lang
        System.out.println("Демонстрация Apache Commons Lang:");
        String testString = "   Hello, Fitness Club!   ";
        System.out.println("Исходная строка: '" + testString + "'");
        System.out.println("Trim: '" + StringUtils.trim(testString) + "'");
        System.out.println("Upper case: '" + StringUtils.upperCase(testString) + "'");
        System.out.println("Содержит 'Fitness': " + StringUtils.containsIgnoreCase(testString, "fitness"));
        System.out.println();
        
        // Создаем тестовые данные
        Trainer john = new Trainer(1L, "John", "Yoga");
        Trainer alice = new Trainer(2L, "Alice", "Pilates");
        Trainer mike = new Trainer(3L, "Mike", "Boxing");
        
        Client client1 = new Client(1L, "Иван Иванов", "Premium", true);
        Client client2 = new Client(2L, "Петр Петров", "Standard", true);
        Client client3 = new Client(3L, "Сергей Сергеев", "Premium", false);
        Client client4 = new Client(4L, "Мария Сидорова", "VIP", true);
        
        Lesson yoga = new Lesson(1L, "Утренняя йога", john, "09:00");
        Lesson pilates = new Lesson(2L, "Вечерний пилатес", alice, "18:00");
        Lesson boxing = new Lesson(3L, "Бокс тренировка", mike, "17:00");
        Lesson yogaEvening = new Lesson(4L, "Вечерняя йога", john, "19:00");

        List<Client> clients = Arrays.asList(client1, client2, client3, client4);
        List<Trainer> trainers = Arrays.asList(john, alice, mike);
        List<Lesson> lessons = Arrays.asList(yoga, pilates, boxing, yogaEvening);

        FitnessService service = new FitnessService(clients, trainers, lessons);

        // Демонстрация работы методов
        System.out.println("1. Все занятия тренера John:");
        service.findLessonsByTrainerName("John").forEach(lesson -> 
            System.out.println("   - " + lesson));
        
        System.out.println("\\n2. Все клиенты с Premium абонементом:");
        service.filterClientsByMembership("Premium").forEach(client -> 
            System.out.println("   - " + client));
        
        System.out.println("\\n3. Активные клиенты с Premium абонементом:");
        service.filterActiveClientsByMembership("Premium").forEach(client -> 
            System.out.println("   - " + client));
            
        System.out.println("\\n4. Занятия тренера Alice:");
        service.findLessonsByTrainer(alice).forEach(lesson -> 
            System.out.println("   - " + lesson));
            
        System.out.println("\\n=== РАБОТА ПРИЛОЖЕНИЯ ЗАВЕРШЕНА ===");
    }
}
