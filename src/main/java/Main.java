import enums.Role;
import model.Customer;
import model.Product;
import model.Staff;
import model.Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Product rice = new Product("rice","food",2300,20);
        Product beans = new Product("beans","food",2500,20);
        Product dodo = new Product("dodo","food",1300,20);
        Product garri = new Product("garri","food",1000,20);
        Staff manager = new Staff("ikenna", Role.MANAGER);
        Staff cashier = new Staff("tim", Role.CASHIER);

        manager.addToProductList(store,rice);
        manager.addToProductList(store,beans);
        manager.addToProductList(store,dodo);
        manager.addToProductList(store,garri);
        System.out.println("product list before purchase " + store.getProductList());


        Customer customer = new Customer("akuchi",50000);
        customer.addToCart(store,rice,2);
        customer.addToCart(store,beans,2);
        customer.addToCart(store,garri,2);
        customer.addToCart(store,dodo,2);
        cashier.checkOut(customer);
    }
}
