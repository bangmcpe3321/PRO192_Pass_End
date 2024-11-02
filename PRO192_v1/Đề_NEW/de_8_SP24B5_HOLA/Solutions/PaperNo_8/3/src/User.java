public class User {
    private String name;
    private int status;

    // Constructors
    public User() {
        this.name = "";
        this.status = 0;
    }

    public User(String name, int status) {
        this.name = name;
        this.status = status;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
