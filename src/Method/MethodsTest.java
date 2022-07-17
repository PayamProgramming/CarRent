package Method;

import Pojo.Benz;
import Pojo.Car;
import Pojo.Ford;
import Pojo.User;

import org.junit.jupiter.api.Assertions;

class MethodsTest {


    @org.junit.jupiter.api.BeforeAll
    static void settingUp() {
        System.out.println("Test is starting .");
    }

    @org.junit.jupiter.api.AfterAll
    static void tearingDown() {
        System.out.println("Test is finishing .");
    }


    @org.junit.jupiter.api.Test
    void usersList() {
        Assertions.assertNotNull(Methods.UsersList);
    }

    @org.junit.jupiter.api.Test
    void carsList() {
        Assertions.assertNotNull(Methods.carList);
    }

    @org.junit.jupiter.api.Test
    void addUser() {
        String username1 = "a";
        String username2 = "";

        User user = new User();
        user.setUsername(username1);
        Assertions.assertNotNull(user.getUsername());

        Methods.UsersList.add(user);
        Assertions.assertTrue(Methods.UsersList.contains(user));

        User user2 = new User();
        user2.setUsername(username2);
        Assertions.assertNotNull(user2.getUsername());

        Methods.UsersList.add(user2);
        Assertions.assertTrue(Methods.UsersList.contains(user2));
    }

    @org.junit.jupiter.api.Test
    void addCar() {
        Car ford = new Ford();
        Assertions.assertNotNull(ford);
        Car benz = new Benz();
        Assertions.assertNotNull(benz);

        Methods.carList.add(ford);
        Assertions.assertTrue(Methods.carList.contains(ford));
        Methods.carList.add(benz);
        Assertions.assertTrue(Methods.carList.contains(benz));
    }

    @org.junit.jupiter.api.Test
    void rentCars() {
        String a = "ali";
        User user = new User();
        user.setUsername(a);
        Assertions.assertNotNull(user.getUsername());
        Methods.UsersList.add(user);
        Assertions.assertTrue(Methods.ValidateUsername(a));

        Car car1 = new Benz();
        user.AddCars(car1);
        car1.setRented(true);
        Assertions.assertTrue(car1.isRented());
        Assertions.assertEquals(1,user.getCars());

        Car car2 = new Ford();
        user.AddCars(car2);
        car2.setRented(false);
        Assertions.assertFalse(car2.isRented());
        Assertions.assertEquals(2,user.getCars());

        String b = "baran";
        User user1 = new User();
        user1.setUsername(b);
        Assertions.assertNotNull(user1.getUsername());
        Methods.UsersList.add(user1);
        Assertions.assertTrue(Methods.ValidateUsername(b));

        Car car3 = new Ford();
        user1.AddCars(car3);
        car3.setRented(true);
        Assertions.assertTrue(car3.isRented());
        Assertions.assertEquals(1,user1.getCars());
    }

    @org.junit.jupiter.api.Test
    void rentedCars() {
        Car car1 = new Benz();
        car1.setRented(true);
        Assertions.assertTrue(car1.isRented());
        Methods.carList.add(car1);
        Assertions.assertNotNull(car1);
        Assertions.assertTrue(Methods.carList.contains(car1));

        Car car2 = new Ford();
        car2.setRented(false);
        Assertions.assertFalse(car2.isRented());
        Methods.carList.add(car2);
        Assertions.assertNotNull(car2);
        Assertions.assertTrue(Methods.carList.contains(car2));
    }

    @org.junit.jupiter.api.Test
    void availableCars() {
        Car car1 = new Ford();
        Assertions.assertEquals("FO-C" , car1.getSerialNumber());
        Assertions.assertFalse(car1.isRented());

        Car car2 = new Benz();
        Assertions.assertEquals("BE-C" , car2.getSerialNumber());
        car2.setRented(true);
        Assertions.assertTrue(car2.isRented());
    }

    @org.junit.jupiter.api.Test
    void validateUsername(){
        User user1 = new User();
        user1.setUsername("Payam");
        Assertions.assertEquals("Payam" , user1.getUsername());
        Methods.UsersList.add(user1);
        for (User user : Methods.UsersList)
            if (user.getUsername().equals("Payam")) {
                Assertions.assertEquals("Payam",user.getUsername());
            }
    }
}