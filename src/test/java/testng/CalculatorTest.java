package testng;

import com.digital.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class CalculatorTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addTwoNumbersTest(){
//        Calculator.add(2,5);
//        System.out.println(Calculator.add(2, 5));
        assertEquals(Calculator.add(2, 5), 4);
        assertEquals(Calculator.add(2, 6), 8);
    }
    @Test
    public void testsetSoftAssert(){
        softAssert.assertEquals(Calculator.add(2, 8), 4);
        softAssert.assertEquals(Calculator.add(2, 8), 5);
        softAssert.assertEquals(Calculator.add(2, 8), 6);
        softAssert.assertEquals(Calculator.add(2, 8), 8);
        softAssert.assertAll();
    }

}
