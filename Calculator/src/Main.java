/**
 *
 * @author hungk
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          
          while(true){
              int choice = Manager.menu();
              switch(choice){
                  case 1: 
                      Manager.Calculator();
                      break;
                  case 2: 
                      Manager.BMICalculator();
                      break;
                  case 3: return;
              }
          }
    }
    
}
