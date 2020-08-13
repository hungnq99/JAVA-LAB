package Manager;

import Entity.Report;
import Entity.Student;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hungk
 */
public class StudentManager {

    public static int menu() {
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.inputLimit(1, 5);
        return choice;
    }

    //Create Function
    public static void createStudent(ArrayList<Student> list) {
        int count = list.size();
        while (true) {
            if (count > 2) {
                System.out.println("Do you want to continue (Y/N)?");
                if (!Validation.checkInputYN()) {
                    return;
                }
            }

            System.out.println("Enter ID of Student: ");
            String studentID = Validation.inputString();
            System.out.println("Enter name of Student: ");
            String studentName = Validation.checkInputString();
            if (!Validation.checkIDValid(list, studentID, studentName)) {
                System.out.println("This ID has exist student! Please enter again.");
                continue;
            }
            System.out.println("Enter Semester: ");
            String semester = Validation.checkInputString();
            System.out.println("Enter course name: ");
            String courseName = Validation.checkInputCourse();

            //check student exist or not
            if (Validation.checkStudentExist(list, studentID, studentName, semester, courseName)) {
                list.add(new Student(studentID, studentName, semester, courseName));
                count++;
                System.out.println("Add student success.");
            } else {
                System.out.println("Duplicate. Please enter again!");
                continue;
            }
        }
    }

    //Find and Sort
    public static void FindSort(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("List Empty.");
            return;
        }
        ArrayList<Student> listStudentByName = listStudentByName(list);
        Collections.sort(listStudentByName);
        if (listStudentByName.isEmpty()) {
            System.out.println("Dont have this student");
        } else {
            System.out.printf("%-20s%-20s%-20s\n", "Student name", "semester", "Course Name");
            //Browse list studnet
            for (Student student : listStudentByName) {

                student.print();
            }
        }
    }

    public static ArrayList<Student> listStudentByName(ArrayList<Student> list) {
        ArrayList<Student> listStudentByName = new ArrayList<>();
        System.out.println("Enter student name or a part: ");
        String name = Validation.checkInputString();
        for (Student student : list) {
            if (student.getStudentName().toUpperCase().contains(name.toUpperCase())) {
                listStudentByName.add(student);
            }
        }
        return listStudentByName;
    }

    //Allow user update and delete   
    public static void updateOrDelete(ArrayList<Student> ls) {
        //if list empty 
        if (ls.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        int count = ls.size();
        
        System.out.print("Enter id: ");
        String id = Validation.inputString();
        ArrayList<Student> listStudentFindByID = getListStudentById(ls, id);
        //check list empty
        if (listStudentFindByID.isEmpty()) {
            System.out.println("Not found student.");
            return;
        } else {
            Student student = getStudentByListFound(listStudentFindByID);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            //check user want to update or delete
            if (Validation.checkInputUD()) {
                while (true) {
                    System.out.print("Enter id: ");
                    String idStudent = Validation.inputString();
                    System.out.print("Enter name student: ");
                    String name = Validation.inputString();
                    if (!Validation.checkIDValid(ls, idStudent, name) && id.compareTo(idStudent) !=0 ) {
                        System.out.println("This ID has exist student! Please enter again.");
                        continue;
                    }

                    System.out.print("Enter semester: ");
                    String semester = Validation.inputString();
                    System.out.print("Enter name course: ");
                    String course = Validation.checkInputCourse();
                    //check user change or not
                    if (!Validation.checkChangeInfomation(student, idStudent, name, semester, course)) {
                        System.out.println("Nothing change.");
                        continue;
                    }
                    //check student exist or not
                    if (Validation.checkStudentExist(ls, idStudent, name, semester, course)) {
                        for (int i = 0; i < listStudentFindByID.size(); i++) {
                            listStudentFindByID.get(i).setID(idStudent);
                            listStudentFindByID.get(i).setStudentName(name);
                        }
                        student.setSemester(semester);
                        student.setCourseName(course);
                        System.out.println("Update success.");
                        return;
                    } else {
                        System.out.println("Duplicate. Please enter again!");
                        continue;
                    }
                }
            } else {
                ls.remove(student);
                count--;
                System.out.println("Delete success.");
                return;
            }
        }
    }

    //Get student user want to update/delete in list found
    public static Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        //display list student found
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        
        System.out.print("Enter student: ");
        int choice = Validation.inputLimit(1, (count-1));
        return listStudentFindByName.get(choice - 1);
    }

    //Get list student find by id
    public static ArrayList<Student> getListStudentById(ArrayList<Student> ls, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getID())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }
    
    //4.Report
    public static void report(ArrayList<Student> listStudent){
        //if list empty 
        if (listStudent.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        
        ArrayList<Report> listReport = new ArrayList<>();
            for (Student student : listStudent) {
                int total = 0;
                String studentID = student.getID();
                String courseName = student.getCourseName();
                String studentName = student.getStudentName();
                for (Student studentCountTotal : listStudent) {
                    if (studentID.equalsIgnoreCase(studentCountTotal.getID())
                            && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                        total++;
                    }
                }
                if (Validation.checkReportExist(listReport, studentID,
                        courseName, total)) {
                    listReport.add(new Report(studentID, studentName, courseName, total));
                }
            }
        //print report
        for (int i = 0; i < listReport.size(); i++) {
            System.out.printf("%-15s|%-5s|%-5d\n", listReport.get(i).getStudentName(),
                    listReport.get(i).getCourseName(), listReport.get(i).getTotalCourse());
        }
    }
}
