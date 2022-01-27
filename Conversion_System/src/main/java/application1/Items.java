package application1;

import java.util.ArrayList;

public class Items {
    private String name;
    private ArrayList<Integer>price;

    public Items(String name, ArrayList<Integer> price){
        this.name = name;
        this.price = price;

    }

    public ArrayList<Integer> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Integer> price) {
        this.price = price;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
