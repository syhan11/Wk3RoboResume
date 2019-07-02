import java.util.ArrayList;

public class Person {
    private String name;
    private String email;
    private String phone;
    private ArrayList<School> education;
    private ArrayList<Company> experience;
    private ArrayList<Skill> skill;

    public Person() {
        this.name = null;
        this.email = null;
        this.phone = null;
        this.education = new ArrayList<School>();
        this.experience = new ArrayList<Company>();
        this.skill = new ArrayList<Skill>();
    }

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.education = new ArrayList<School>();
        this.experience = new ArrayList<Company>();
        this.skill = new ArrayList<Skill>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean checkEmailFormat(String phone) {
        if (phone.contains("@") & (phone.contains(".com")))
            return true;
        else
            return false;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean checkPhoneFormat(String phone) {
        boolean found = true;

        /*
         * it will return true if
         *      string is 10 characters long,
         *      string does not contain any dash (-),
         *      and string only contains a number
         */

        if (phone.length() != 10)
            found = false;
        else if (phone.contains("-"))
            found = false;
        else {
            try {
                int num = Integer.parseInt(phone);
            } catch (NumberFormatException e) {
                found = false;
            }
        }

        return found;
    }

    public String printPhone() {
        /*
         * Format phone number
         */
        String phoneMsg = "", phone = getPhone();

        if ((phone != null) && (phone.length() == 10))
            phoneMsg = "(" + phone.substring( 0,3 ) + ") " +
                    phone.substring( 3,6 ) + "-" + phone.substring( 6,10 );

        return phoneMsg;
    }

    public int getEducationSz() {
        return this.education.size();
    }

    public School getEducation(int idx) {
        return this.education.get(idx);
    }

    public void setEducation(School education) {
        this.education.add(education);
    }

    public int getExperienceSz() {
        return experience.size();
    }
    public Company getExperience(int idx) {
        return experience.get(idx);
    }

    public void setExperience(Company experience) {
        this.experience.add(experience);
    }

    public int getSkillSz() {
        return skill.size();
    }
    public Skill getSkill(int idx) {
        return skill.get(idx);
    }

    public void setSkill(Skill skill) {
        this.skill.add(skill);
    }

    public String getinfo(){
        String eduInfo = "", expInfo = "", skillInfo = "", info;
        School tmpSchool;
        Company tmpCo;
        Skill tmpSkill;

        for (int idx = 0; idx < getEducationSz(); idx++) {
            tmpSchool = getEducation(idx);
            eduInfo = eduInfo + tmpSchool.printInfo() + "\n";
        }

        for (int idx = 0; idx < getExperienceSz(); idx++) {
            tmpCo = getExperience(idx);
            expInfo = expInfo + tmpCo.printInfo() + "\n";
        }

        for (int idx = 0; idx < getSkillSz(); idx++) {
            tmpSkill = getSkill(idx);
            skillInfo = skillInfo + tmpSkill.printInfo() + "\n";
        }


        info = getName() + "\n" +
               getEmail() + "\n" +
               printPhone() + "\n" +
               "Education\n" + eduInfo +
               "Experience\n" + expInfo +
               "Skills\n" + skillInfo;

        return info;
    }
}
