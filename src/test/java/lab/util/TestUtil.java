package lab.util;

import java.util.List;
import java.util.ArrayList;

import lab.demand.Order;

public class TestUtil {

    public static List<Order> buildOrdersPeru() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("PE", 10L));
        ordersPeru.add(new Order("PE", 10L));
        return ordersPeru;
    }

    public static List<Order> buildOrdersColombia() {
        List<Order> ordersCol = new ArrayList<Order>();
        ordersCol.add(new Order("CO", 10L));
        ordersCol.add(new Order("CO", 10L));
        return ordersCol;
    }

    public static List<Order> buildOrdersMixed() {
        List<Order> ordersMix = new ArrayList<Order>();
        ordersMix.add(new Order("BR", 20L));
        ordersMix.add(new Order("CO", 15L));
        ordersMix.add(new Order("PE", 10L));
        ordersMix.add(new Order("AR", 25L));
        ordersMix.add(new Order("CL", 30L));
        return ordersMix;
    }

}