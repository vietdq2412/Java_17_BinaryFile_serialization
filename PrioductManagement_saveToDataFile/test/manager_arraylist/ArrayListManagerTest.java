package manager_arraylist;

import product.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListManagerTest {
    private int id = 0;
    public List<Product> products = new ArrayList<>();
    @org.junit.jupiter.api.Test
    void searchProductByName(String name) {
        for (Product e : products){
            if (e.getName().equals(name)){
                System.out.println(e.toString());
            }
        }
    }
}