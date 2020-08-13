/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Report;
import Entity.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hungk
 */
public class Validation {
    static Scanner sc = new Scanner(System.in);
    //Check Input Limit
    //Check Input Limit
    public static int inputLimit(int min, int max) {
        //loop until true input
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Please input between " + min + " and " + max);
                    System.out.print("Enter again: ");
                } else {
                    return choice;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter Integer Number!");
                System.out.print("Enter Again: ");
            }

        }
    }
    
    //Check Input String
    public static String inputString(){
        //loop until true input
        while(true){
            String res = sc.nextLine().trim();
            if(res.isEmpty()){
                System.out.println("Not Empty!!");
                System.out.print("Enter again: ");
            }else {
                return res;
            }
        }
    }
    public static String checkInputString(){
        //loop until true input
        while(true){
            String res = inputString();
            if(res.matches("[a-zA-Z ]+")){
                return res;
            }else {
                System.out.println("Please input alphabet");
                System.out.print("Enter Again: ");
            }
        }
    }
    //Check Input Course
    public static String checkInputCourse() {
        //loop until user input correct
        while (true) {
            String result = inputString();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.out.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }
    //check user input yes/ no
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
    //check ID not valid with name
    public static boolean checkIDValid(ArrayList<Student> list, String id, String name){
        for (Student student : list) {
            if(student.getID().equalsIgnoreCase(id) && 
              !student.getStudentName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }
    //check student exist
    public static boolean checkStudentExist(ArrayList<Student> ls, String id,
            String studentName, String semester, String courseName) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getID())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }
    //check user change or not
    public static boolean checkChangeInfomation(Student student, String id,
            String name, String semester, String course) {
        if (id.equalsIgnoreCase(student.getID())
                && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName())) {
            return false;
        }
        return true;
    }
    //check user input u / d
    public static boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }
    
    //check report exist
    public static boolean checkReportExist(ArrayList<Report> lr, String id,
            String course, int total) {
        for (Report report : lr) {
            if (id.equalsIgnoreCase(report.getStudentID())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }
}
