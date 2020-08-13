package Manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Verify.Validation;
import Entity.Fruit;
import Entity.Customer;
import Entity.Order;
import java.util.*;

/**
 *
 * @author hungk
 */
public class Manager {

    static int menu() {
        //loop until user want to exit
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    //allow user create fruit
    static void createFruit(ArrayList<Fruit> lf) {
        //loop until user don't want to create fruit
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString();
            //check id exist
            if (!Validation.checkIdExist(lf, fruitId)) {
                System.out.println("Id exist");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            lf.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            //check user want to continue or not
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    //allow user show view order
    static void viewOrder(ArrayList<Customer> lc) {
        for (Customer customer : lc) {
            System.out.print("Customer: " + customer.getCustomerName());
            System.out.println();
            displayListOrder(customer.getListOrder());
        }
    }

    //allow user buy items
    static void shopping(ArrayList<Fruit> listFruit, ArrayList<Customer> lc) {
        //check list empty user can't buy
        if (listFruit.isEmpty()) {
            System.out.println("No have item.");
            return;
        }
        //loop until user don't want to buy continue
        //ArrayList<Customer> lc = new ArrayList<>();
        ArrayList<Order> lo = new ArrayList<>();
        while (true) {
            displayListFruit(listFruit);
            System.out.print("Enter item: ");
            int item1 = Validation.checkInputIntLimit(1, listFruit.size());
            int item = item1 - 1;
            if(listFruit.get(item).getQuantity() == 0){
                System.out.println("Sold out");
                continue;
            }
            System.out.println("You selected: " + listFruit.get(item).getFruitName());
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, listFruit.get(item).getQuantity());
            
            if (!Validation.checkItemExist(lo, listFruit.get(item).getFruitId())) {
                updateOrder(lo, listFruit.get(item).getFruitId(), quantity);
                listFruit.get(item).setQuantity(listFruit.get(item).getQuantity() - quantity);
            } else {
                lo.add(new Order(listFruit.get(item).getFruitId(), listFruit.get(item).getFruitName(),
                        quantity, listFruit.get(item).getPrice()));
                listFruit.get(item).setQuantity(listFruit.get(item).getQuantity() - quantity);
            }
//            if (!Validation.checkItemExist(lc, listFruit.get(item).getFruitId())) {
//                updateOrder(lc, listFruit.get(item).getFruitId(), quantity);
//            } else {
//                lo.add(new Customer(listOrder, customerName));
//            }
            if (!Validation.checkInputYN()) {
                break;
            }
        }
        displayListOrder(lo);
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        lc.add(new Customer(lo, name));
    }

    //display list fruit in shop
    static void displayListFruit(ArrayList<Fruit> lf) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : lf) {
            //check shop have item or not 
            
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            
        }
    }

    //display list order
    static void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    //if order exist then update order
    static void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
//    static void updateOrder(ArrayList<Customer> lc, String id, int quantity) {
//        for (Customer customer : lc) {
//            int size = customer.getListOrder().size();
//            for (int i = 0; i < size; i++) {
//                if (customer.getListOrder().get(i).getFruitId().equalsIgnoreCase(id)) {
//                    customer.getListOrder().get(i).setQuantity(customer.getListOrder().get(i).getQuantity() + quantity);
//                }
//            }
//        }
//    }
}
