import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recruiter {
    private String skillSet;
    private ArrayList<String> candidates;

    public Recruiter() {
        this.skillSet = skillSet;
        this.candidates = new ArrayList<String>();
    }

    public Recruiter(String skillSet) {
        this.skillSet = skillSet;
        this.candidates = new ArrayList<String>();
    }


    public Recruiter(String skillSet, ArrayList<Person> allCandidates) {
        this.skillSet = skillSet;
        this.candidates = new ArrayList<String>();
        Skill skill;


        for (Person item : allCandidates) {
            for (int i = 0; i < item.getSkillSz(); i++) {
                skill = item.getSkill(i);
                if (skillSet.equalsIgnoreCase(skill.getName())) {
                    // found the skill set
                    // add to the candidate list and
                    // look for more candidates
                    this.candidates.add(item.getPersonalInfo());
                    break;
                }

            }
            // look for next candidate

        }


    }

    public String getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(String skillSet) {
        this.skillSet = skillSet;
    }

    public int getCandidatesSz() {
        return candidates.size();
    }

    public String getCandidates(int idx) {
        return candidates.get(idx);
    }

    public void setCandidates(String candidates) {
        this.candidates.add(candidates);
    }

    public String printCandidates() {
        String msg = "";

        int sz = getCandidatesSz();
        if (sz == 0)
            msg = msg + "No candiates found\n";
        else {
            for (int i = 0; i < getCandidatesSz(); i++) {
                msg = msg + "\nCandidate " + (i+1) + ":\n" + getCandidates(i) + "\n";
            }
        }

        return msg;
    }
}

