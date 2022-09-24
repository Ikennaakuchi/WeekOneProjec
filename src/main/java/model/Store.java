package model;

import java.util.ArrayList;

public class Store {
    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<Staff> staffList;



    public void removeFromProductList(Product product, int quantity){
        product.setQuantity(product.getQuantity()-quantity);
    }

    public boolean canRemove(Product product, int quantity){
        if (!productList.contains(product)){
            System.out.println("product not available");
            return false;
        }
        if (!(product.getQuantity() >= quantity)){
            System.out.println("not enough product quantity");
            return false;
        }else {
            System.out.println("product available");
            return true;
        }
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }
}
