import java.util.ArrayList;
import java.util.Scanner;

public class Wk3RoboResume {
    public static ArrayList<Person> allResume = new ArrayList<Person>();

    public static void main(String[] args) {
        Person person;
        Scanner keyboard = new Scanner(System.in);
        String msg;
        int yr;

        boolean cont = true;

        do {
            System.out.println("Entering a resume...");
            // get personal information
            person = new Person();

            System.out.println("Enter a name");
            msg = keyboard.nextLine();
            person.setName(msg);

            System.out.println("Enter an email");
            msg = keyboard.nextLine();
            person.setEmail(msg);

            System.out.println("Enter a phone number");
            msg = keyboard.nextLine();
            person.setPhone(msg);

            // get education information
            setEducation(keyboard, person);

            // get experiences
            setExperience(keyboard, person);

            // get skills
            setSkill(keyboard, person);


            allResume.add(person);

            System.out.println("Would you like to continue (Y/N)?");
            msg = keyboard.nextLine();
            if (msg.equalsIgnoreCase("n"))
                cont = false;

        } while (cont);

        for (Person resume : allResume) {
            System.out.println(resume.getinfo());
        }

    }


    public static void setEducation (Scanner keyBD, Person person){
        School schoolInfo;
        boolean cont =true;
        String msg;
        int yr;

        System.out.println("Please enter education information...or \"Q\" to quit");
        do {
            schoolInfo = new School();

            System.out.println("Enter name of school");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            schoolInfo.setName(msg);

            System.out.println("Enter year of graduation");
            //yr = keyBD.nextInt();
            //keyBD.nextLine();
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            //convert string into integer
            schoolInfo.setYear(Integer.parseInt(msg));

            System.out.println("Enter name of degree");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            schoolInfo.setDegree(msg);

            System.out.println("Enter name of major");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            schoolInfo.setMajor(msg);

            person.setEducation(schoolInfo);

            System.out.println("Would you like to add more education (Y/N)?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("n"))
                cont = false;

        } while(cont);
    }

    public static void setExperience(Scanner keyBD, Person person){
        Company coInfo;
        boolean cont = true;
        String msg;


        System.out.println("Please enter job experience... or \"Q\" to quit");
        do {
            coInfo = new Company();

            System.out.println("Enter the name of a company");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            coInfo.setName(msg);

            System.out.println("What was a title?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            coInfo.setTitle(msg);

            System.out.println("What was the start (mm/yyyy)?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            coInfo.setStartDate(msg);

            System.out.println("When was the last date (mm/yyyy)?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            coInfo.setEndDate(msg);

            System.out.println("Pleas enter job description followed by \"#\" or \"Q\" to quit");
            boolean moreJob = true;
            int idx;

            do {
                msg = keyBD.nextLine();
                if (msg.equalsIgnoreCase("q")) {
                    cont = false;
                    moreJob = false;
                    break;
                } else {
                    idx = msg.indexOf("#");
                    if (idx != -1) {
                        moreJob = false;
                        coInfo.setJobDesc(msg.substring(0, idx));

                    } else {
                        // add msg and continue to read next line

                        coInfo.setJobDesc(msg);

                    }
                }
            } while (moreJob);

            person.setExperience(coInfo);

            System.out.println("Would you like to add more job experience (Y/N)?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("n"))
                cont = false;

        } while(cont);
    }

    public static void setSkill(Scanner keyBD, Person person){
        Skill skillInfo;
        boolean cont = true;
        String msg;


        System.out.println("Please enter skills...or \"Q\" to quit");
        do {
            skillInfo = new Skill();

            System.out.println("What is a skill?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            skillInfo.setName(msg);

            System.out.println("What is the proficiency in " + msg + "?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            skillInfo.setProficiency(msg);

            person.setSkill(skillInfo);

            System.out.println("Would you like to add more skill(Y/N)?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("n"))
                cont = false;

        } while(cont);
    }
}
