package lab;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.util.TestUtil;
import lab.demand.Order;

import java.util.List;

@Test
public class ManageDemandTest {

    private Tax tax;

    private ManageDemand demand;

    @BeforeClass
    public void setup() {
        tax = new Tax();
        tax.putTax("PE", 0.18);
        tax.putTax("BR", 0.12);
        demand =  new ManageDemand(tax);
    }
    
    public void test_AllOrdersFromPeru() {
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
        double result = demand.calculateTotal(ordersFromPeru);
        Assert.assertEquals(Math.round(result), 7.0);
    }

    public void test_AllOrdersFromColombia() {
        List<Order> ordersFromCol = TestUtil.buildOrdersColombia();
        double result = demand.calculateTotal(ordersFromCol);
        Assert.assertEquals(Math.round(result), 0.0);
    }
    
    public void test_AllOrdersMixIncompleto() {
        List<Order> ordersMix = TestUtil.buildOrdersMixed();
        double result = demand.calculateTotal(ordersMix);
        Assert.assertEquals(Math.round(result), 30.0);
    }

    public void test_AllOrdersMixCompleto() {
        Tax tax2 = new Tax();
        tax2.putTax("PE", 0.18);
        tax2.putTax("BR", 0.12);
        tax2.putTax("CO", 0.20);
        tax2.putTax("AR", 0.15);
        tax2.putTax("CL", 0.20);
        List<Order> ordersMix = TestUtil.buildOrdersMixed();
        double result = demand.calculateTotalForWithAdditionalByCountry(ordersMix, tax2);
        Assert.assertEquals(Math.round(result), 85.0);
    }

    public void test_AllOrdersVacio() {
        Tax tax2 = new Tax();
        tax2.putTax("PE", 0.18);
        tax2.putTax("", 0.12);
        tax2.putTax("CO", 0.20);
        tax2.putTax("", 0.15);
        tax2.putTax("CL", 0.20);
        List<Order> ordersMix = TestUtil.buildOrdersMixed();
        double result = demand.calculateTotalForWithAdditionalByCountry(ordersMix, tax2);
        Assert.assertEquals(Math.round(result), 58.0);
    }
}
