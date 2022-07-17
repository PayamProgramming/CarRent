package Method;

import Pojo.Benz;
import Pojo.Car;
import Pojo.Ford;
import Pojo.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Methods {

    static List <Car> carList = new ArrayList <>();
    static List <User> UsersList = new ArrayList <>();


    static void LoadData() {
        ReadUsersFromFile();
        ReadCarsFromFile();
        System.out.println("Loaded Successfully");
        Main.Menu();
    }

    static void Exit() {
        SaveUserToFile();
        SaveCarToFile();
    }

    static void UsersList() {
        int count = 1;
        for (User user : UsersList) {
            System.out.println(count + "." + user.toString());
            count++;
        }
        Main.Menu();
    }

    static void CarsList() {
        int count = 1;
        for (Car car : carList) {
            System.out.println(count + "." + car.toString());
            count++;
        }
        Main.Menu();
    }

    static void AddUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Username : ");
        String username = input.next();
        User user = new User();
        user.setUsername(username);
        UsersList.add(user);
        System.out.println("User Added Successfully");
        Main.Menu();
    }

    static void AddCar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number Of Car : ");
        System.out.println("1.Ford");
        System.out.println("2.Benz");
        int car = input.nextInt();
        if (car == 1) {
            carList.add(new Ford());
            System.out.println("Ford Added .");
        } else if (car == 2) {
            carList.add(new Benz());
            System.out.println("Benz Added .");
        } else
            System.out.println("Car Doesnt Exist");
        Main.Menu();
    }

    static void RentCars(String username) {
        System.out.println("Enter Username : ");
        if (ValidateUsername(username)) {
            BenzCount();
            FordCount();
            System.out.println("Available Benz Cars : " + BenzCount());
            System.out.println("Available Ford Cars : " + FordCount());
            System.out.println("Enter The Number Of Car\n1.Ford\n2.Benz");
            Scanner input2 = new Scanner(System.in);
            int number = input2.nextInt();
            if (number == 1) {
                RentFord(username);
            } else if (number == 2) {
                RentBenz(username);
            } else System.out.println("Car Doesnt Exist");

        } else System.out.println("Username Doesnt Exist");
        Main.Menu();
    }


    static void RentedCars() {
        int count = 0;
        for (Car car : carList) {
            if (car.isRented()) {
                if (car instanceof Ford) {
                    System.out.println(count + ".Ford = " + car.getSerialNumber());
                } else if (car instanceof Benz) {
                    System.out.println(count + ".Benz = " + car.getSerialNumber());
                }
                count++;
            }

        }
        Main.Menu();
    }


    static void AvailableCars() {
        int count = 1;
        for (Car car : carList) {
            if (!car.isRented()) {
                if (car instanceof Ford) {
                    System.out.println(count + ".Ford = " + car.getSerialNumber());
                } else if (car instanceof Benz) {
                    System.out.println(count + ".Benz = " + car.getSerialNumber());
                }
                count++;
            }

        }
        Main.Menu();
    }

    public static boolean ValidateUsername(String username) {
        for (User user : UsersList)
            if (user.getUsername().equals(username)) {
                return true;
            }
        return false;

    }

    private static int BenzCount() {
        int count = 0;
        for (Car car : carList)
            if (car instanceof Benz && !car.isRented()) {
                count++;
            }
        return count;
    }

    private static int FordCount() {
        int count = 0;
        for (Car car : carList)
            if (car instanceof Ford && !car.isRented()) {
                count++;
            }
        return count;
    }

    public static void RentBenz(String username) {

        boolean check = false;
        for (Car car : carList) {
            if (car instanceof Benz && !car.isRented()) {
                car.setRented(true);
                for (User user : UsersList) {
                    if (user.getUsername().equals(username)) {
                        if (user.AddCars(car))
                            System.out.println("Benz Rented to : " + username);
                        check = true;
                        break;
                    }
                }
            }
            if (check) break;
        }
    }

    private static void RentFord(String username) {
        boolean check = false;
        for (Car car : carList) {
            if (car instanceof Ford && !car.isRented()) {
                car.setRented(true);
                for (User user : UsersList) {
                    if (user.getUsername().equals(username)) {
                        if (user.AddCars(car))
                            System.out.println("Ford Rented to : " + username);
                        check = true;
                        break;
                    }
                }
            }
            if (check) break;
        }
    }

    private static void SaveCarToFile() {
        try {
            FileWriter file = new FileWriter("CarInfo.txt");
            for (Car car : carList) {
                file.write(car.getSerialNumber() + ";" + car.isRented() + ";\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void SaveUserToFile() {
        try {
            FileWriter file = new FileWriter("UserInfo.txt");
            for (User user : UsersList) {
                StringBuilder info = new StringBuilder(user.getUsername() + ";");
                for (Car car : user.getRentedCars()) {
                    info.append(car.getSerialNumber()).append(";").append(car.isRented()).append(";");
                }
                file.write(info + "\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void ReadCarsFromFile() {
        try {
            FileReader file = new FileReader("CarInfo.txt");
            BufferedReader bf = new BufferedReader(file);
            String line;
            while ((line = bf.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, ";");
                String serialNumber = tokens.nextToken();
                if (serialNumber.equals("FO-C")) {
                    Car ford = new Ford();
                    ford.setRented(Boolean.parseBoolean(tokens.nextToken()));
                    carList.add(ford);
                } else {
                    Car benz = new Benz();
                    benz.setRented(Boolean.parseBoolean(tokens.nextToken()));
                    carList.add(benz);
                }
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void ReadUsersFromFile() {
        try {
            FileReader file = new FileReader("UserInfo.txt");
            BufferedReader bf = new BufferedReader(file);
            String line;
            while ((line = bf.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, ";");
                User user = new User();
                user.setUsername(tokens.nextToken());
                List <Car> supercarList = new ArrayList <>();
                while (tokens.hasMoreTokens()) {
                    String serialNumber = tokens.nextToken();
                    if (serialNumber.equals("FO-C")) {
                        Car ford = new Ford();
                        ford.setRented(Boolean.parseBoolean(tokens.nextToken()));
                        carList.add(ford);
                    } else {
                        Car benz = new Benz();
                        benz.setRented(Boolean.parseBoolean(tokens.nextToken()));
                        carList.add(benz);
                    }
                }
                user.setRentedCars(supercarList);
                UsersList.add(user);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
