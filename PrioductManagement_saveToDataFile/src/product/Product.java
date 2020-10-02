package product;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable {
    private String name;
    private int price;
    private int id;
    private String brand;
    private String description = "";

    public Product(int id, String name, int price , String brand, String description) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.brand = brand;
        this.description = description;
    }

    public Product(String name, int price) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format(" |ID: %-3d  |Name: %-8s  |Price: %-8d |Brand: %-8s |Description: %s", id, name, price, brand,description);
        //return String.format(" |ID: %-3d", id) + String.format(" |Name: %-8s", name) + String.format(" |Price: %-8d", price);
    }

    @Override
    public int compareTo(Product o) {
        if (price == o.getPrice())
            return 0;
        else if (price > o.getPrice())
            return 1;
        else
            return -1;
    }
}
