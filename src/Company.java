import java.util.ArrayList;

public class Company {
    private String name;
    private String title;
    private String startDate;
    private String endDate;
    private ArrayList<String> jobDesc;


    public Company() {
        this.name = "";
        this.title = "";
        this.startDate = "";   //Date d1 = new Date(2000, 11, 21);
        this.endDate = "";     //Date d1 = new Date(2000, 11, 21);
        this.jobDesc = new ArrayList<String>();
    }

    public Company(String name, String title, String startDate, String endDate) {
        this.name = name;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobDesc = new ArrayList<String>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getJobDescSz() {
        return jobDesc.size();
    }

    public String getJobDesc(int idx) {
        return jobDesc.get(idx);
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc.add(jobDesc);
    }

    public String printInfo() {
        String msg = "";
        for (int i = 0; i < getJobDescSz(); i++) {
            msg = msg + getJobDesc(i) + "\n";
        }
        return getTitle() + "\n" +
               getName() + ", " +
               getStartDate() + " - " +
               getEndDate() + "\n" + msg;
    }
}
