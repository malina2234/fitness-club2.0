package by.gstu.fitness;

public class Client {
    private Long id;
    private String name;
    private String membershipType;
    private boolean active;

    public Client(Long id, String name, String membershipType, boolean active) {
        this.id = id;
        this.name = name;
        this.membershipType = membershipType;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMembershipType() { return membershipType; }
    public boolean isActive() { return active; }
    
    @Override
    public String toString() {
        return name + " (" + membershipType + ", активный: " + active + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return id != null && id.equals(client.id);
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
