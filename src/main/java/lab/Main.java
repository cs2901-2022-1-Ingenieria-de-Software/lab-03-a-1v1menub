package lab;

import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.demand.Order;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String [ ] args) {
        Tax tax = new Tax();
        tax.putTax("PE", 0.18);
        tax.putTax("BR", 0.12);
        ManageDemand mg = new ManageDemand(tax);

        List<Order> testOrders = buildSampleOrders();
        
        double resultFirst = mg.calculateTotal(testOrders);

        Tax tax2 = new Tax();
        tax2.putTax("CO", 0.10);
        tax2.putTax("PE", 0.20);
        tax2.putTax("BR", 0.30);

        double resultSecond = mg.calculateTotalForWithAdditionalByCountry(testOrders, tax2);
    }

    private static List<Order> buildSampleOrders() {
        List<Order> testOrders = new ArrayList<>();
        testOrders.add(new Order("PE", 10L));
        testOrders.add(new Order("PE", 20L));
        testOrders.add(new Order("CO", 10L));
        testOrders.add(new Order("BR", 10L));
        return testOrders;
    }
}
