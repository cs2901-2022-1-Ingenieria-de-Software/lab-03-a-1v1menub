package lab.demand;

import java.util.HashMap;

public class Tax {
    private HashMap<String, Double> taxes = new HashMap<String, Double>();

    public Double calculateTax(String country) {
        Double tax = taxes.get(country);
        if(tax == null) {
            return 0.0;
        }
        else {
            return tax;
        }
    }

    public void putTax(String country,Double tax) {
        taxes.put(country, tax);
    }
}
