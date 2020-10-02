package manager_arraylist;

import product.Product;

import java.io.IOException;
import java.util.*;

public abstract class ArrayListManager {
    private int id = 0;
    public List<Product> products = new ArrayList<>();
    //private Product Comparator;

    public ArrayListManager() {
    }

    public ArrayListManager(List<Product> products) {
        this.products = products;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId(int id) {
        return id;
    }

    public void addProduct(String name, int price, String brand, String descrip) {
        Product newProduct = new Product(this.id, name, price, brand, descrip);
        products.add(newProduct);
        this.id++;
    }

    public abstract void addDataToFile() throws IOException;
    public abstract void getDataFromFile() throws IOException, ClassNotFoundException;

    public void editProduct(int id, String name, int price, String brand, String descrip) {
        for (Product ele : products) {
            if (ele.getId() == id) {
                ele.setName(name);
                ele.setPrice(price);
                ele.setBrand(brand);
                ele.setDescription(descrip);
            }
        }
    }

    public void deleteProduct(int id) {
        System.out.println("delete");
        System.out.println("id - "+id);
        for (Product ele : products) {
            if (ele.getId() == id) {
                products.remove(ele);
                break;
            }
        }
//        for (int i =0; i < products.size(); i++){
//            if ()
//        }
    }

    public void searchProductByName(String name) {
        int[] index = new int[products.size()];
        int count = 0;
        boolean exsit = true;

        for (Product e : products) {
            if (e.getName().equals(name)) {
                System.out.println(e.toString());
                return;
            }else {
                exsit = false;
            }
        }
        if (!exsit){
            System.out.println("not found!");
        }
    }

    public void sortUp() {
        Collections.sort(products);
        showList();
    }

    public void sortDown() {
        Collections.sort(products);
        Collections.reverse(products);
        showList();
    }

    public void showList() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }


}
