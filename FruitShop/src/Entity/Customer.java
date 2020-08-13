package Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author hungk
 */
public class Customer {
    ArrayList<Order> listOrder;
    String customerName;

    public Customer() {
    }

    public Customer(ArrayList<Order> listOrder, String customerName) {
        this.listOrder = listOrder;
        this.customerName = customerName;
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(ArrayList<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    
    
    
}
