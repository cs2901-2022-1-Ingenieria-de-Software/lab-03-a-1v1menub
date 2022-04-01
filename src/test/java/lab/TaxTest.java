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
public class TaxTest {

    private Tax t1;

    @BeforeClass
    public void setup() {
        t1 = new Tax();
    }

    public void test_TaxHappy() {
        t1.putTax("CL", 0.25);
        double result = t1.calculateTax("CL");
        Assert.assertEquals(result, 0.25);
    }
    
    public void test_TaxMissing() {
        t1.putTax("CL", 0.25);
        double result = t1.calculateTax("xd");
        Assert.assertEquals(result, 0);
    }

    public void test_TaxEmpty() {
        t1.putTax("CL", 0.25);
        double result = t1.calculateTax("");
        Assert.assertEquals(result, 0);
    }

}
