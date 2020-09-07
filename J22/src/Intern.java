/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungk
 */
public class Intern extends Candidates{
    String major;
    String semester;
    String university;

    public Intern() {
        super();
    }

    public Intern(String major, String semester, String university, String ID, 
                  String FirstName, String LastName, int BirthDate, String Address, 
                  String Phone, String Email, int typeCandidate) {
        super(ID, FirstName, LastName, BirthDate, Address, Phone, Email, typeCandidate);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    
}
