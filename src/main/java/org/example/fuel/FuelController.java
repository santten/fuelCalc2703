package org.example.fuel;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FuelController {
    public Label lblFuel;
    public TextField txtFuel;
    public Label lblDistance;
    public TextField txtDistance;
    public Label txtResult;
    public Button btnCalculate;

    ResourceBundle rb;
    Double resultDouble;

    private void setLanguage(Locale locale) {
        txtResult.setText("");
        try {
            rb = ResourceBundle.getBundle("messages", locale);
            lblFuel.setText(rb.getString("fuelLabel"));
            lblDistance.setText(rb.getString("distanceLabel"));
            btnCalculate.setText(rb.getString("calculateButton"));

            if (resultDouble != null){
                txtResult.setText(String.format(rb.getString("resultLabel"), resultDouble));
            }
        } catch (MissingResourceException e) {
            txtResult.setText("Error loading resources");
        }
    }

    public void onCalculate(ActionEvent actionEvent) {
        double fuel;
        double dist;

        try {
            fuel = Double.parseDouble((txtFuel.getText()));
            dist = Double.parseDouble((txtDistance.getText()));
        } catch(Exception e) {
            txtResult.setText(rb.getString("invalidInput"));
            return;
        }

        resultDouble = (fuel / dist) * 100;
        txtResult.setText(String.format(rb.getString("resultLabel"), resultDouble));

    }

    public void onFRClick(ActionEvent actionEvent) {
        setLanguage(new Locale("fr", "FR"));
    }

    public void onENClick(ActionEvent actionEvent) {
        setLanguage(new Locale("en", "US"));
    }

    public void onJAClick(ActionEvent actionEvent) {
        setLanguage(new Locale("ja", "JP"));
    }

    public void onIRClick(ActionEvent actionEvent) {
        setLanguage(new Locale("fa", "IR"));
    }

    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }
}