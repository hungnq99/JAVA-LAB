package Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungk
 */
public class Student implements Comparable<Student>{
    private String ID;
    private String StudentName;
    private String Semester;
    private String CourseName;

    public Student() {
    }

    public Student(String ID, String StudentName, String Semester, String CourseName) {
        this.ID = ID;
        this.StudentName = StudentName;
        this.Semester = Semester;
        this.CourseName = CourseName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    @Override
    public int compareTo(Student o) {
       return this.StudentName.compareTo(o.getStudentName());
    }
    
    public void print() {
        System.out.printf("%-20s%-20s%-20s\n", this.StudentName, this.Semester, this.CourseName);
    }
    
}
