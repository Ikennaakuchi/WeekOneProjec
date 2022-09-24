package model;

import java.util.ArrayList;

public class Customer {
    private String name;
    private double wallet;
    private ArrayList<Product> cart = new ArrayList<>();

    public Customer(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public void addToCart(Store store, Product product, int quantity){
        boolean flag = false;
        if(!(wallet >= (product.getPrice() * quantity))){
            System.out.println("money no de enough");
        }else{
            wallet -= (product.getPrice() * quantity);
            flag = true;
        }
        if (store.canRemove(product,quantity) && flag){
            store.removeFromProductList(product,quantity);
            Product newProduct = new Product(product.getName(), product.getCategory(), product.getPrice(), quantity);
            this.cart.add(newProduct);
            System.out.println("product added successfully");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }
}
