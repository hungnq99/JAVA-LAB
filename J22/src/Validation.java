
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungk
 */
public class Validation {
    static Scanner sc = new Scanner(System.in);
    /*
        \\d{10} input 10 number
        \\d* input more or not    
    */
    private static final String PHONE_VALID = "^\\d{10}\\d*";
    /*
        ^[a-zA-Z] Start with a alphabet
        [\\w] a-zA-Z or 0-9 or _
        @ must be input "@"
        ([a-zA-Z]+\\.)+ input alphabet. many times
        \\. must be input "."
    */
    private static final String EMAIL_VALID = "^[a-zA-Z]\\w*@([a-zA-Z]+\\.){1,2}[a-zA-Z]+$";
    public static int checkInputIntLimit(int min, int max){
        //Loop until true
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                if(number >= min && number <= max){
                    return number;
                }else throw new NumberFormatException();
            }catch (NumberFormatException e) {
                System.out.println("Please input number between " + min + " and " + max);
                System.out.print("Enter again: ");
            }
        }      
    }
    public static String inputString(){
        
        while(true){
            String string = sc.nextLine().trim();
            if(string.isEmpty()){
                System.out.println("Can not Empty!");
                System.out.print("Enter again: ");
            } else return string;
        }      
    }
    public static String checkInputString(){
        while (true) {
            String res = inputString();
            if (res.matches("[a-zA-Z ]+")) {
                return res;
            } else {
                System.out.println("Input String");
                System.out.printf("Enter Again: ");
            }
        }
    }
    //check user input y/Y or n/N
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = inputString();
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    //check id exist or not
    public static boolean checkIdExist(ArrayList<Candidates> candidates, String id) {
        for (Candidates candidate : candidates) {
            if (candidate.getID().equalsIgnoreCase(id)) {
                System.out.println("Id exist.");
                return false;
            }
        }
        return true;
    }
    //check Input Email
    public static String checkInputEmail(){
        //loop until true
        while(true){
            String email = inputString();
            if(email.matches(EMAIL_VALID)){
                return email;
            }else {
                System.out.println("Please input in format <account name>@<domain>");
                System.out.println("Enter Email: ");
            }
        }
    }
    //check Phone number
    public static String checkPhoneNumber(){
        //loop until true
        while(true){
            String phoneNumber = inputString();
            if(phoneNumber.matches(PHONE_VALID)){
                return phoneNumber;
            }else {
                System.out.println("Phone is number have minimum 10 characters");
                System.out.println("Enter phone: ");
            }
        }
    }
    
    //check Graduation Rank
    public static String checkInputGraduationRank(){
        //loop until true
        while(true){
            String graduationRank = inputString();
            if(graduationRank.equalsIgnoreCase("Excellence") ||
               graduationRank.equalsIgnoreCase("Good") ||
               graduationRank.equalsIgnoreCase("Fair") ||
               graduationRank.equalsIgnoreCase("Poor")){
                return graduationRank;
            }else {
                System.out.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }
    //check exp Year must be less than age
    public static int checkExpYear(int birthYear){
        int age = Calendar.getInstance().get(Calendar.YEAR) - birthYear;
        while(true){
            int expYear = checkInputIntLimit(0, 100);
            if(expYear < age){
                return expYear;
            }else {
                System.out.println("exp year must be smaller than age ");
                System.out.print("Enter Again: ");
            }
        }
    }
}
