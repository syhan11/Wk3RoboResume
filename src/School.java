public class School {
    private String name;
    private int year;
    private String degree;
    private String major;

    public School() {
        this.name = "";
        this.year = 0;
        this.degree = "";
        this.major = "";
    }

    public School(String name, int year, String degree, String major) {
        this.name = name;
        this.year = year;
        this.degree = degree;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String printInfo() {
        return getDegree() + " in " +
               getMajor() + ",\n" +
               getName() + ", " +
               getYear() + "\n";
    }
}
