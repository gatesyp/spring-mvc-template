package hello;

public class User {
    private final long id;
    private final String first;
    private final String last;
    private final String email;
    private final String age;
    private final Double height;
    private final Double weight;
    private final Double bmi;
    

    public User(long id, String first, String last, String email, String age, Double height, Double weight, Double bmi) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.email = email;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
    }

    public long getId() {
        return id;
    }
    public String getFirst() {
        return first;
    }
    public String getLast() {
        return last;
    }
    public String getEmail() {
        return email;
    }
    public String getAge() {
        return age;
    }
    public Double getWeight() {
        return weight;
    }
    public Double getHeight() {
        return height;
    }
    public Double getBmi() {
        return bmi;
    }
    
}
