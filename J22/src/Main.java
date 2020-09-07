import java.util.ArrayList;
/**
 *
 * @author hungk
 */
/*Step 1: Create all class Candidate
Step 2: Build Main Screen
Step 3: Build Function
Step 4: Check validate*/
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Candidates> candidates = new ArrayList<>();
        candidates.add(new Experience(4, "No", "E1", "Aelbrecht", "Stefan", 1991, "100 Wall Street", "0912194149", "StefanAe@gmail.com", 0));
        candidates.add(new Experience(4, "No", "E2", "Aguirre", "Eva", 1990, "Sao Paulo", "0000940394", "Eva@asante.com", 0));
        candidates.add(new Experience(4, "No", "E3", "Ahlgren", "Maria", 1999, "100 Wall Street", "0912194149", "StefanAe@gmail.com", 0));
        candidates.add(new Experience(4, "No", "E4", "Altosova", "Adeleva", 1989, "Rio de janero", "0000984933", "adelave@janeo.com", 0));
        
        while(true){
            int choice = CandidateManagement.menu();
            switch(choice){
                case 1: 
                    CandidateManagement.createExperience(candidates);
                    break;
                case 2: 
                    //CandidateManagement.createCandidate(candidates, 1);
                    break;
                case 3: 
                   // CandidateManagement.createCandidate(candidates, 2);
                    break;
                case 4: 
                    CandidateManagement.searchCandidate(candidates);
                    break;
                case 5: return;
            }
        }
    }
    
}
