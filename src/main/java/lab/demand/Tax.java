package lab.demand;

import java.util.List;

public class Tax {
    private Map<String, Double> taxes = new HashMap<String, Double>();

    public double calculateTax(String country) {
        Double tax = taxes.get(country);
        if(tax == null) {
            return 0.0;
        }
        else {
            return tax;
        }
    }

    public void addTax(String country,double tax) {
        taxes.put(country, tax);
    }
}
