package testng;

import testng.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo {
    @Test
    public void createNewUserTest(){
        User firstUser = new User("John", 30);
        Assert.assertNotNull(firstUser);
    }
    @Test(dependsOnMethods = "createNewUserTest")
    public void loginTes(){
        Assert.assertTrue(true);
    }
    @DataProvider(name = "inputValues")
    public Object[][] getInputValues() {
        return new Object[][] {
                {"john@gmail.com", "ValidPass"},
                {"johngmail.com", "ValidPass"},
                {"john@gmail.com", "InvalidPass"}
        };
    }
    @Test(dataProvider = "inputValues")
    public void testLoginFun(String username, String password){
        System.out.println(username + " " + password);

    }
}
