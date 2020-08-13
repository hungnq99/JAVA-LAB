package Manager;

import Entity.Student;
import java.util.ArrayList;
/**
 *
 * @author hungk
 */
/* Step 1: Build Obj class
   Step 2: Build Menu
   Step 3: Build function
   Step 4: Validation*/
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student("1", "Nguyen Van A", "Spring", "java"));
        listStudent.add(new Student("1", "Nguyen Van A", "Summer", "java"));
        listStudent.add(new Student("2", "Nguyen Van B", "Summer", "java"));
        listStudent.add(new Student("3", "Nguyen Van C", "Summer", "java"));
        
       int count = 5;
        //Loop until user want to exit
        while(true){
            int choice = StudentManager.menu();
            switch(choice){
                case 1: 
                    StudentManager.createStudent(listStudent);
                    break;
                case 2: 
                    StudentManager.FindSort(listStudent);
                    break;
                case 3: 
                    StudentManager.updateOrDelete(listStudent);
                    break;
                case 4: 
                    StudentManager.report(listStudent);
                    break;
                case 5: return;
            }
        }
    }
    
}
