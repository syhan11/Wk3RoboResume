import java.util.ArrayList;
import java.util.Scanner;

public class Wk3RoboResume {
    public static ArrayList<Person> allResume = new ArrayList<Person>();

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String msg;
        String sysMsg = "\n>>>>> MAIN MENU <<<<<\nEnter your option or \"Q\" to quit.\n" +
                        "\t1. Enter a new resume\n" +
                        "\t2. Edit a resume\n" +
                        "\t3. Search candidates\n" +
                        "\t4. Print resumes";
        boolean cont = true;

        //initialized some data for testing
        initResume();


        System.out.println("Welcome to the RoboResume!\n" + sysMsg);
        do {
            msg = keyboard.nextLine();
            switch (msg) {
                case "1":
                    enterResume(keyboard);
                    break;

                case "2":
                    editResume(keyboard);
                    break;

                case "3":
                    searchResume(keyboard);
                    break;

                case "4":
                    printAllResume();
                    break;

                case "q":
                case "Q":
                    cont = false;
                    break;

                default:
                    System.out.println("Unknown option!");
            }

            if (cont)
                System.out.println(sysMsg);

        } while (cont);

    }

    public static void initResume() {
        Person person;
        School edu;
        Skill skill;
        Company expr;


        person = new Person("John J Jingleheimer-Schmidt", "jjjschmidt@gmai.com", "1234567777");

        edu = new School("University of Maryland", 2002, "BS", "Psychology");
        person.setEducation(edu);

        edu = new School("Johns Hopkings University", 2005, "MS", "Software Engineering");
        person.setEducation(edu);

        expr = new Company("Amtrak", "Software Developer II", "June 2015", "Present");
        expr.setJobDesc("Lorem Ipsum");
        expr.setJobDesc("Gaudeamos Igitur Iuvenes Dum somos");
        person.setExperience(expr);

        expr = new Company("Amtrak", "Software Developer", "June 2015", "Present");
        expr.setJobDesc("Lorem Ipsum1");
        expr.setJobDesc("Gaudeamos Igitur Iuvenes Dum somos1");
        person.setExperience(expr);

        skill = new Skill("java", "advanced");
        person.setSkill(skill);

        skill = new Skill("c++", "expert");
        person.setSkill(skill);

        skill = new Skill("python", "novice");
        person.setSkill(skill);

        allResume.add(person);

        person = new Person("Jane doe", "jane@gmail.com", "3456777700");

        edu = new School("University of Maryland", 2008, "BS", "Computer Science");
        person.setEducation(edu);

        expr = new Company("Google", "Intern", "June 2019", "Present");
        expr.setJobDesc("Intern");
        person.setExperience(expr);

        skill = new Skill("java", "advanced");
        person.setSkill(skill);

        skill = new Skill("c++", "expert");
        person.setSkill(skill);

        allResume.add(person);

        person = new Person("Bill Gates", "bill@gmail.com", "9999999999");

        edu = new School("MIT", 1980, "BS", "Computer Science");
        person.setEducation(edu);

        allResume.add(person);

    }


    public static void enterResume(Scanner keyBD) {
        boolean cont = true, found;
        Person person;
        String msg;
        int yr;

        /*
         * it will add a resume into ArrayList of resumes
         * until the user is ready to quit
         */
        do {
            found = false;
            System.out.println(">>>>> NEW RESUME <<<<<");

            // get personal information
            person = new Person();

            System.out.println("Enter a name");
            msg = keyBD.nextLine();
            person.setName(msg);

            do {
                // check for valid email address
                System.out.println("Enter an email address");
                msg = keyBD.nextLine();

                // looks for "@" and ".com"
                if (person.checkEmailFormat(msg)) {
                    person.setEmail(msg);
                    found = true;
                }
                else
                    System.out.println("Not a proper email address.  Try again.");
            } while (!found);

            found = false;
             do {
                 // looks for phone number without any "-"
                 System.out.println("Enter a phone number without any \"-\"");
                 msg = keyBD.nextLine();
                 if (person.checkPhoneFormat(msg)) {
                    person.setPhone(msg);
                    found = true;
                 }
                 else
                    System.out.println("Not a proper phone number.  Try again.");
             } while (!found);

            // get education information
            setEducation(keyBD, person);

            // get experiences
            setExperience(keyBD, person);

            // get skills
            setSkill(keyBD, person);

            // add newly entered information to the all resume array list
            allResume.add(person);

            System.out.println("Would you like to continue (Y/N)?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("n"))
                cont = false;

        } while (cont);

    }


    public static void editResume(Scanner keyBD){

        String sysMsg1 = "Enter your option or \"Q\" to quit.\n" +
                "\t1. Search by a name\n" +
                "\t2. Search by a phone number\n" +
                "\t3. Search by an email address";

        String option, msg, newInfo;
        boolean cont = true, found = false;
        Person candidate;

        System.out.println(">>>>> EDITING A RESUME <<<<<\n");

        do {
            // need to search for a resume to edit
            System.out.println(sysMsg1);
            option = keyBD.nextLine();
            switch (option) {
                case "1": // search by name
                    System.out.println("Enter a name to search");
                    msg = keyBD.nextLine();
                    candidate = searchResumeByName(msg);
                    if (candidate != null) {
                        modifyResume(keyBD, candidate);
                    }
                    else
                        System.out.println(msg + " not found!");

                    break;

                case "2": // search by phone number
                    found = false;
                    System.out.println("Enter a phone number without any \"-\" to search");
                    msg = keyBD.nextLine();
                    candidate = searchResumeByPhone(msg);
                    if (candidate != null) {
                        modifyResume(keyBD, candidate);
                    }
                    else
                        System.out.println(msg + " not found!");

                    break;

                case "3":     // search by an email address
                    found = false;
                    System.out.println("Enter an email address to search");
                    msg = keyBD.nextLine();
                    candidate = searchResumeByEmail(msg);
                    if (candidate != null) {
                        modifyResume(keyBD, candidate);
                    }
                    else
                        System.out.println(msg + " not found!");


                    break;

                case "q":
                case "Q":   // terminate the search
                    cont = false;
                    break;

                default:
                    System.out.println("Unknown option!");
            }

        } while (cont);

    }

    public static void searchResume(Scanner keyBD){
        String sysMsg1 = "Enter a skill you are searching for or type \"Q\" to quit";

        String option, msg;
        Person candidate;
        boolean cont = true;
        Recruiter headhunter;

        System.out.println(">>>>> SEARCHING FOR CANDIDATES <<<<<");

        do {
            candidate = null;
            msg = null;
            System.out.println(sysMsg1);
            option = keyBD.nextLine();
            if (option.equalsIgnoreCase("q")) {
                cont = false;
            }
            else{
                headhunter = new Recruiter(option, allResume);
                System.out.println("\nCandidates with " + headhunter.getSkillSet() + " are:");
                System.out.println(headhunter.printCandidates());
            }


        } while (cont);


    }


    public static void printAllResume () {

        for (Person resume : allResume) {
            System.out.println("\n==========================================");
            System.out.println(resume.getAllInfo());
        }

    }


    public static void setEducation (Scanner keyBD, Person person){
        School schoolInfo;
        boolean cont =true, found = true;
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
            msg = keyBD.nextLine();
            if (msg == null) {
                msg = "0";
            }
            else if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }

            //convert string into integer
            try {
                long num = Integer.parseInt(msg);
            } catch (NumberFormatException e) {
                found = false;
            }
            if (found)
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

            System.out.println("What was the start (month year)?");
            msg = keyBD.nextLine();
            if (msg.equalsIgnoreCase("q")) {
                cont = false;
                break;
            }
            coInfo.setStartDate(msg);

            System.out.println("When was the last date (month year)?");
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



    public static Person searchResumeByName(String name) {
        boolean found = false;
        Person resume;
        int idx = 0;

        for (Person tmp : allResume) {
            if (name.equalsIgnoreCase(tmp.getName())) {
                found = true;
                break;
            }
            idx++;
        }

        if (found)
            resume = allResume.get(idx);
        else
            resume = null;

        return resume;
    }

    public static Person searchResumeByPhone(String phone) {
        boolean found = false;
        Person item;
        int idx = 0;

        if (Person.checkPhoneFormat(phone)) {
            for (Person tmp : allResume) {
                if (phone.equalsIgnoreCase(tmp.getPhone())) {
                    found = true;
                    break;
                }
                idx++;
            }
        }
        if (found)
            item = allResume.get(idx);
        else
            item = null;

        return item;
    }

    public static Person searchResumeByEmail(String email) {
        boolean found = false;
        Person resume;
        int idx = 0;

        if (Person.checkEmailFormat(email)) {
            for (Person tmp : allResume) {
                if (email.equalsIgnoreCase(tmp.getEmail())) {
                    found = true;
                    break;
                }
                idx++;
            }
        }
        if (found)
            resume = allResume.get(idx);
        else
            resume = null;

        return resume;

    }

    public static void modifyResume(Scanner keyBD, Person candidate){
        String sysMsg = "\nEnter your option or \"Q\" to quit.\n" +
                        "\t1. Modify a name\n" +
                        "\t2. Modify a phone number\n" +
                        "\t3. Modify an email address";

        String newInfo;
        boolean found = false;

        System.out.println("\nYou've selected " + candidate.getPersonalInfo() + "\n");
        System.out.println(sysMsg);
        newInfo = keyBD.nextLine();
        switch (newInfo) {
            case "1":
                System.out.println("Enter a new name");
                newInfo = keyBD.nextLine();
                candidate.setName(newInfo);
                break;

            case "2":
                do {
                    // check for right email format
                    System.out.println("Enter a new phone number without any \"-\"");
                    newInfo = keyBD.nextLine();
                    if (Person.checkPhoneFormat(newInfo)) {
                        candidate.setPhone(newInfo);
                        found = true;
                    } else
                        System.out.println("Not a proper phone number.  Try again.");

                } while (!found);
                break;

            case "3":
                do {
                    // check for right email format
                    System.out.println("Enter a new email address");
                    newInfo = keyBD.nextLine();
                    if (Person.checkEmailFormat(newInfo)) {
                        candidate.setEmail(newInfo);
                        found = true;
                    } else
                        System.out.println("Not a proper email address.  Try again.");
                } while (!found);
                break;

            default:
                System.out.println("Unknown option!");
                break;
        }

    }
}
