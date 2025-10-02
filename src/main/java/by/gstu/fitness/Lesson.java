package by.gstu.fitness;

public class Lesson {
    private Long id;
    private String name;
    private Trainer trainer;
    private String schedule;

    public Lesson(Long id, String name, Trainer trainer, String schedule) {
        this.id = id;
        this.name = name;
        this.trainer = trainer;
        this.schedule = schedule;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Trainer getTrainer() { return trainer; }
    public String getSchedule() { return schedule; }
    
    @Override
    public String toString() {
        return name + " с " + trainer.getName() + " в " + schedule;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Lesson lesson = (Lesson) obj;
        return id != null && id.equals(lesson.id);
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
