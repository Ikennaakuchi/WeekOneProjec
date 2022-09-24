package model;

import enums.Role;

import java.util.ArrayList;

public class Staff {
    private String name;
    private Role role;

    public Staff(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public void addToProductList(Store store, Product product){
        if(!role.equals(Role.MANAGER)){
            System.out.println("not authorized");
        }else {
            ArrayList<Product> arr = store.getProductList();
            arr.add(product);
            store.setProductList(arr);
        }
    }
//    public void addToProductList(Staff staff, Store store, ArrayList<Product> products){
//        if(!staff.getRole().equals(Role.MANAGER)){
//            System.out.println("not authorized");
//        }else {
//            ArrayList<Product> arr = store.getProductList();
//            arr.add(product);
//            store.setProductList(arr);
//        }
//    }

    public String checkOut( Customer customer){
        if(!role.equals(Role.CASHIER)){
//            System.out.println("not authorized");
            return "not authorized";
        }
        double totalPrice = 0;
        for(int i = 0; i < customer.getCart().size(); i++){
            Product product = customer.getCart().get(i);
            double itemPrice = product.getPrice() * product.getQuantity();
            totalPrice += itemPrice;
        }
        printReceipt(customer,totalPrice);
        return "checkout successful";
    }

    private void printReceipt(Customer customer, double totalPrice){
        System.out.println("\n\t\t ***** RECEIPT ***** \n");
        System.out.println("Name             :           " + customer.getName());
//        System.out.println("Contact          :           " + customer.getNumber());
        System.out.println("\n          Products Purchased                         \n");
        for (int i = 0; i < customer.getCart().size(); i++) {
            System.out.println(i + 1 + "." + "  " + customer.getCart().get(i).getName() + " ".repeat(15 - customer.getCart().get(i).getName().length())
                    + "       " + customer.getCart().get(i).getQuantity() + "        "+ customer.getCart().get(i).getPrice());
        }
        System.out.println("\n---------------------------------------");
        System.out.println("Total \t\t\t\t\t\t \t # " + totalPrice);
        System.out.println("---------------------------------------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
