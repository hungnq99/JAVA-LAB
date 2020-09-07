
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author hungk
 */
public class CandidateManagement {

    public static int menu() {
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Search");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 5);
        return choice;
    }
//, int type

    public static void createCandidate(ArrayList<Candidates> candidates, Candidates candidate) {

        while (true) {
            System.out.println("Enter ID: ");
            String id = Validation.inputString();
            if (!Validation.checkIdExist(candidates, id)) {
                continue;
            }
            candidate.setID(id);
            System.out.println("Enter First Name: ");
            String firstName = Validation.checkInputString();
            candidate.setFirstName(firstName);
            System.out.println("Enter Last Name: ");
            String lastName = Validation.checkInputString();
            candidate.setLastName(lastName);
            System.out.println("Enter Birth Year: ");
            int birthYear = Validation.checkInputIntLimit(1900,
                    Calendar.getInstance().get(Calendar.YEAR));
            candidate.setBirthDate(birthYear);
            System.out.println("Enter Address: ");
            String address = Validation.inputString();
            candidate.setAddress(address);
            System.out.println("Enter Phone: ");
            String phone = Validation.checkPhoneNumber();
            candidate.setPhone(phone);
            System.out.println("Enter Email: ");
            String email = Validation.checkInputEmail();
            candidate.setEmail(email);
            break;
//                Candidates candidate = new Candidates(id, firstName, lastName, birthYear,
//                        address, phone, email, type);

//                switch (type) {
//                    case 0:
//                        createExperience(candidates, candidate);
//                        break;
//                    case 1:
//                        createFresher(candidates, candidate);
//                        break;
//                    case 2:
//                        createIntern(candidates, candidate);
//                        break;
//                }
//            
//            System.out.print("Do you want to continue (Y/N): ");
//            //check user want to create new candidate or not
//            if (!Validation.checkInputYN()) {
//                printListNameCandidate(candidates);
//                return;
//            }
        }
    }
//, Candidates candidate

    public static void createExperience(ArrayList<Candidates> candidates) {
        while (true) {
            Candidates candidate = new Candidates();
            createCandidate(candidates, candidate);
            System.out.println("Enter EXP Year: ");
            int expYear = Validation.checkExpYear(candidate.getBirthDate());
            System.out.println("Enter Pro Skill: ");
            String proSkill = Validation.inputString();
            candidates.add(new Experience(expYear, proSkill, candidate.getID(),
                    candidate.getFirstName(), candidate.getLastName(),
                    candidate.getBirthDate(), candidate.getAddress(),
                    candidate.getPhone(), candidate.getEmail(),
                    candidate.getTypeCandidate()));
            System.out.println("Create Success!");
            System.out.print("Do you want to continue (Y/N): ");
            //check user want to create new candidate or not
            if (!Validation.checkInputYN()) {
                printListNameCandidate(candidates);
                return;
            }
        }

    }

    public static void createFresher(ArrayList<Candidates> candidates, Candidates candidate) {
        System.out.println("Enter Graduate Date: ");
        int graduaDate = Validation.checkInputIntLimit(1900,
                Calendar.getInstance().get(Calendar.YEAR));
        System.out.println("Enter Rank: ");
        String rank = Validation.checkInputGraduationRank();
        System.out.println("Enter University: ");
        String univers = Validation.inputString();
        candidates.add(new Fresher(graduaDate, rank, univers, candidate.getID(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.out.println("Create Success!");
    }

    public static void createIntern(ArrayList<Candidates> candidates, Candidates candidate) {
        System.out.println("Enter Major: ");
        String major = Validation.inputString();
        System.out.println("Enter Semester: ");
        String semester = Validation.inputString();
        System.out.println("Enter University: ");
        String univers = Validation.inputString();
        candidates.add(new Intern(major, semester, univers, candidate.getID(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.out.println("Create Success!");
    }

    public static void searchCandidate(ArrayList<Candidates> candidates) {
        printListNameCandidate(candidates);
        System.out.println("");
        System.out.print("Input Candidate name(First name or Last name): ");
        String name = Validation.checkInputString();
        System.out.print("Input type of candidate: ");
        int typeCandidate = Validation.checkInputIntLimit(0, 2);
        //
        //Browse all candidate and compare input name with Candidate name
        for (Candidates candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && (candidate.getFirstName().toUpperCase().contains(name.toUpperCase())
                    || candidate.getLastName().toUpperCase().contains(name.toUpperCase()))) {
                System.out.println(candidate.toString());
            }
        }
    }

    //display list name candidate
    public static void printListNameCandidate(ArrayList<Candidates> candidates) {
        System.out.println("List of candidates: ");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidates candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidates candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidates candidate : candidates) {
            if (candidate instanceof Intern) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }
}
