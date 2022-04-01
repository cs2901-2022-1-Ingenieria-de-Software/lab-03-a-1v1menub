package lab.demand;

import java.util.List;

public class ManageDemand {

    private Tax tax;

    public ManageDemand(Tax tax) {
        this.tax = tax;
    }

    public double calculateTotal(List<Order> orders){
        double taxes = 0.0;
        double quantities = 0.0;
        for (Order order : orders) {
            double t = this.tax.calculateTax(order.getCountry());
            double temp = order.getQuantity();
            quantities += temp;
            taxes += t;
        }
        return quantities * taxes;
    }

    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, Tax taxes){
        double t2 = 0.0;
        double quantities = 0.0;
        for (Order order : orders) {
            double t = taxes.calculateTax(order.getCountry());
            double temp = order.getQuantity();
            quantities += temp;
            t2 += t;
        }
        return quantities * t2;
    }

}
