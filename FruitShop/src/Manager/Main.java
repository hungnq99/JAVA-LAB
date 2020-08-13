package Manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entity.Customer;
import Entity.Fruit;
import java.util.*;
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
        ArrayList<Fruit> lf = new ArrayList<>();
        ArrayList<Customer> lc = new ArrayList<>();
        Fruit fr1 = new Fruit("1", "Cam", 12, 100, "VN");
        Fruit fr2 = new Fruit("2", "Tao", 5, 100, "VN");
        Fruit fr3 = new Fruit("3", "Xoai", 120, 100, "VN");
        Fruit fr4 = new Fruit("4", "Buoi", 10, 100, "VN");
        lf.add(fr1);
        lf.add(fr2);
        lf.add(fr3);
        lf.add(fr4);
//loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createFruit(lf);
                    break;
                case 2:
                    Manager.viewOrder(lc);
                    break;
                case 3:
                    Manager.shopping(lf, lc);
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
