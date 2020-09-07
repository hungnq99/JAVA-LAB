/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungk
 */
public class Experience extends Candidates{
    int ExpInYear;
    String ProSkill;

    public Experience() {
        super();
    }

    public Experience(int ExpInYear, String ProSkill, String ID, String FirstName, 
                      String LastName, int BirthDate, String Address, String Phone, 
                      String Email, int typeCandidate) {
        super(ID, FirstName, LastName, BirthDate, Address, Phone, Email, typeCandidate);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String ProSkill) {
        this.ProSkill = ProSkill;
    }
    
    
    
}
