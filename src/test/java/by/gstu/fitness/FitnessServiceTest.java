package by.gstu.fitness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FitnessServiceTest {

    private FitnessService fitnessService;
    private Trainer john;
    private Trainer alice;
    private Client client1, client2, client3;
    private Lesson yoga, pilates, boxing;

    @BeforeEach
    public void setUp() {
        // Создаем тестовые данные
        john = new Trainer(1L, "John", "Yoga");
        alice = new Trainer(2L, "Alice", "Pilates");

        client1 = new Client(1L, "Иван Иванов", "Premium", true);
        client2 = new Client(2L, "Петр Петров", "Standard", true);
        client3 = new Client(3L, "Сергей Сергеев", "Premium", false);

        yoga = new Lesson(1L, "Утренняя йога", john, "09:00");
        pilates = new Lesson(2L, "Вечерний пилатес", alice, "18:00");
        boxing = new Lesson(3L, "Бокс тренировка", john, "17:00");

        List<Client> clients = Arrays.asList(client1, client2, client3);
        List<Trainer> trainers = Arrays.asList(john, alice);
        List<Lesson> lessons = Arrays.asList(yoga, pilates, boxing);

        fitnessService = new FitnessService(clients, trainers, lessons);
    }

    @Test
    public void testFindLessonsByTrainer() {
        List<Lesson> johnLessons = fitnessService.findLessonsByTrainer(john);
        assertEquals(2, johnLessons.size(), "Должно быть 2 занятия у John");
        assertTrue(johnLessons.contains(yoga));
        assertTrue(johnLessons.contains(boxing));
    }

    @Test
    public void testFindLessonsByTrainerName() {
        List<Lesson> aliceLessons = fitnessService.findLessonsByTrainerName("Alice");
        assertEquals(1, aliceLessons.size(), "Должно быть 1 занятие у Alice");
        assertEquals(pilates, aliceLessons.get(0));
    }

    @Test
    public void testFilterClientsByMembership() {
        List<Client> premiumClients = fitnessService.filterClientsByMembership("Premium");
        assertEquals(2, premiumClients.size(), "Должно быть 2 клиента с Premium");
        assertTrue(premiumClients.contains(client1));
        assertTrue(premiumClients.contains(client3));
    }

    @Test
    public void testFilterActiveClientsByMembership() {
        List<Client> activePremiumClients = fitnessService.filterActiveClientsByMembership("Premium");
        assertEquals(1, activePremiumClients.size(), "Должен быть 1 активный клиент с Premium");
        assertEquals(client1, activePremiumClients.get(0));
    }

    @Test
    public void testNoLessonsForUnknownTrainer() {
        Trainer unknownTrainer = new Trainer(99L, "Unknown", "None");
        List<Lesson> lessons = fitnessService.findLessonsByTrainer(unknownTrainer);
        assertTrue(lessons.isEmpty(), "Не должно быть занятий у неизвестного тренера");
    }
}
