public class Wood {
    private String source;
    private int year;

    // Constructors
    public Wood() {
        this.source = "";
        this.year = 0;
    }

    public Wood(String source, int year) {
        this.source = source;
        this.year = year;
    }

    // Getter methods
    public String getSource() {
        if (source.length() > 0) {
            return source.substring(0, source.length() - 1);
        } else {
            return "";
        }
    }

    public int getYear() {
        return year;
    }

    // Setter method
    public void setYear(int year) {
        this.year = year;
    }
}
