package by.gstu.fitness;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FitnessService {
    private List<Client> clients;
    private List<Trainer> trainers;
    private List<Lesson> lessons;

    public FitnessService(List<Client> clients, List<Trainer> trainers, List<Lesson> lessons) {
        this.clients = new ArrayList<>(clients);
        this.trainers = new ArrayList<>(trainers);
        this.lessons = new ArrayList<>(lessons);
    }

    // Поиск занятий по тренеру
    public List<Lesson> findLessonsByTrainer(Trainer trainer) {
        return lessons.stream()
                .filter(lesson -> lesson.getTrainer().equals(trainer))
                .collect(Collectors.toList());
    }

    // Поиск занятий по имени тренера
    public List<Lesson> findLessonsByTrainerName(String trainerName) {
        return lessons.stream()
                .filter(lesson -> lesson.getTrainer().getName().equalsIgnoreCase(trainerName))
                .collect(Collectors.toList());
    }

    // Фильтрация клиентов по типу абонемента
    public List<Client> filterClientsByMembership(String membershipType) {
        return clients.stream()
                .filter(client -> client.getMembershipType().equalsIgnoreCase(membershipType))
                .collect(Collectors.toList());
    }

    // Фильтрация активных клиентов по типу абонемента
    public List<Client> filterActiveClientsByMembership(String membershipType) {
        return clients.stream()
                .filter(client -> client.getMembershipType().equalsIgnoreCase(membershipType) 
                               && client.isActive())
                .collect(Collectors.toList());
    }
}
