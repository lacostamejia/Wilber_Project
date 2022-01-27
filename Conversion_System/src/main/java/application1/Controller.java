package application1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    public HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public Label Measure;
    public Label Final_Price;
    public ListView Name;
    public ListView Price;
    public ChoiceBox Options;
    public TextField Ancho;
    public TextField Largo;

    ArrayList<String> names = new ArrayList<>();
    ArrayList<ArrayList<Integer>> prices = new ArrayList<>();
    ArrayList<String> options = new ArrayList<>();
    HashMap<String,Double> values = new HashMap<>();
    int price_selected = 0;



    public void Modify(ActionEvent actionEvent) {
    }

    public void Borrar(ActionEvent actionEvent) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Measure.setText("");
        Final_Price.setText("");

        options.add("Centimetros");
        options.add("Pulgadas");
        options.add("Pies");
        options.add("Metros");

        values.put("Centimetros",0.0010764);
        values.put("Pulgadas",144.00);
        values.put("Metros",10.764);
        values.put("Pies",1.00);



        ArrayList<Integer> y = new ArrayList<Integer>();
        y.add(40); y.add(45); y.add(50); y.add(55); y.add(60);
        Items item = new Items("Vynil de Impression Matte",y);

        ArrayList<Integer> y_1 = new ArrayList<Integer>();
        y_1.add(40); y_1.add(45); y_1.add(50); y_1.add(55); y_1.add(60);
        Items item_1 = new Items("Vynil de Impresion Glossy",y_1);

        ArrayList<Integer> y_2 = new ArrayList<Integer>();
        y_2.add(40); y_2.add(45); y_2.add(50); y_2.add(55); y_2.add(60);
        Items item_2 = new Items("Vynil de Impresion Transparente",y_2);

        ArrayList<Integer> y_3 = new ArrayList<Integer>();
        y_3.add(120); y_3.add(125); y_3.add(130); y_3.add(135); y_3.add(140); y_3.add(145); y_3.add(155); y_3.add(160);
        Items item_3 = new Items("Vynil  Troquelado",y_3);

        ////
        ArrayList<Integer> y_4 = new ArrayList<Integer>();
        y_4.add(280); y_4.add(285); y_4.add(290); y_4.add(295); y_4.add(300); y_4.add(305); y_4.add(310); y_4.add(315);
        y_4.add(320);
        Items item_4 = new Items("Canvas",y_4);

        ArrayList<Integer> y_5 = new ArrayList<Integer>();
        y_5.add(40); y_5.add(45); y_5.add(50); y_5.add(55); y_5.add(60);
        Items item_5 = new Items("Mesh",y_5);

        ArrayList<Integer> y_6 = new ArrayList<Integer>();
        y_6.add(60); y_6.add(65); y_6.add(70); y_6.add(75); y_6.add(80); y_6.add(85); y_6.add(90);
        Items item_6 = new Items("One Vision",y_6);


        map.put(item.getName(),y);
        map.put(item_1.getName(),y_1);
        map.put(item_2.getName(),y_2);
        map.put(item_3.getName(),y_3);
        map.put(item_4.getName(),y_4);
        map.put(item_5.getName(),y_5);
        map.put(item_6.getName(),y_6);
        System.out.println(map);

        for(Map.Entry<String,ArrayList<Integer>> entry: map.entrySet()){
            names.add(entry.getKey());
            prices.add(entry.getValue());

            //Price.setItems(FXCollections.observableArrayList(price));
        }
        Name.setItems(FXCollections.observableArrayList(names));
        Options.setItems(FXCollections.observableArrayList(options));


        Name.refresh();
        Price.refresh();

    }

    public void Name_Selected(MouseEvent mouseEvent) {
        String x = Name.getSelectionModel().getSelectedItem().toString();
        Price.setItems(FXCollections.observableArrayList(map.get(x)));
        Price.refresh();
    }

    public void Price_Selected(MouseEvent mouseEvent) {
        price_selected = Integer.valueOf(Price.getSelectionModel().getSelectedItem().toString());
        System.out.println(price_selected);
    }

    public double calculation(){
        double final_price = 0;
        int ancho = 0;
        int largo = 0;

        //Different ways to calculate
        if(Measure.getText().equals("Pulgadas")) {
            final_price = ((((Integer.valueOf(Ancho.getText())) * Integer.valueOf(Largo.getText())) / (values.get("Pulgadas"))) * price_selected);
        }
        else{
            final_price = ((((Integer.valueOf(Ancho.getText())) * Integer.valueOf(Largo.getText())) * (values.get(Measure.getText()))) * price_selected);
        }
        return Math.round(final_price);
    }

    public void Calcular(ActionEvent actionEvent) {

        Final_Price.setText(String.valueOf(calculation() + " $/" + Measure.getText() + "^2"));

    }


    public void Option_Selected(MouseEvent mouseEvent) {
        Measure.setText(Options.getSelectionModel().getSelectedItem().toString());
    }
}
