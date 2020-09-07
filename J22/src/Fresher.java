/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungk
 */
public class Fresher extends Candidates{
    int GraduationDate;
    String GraduationRank;
    String Education;

    public Fresher() {
        super();
    }

    public Fresher(int GraduationDate, String GraduationRank, String Education, 
                   String ID, String FirstName, String LastName, int BirthDate, 
                   String Address, String Phone, String Email, int typeCandidate) {
        super(ID, FirstName, LastName, BirthDate, Address, Phone, Email, typeCandidate);
        this.GraduationDate = GraduationDate;
        this.GraduationRank = GraduationRank;
        this.Education = Education;
    }

    public int getGraduationDate() {
        return GraduationDate;
    }

    public void setGraduationDate(int GraduationDate) {
        this.GraduationDate = GraduationDate;
    }

    public String getGraduationRank() {
        return GraduationRank;
    }

    public void setGraduationRank(String GraduationRank) {
        this.GraduationRank = GraduationRank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String Education) {
        this.Education = Education;
    }
    
    
}
