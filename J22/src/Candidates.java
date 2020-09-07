/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungk
 */
public class Candidates {
    private String ID;
    private String FirstName;
    private String LastName;
    private int BirthDate;
    private String Address;
    private String Phone;
    private String Email;
    private int typeCandidate;

    public Candidates() {
    }

    public Candidates(String ID, String FirstName, String LastName, int BirthDate, 
                      String Address, String Phone, String Email, int typeCandidate) {
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.BirthDate = BirthDate;
        this.Address = Address;
        this.Phone = Phone;
        this.Email = Email;
        this.typeCandidate = typeCandidate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(int BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getTypeCandidate() {
        return typeCandidate;
    }

    public void setTypeCandidate(int typeCandidate) {
        this.typeCandidate = typeCandidate;
    }

    @Override
    public String toString() {
        return FirstName + " " + LastName + "|" + BirthDate + "|" + Address + "|" 
                + Phone + "|" + Email + "|" + typeCandidate;
    }
    
    
    
    
}
