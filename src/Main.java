

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static List <Cars> CarsList = new ArrayList <>();
    static List <User> UsersList = new ArrayList <>();

    public static void main(String[] args) {
    Menu();
    }

        private static void Menu() {
            Scanner in = new Scanner(System.in);
            System.out.println("Menu-->");
            System.out.println("1.Available Cars.");
            System.out.println("2.Rented Cars.");
            System.out.println("3.Load Data.");
            System.out.println("4.Rent Cars.");
            System.out.println("5.Add New Car.");
            System.out.println("6.Add New User");
            System.out.println("7.Cars List");
            System.out.println("8.Users List");
            System.out.println("9.Exit");
            System.out.println("Choose The Number You Want : ");
            int num = in.nextInt();
            switch (num){
                case 1 :
                    AvailableCars();
                    break;
                case 2 :
                    RentedCars();
                    break;
                case 3 :
                    LoadData();
                    break;
                case 4:
                    RentCars();
                    break;
                case 5 :
                    AddCar();
                    break;
                case 6 :
                    AddUser();
                    break;
                case 7 :
                    CarsList();
                    break;
                case 8 :
                    UsersList();
                    break;
                case 9 :
                    Exit();
                    break;
                default:
                    break;
            }
        }

    private static void LoadData() {
    ReadUsersFromFile();
    ReadCarsFromFile();
        System.out.println("Loaded Successfully");
    Menu();
    }

    private static void Exit() {
        SaveUserToFile();
        SaveBikeToFile();
    }

    private static void UsersList() {
        int count = 1 ;
        for(User user : UsersList){
            System.out.println(count + "." + user.toString());
            count ++ ;
        }
        Menu();
    }

    private static void CarsList() {
        int count = 1 ;
        for(Cars cars : CarsList){
            System.out.println(count + "." + cars.toString());
            count ++ ;
        }
        Menu();
    }

    private static void AddUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Username : ");
        String username = input.next();
        User user = new User();
        user.setUsername(username);
        UsersList.add(user);
        System.out.println("User Added Successfully");
        Menu();
    }

    private static void AddCar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number Of Car : ");
        System.out.println("1.Ford");
        System.out.println("2.Benz");
        int car = input.nextInt();
        if (car == 1) {
            CarsList.add(new Ford());
            System.out.println("Ford Added .");
        }
        else if (car == 2) {
            CarsList.add(new Benz());
            System.out.println("Benz Added .");
        } else
            System.out.println("Car Doesnt Exist");
        Menu();
    }

    private static void RentCars() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Username : ");
        String username = input.nextLine();
        if(ValidateUsername(username)){
            BenzCount();
            FordCount();
            System.out.println("Available Benz Cars : " + BenzCount());
            System.out.println("Available Ford Cars : " + FordCount());
            System.out.println("Enter The Number Of Car\n1.Ford\n2.Benz");
            Scanner input2 = new Scanner(System.in);
            int number = input2.nextInt();
            if(number == 1){
                RentFord(username);
            }else if (number == 2) {
                RentBenz(username);
            } else System.out.println("Car Doesnt Exist");

        }else System.out.println("Username Doesnt Exist");
        Menu();

    }


    private static void RentedCars() {
        int count = 1 ;
        for (Cars cars : CarsList) {
            if (cars.isRented()) {
                if (cars instanceof Ford) {
                    System.out.println(count + ".Ford = " + cars.getSerialNumber());
                } else if (cars instanceof Benz) {
                    System.out.println(count + ".Benz = " + cars.getSerialNumber());
                }
                count++;
            }

        }
        Menu();
    }


    private static void AvailableCars() {
        int count = 1 ;
        for (Cars cars : CarsList) {
            if (!cars.isRented()) {
                if (cars instanceof Ford) {
                    System.out.println(count + ".Ford = " + cars.getSerialNumber());
                } else if (cars instanceof Benz) {
                    System.out.println(count + ".Benz = " + cars.getSerialNumber());
                }
                count++;
            }

        }
        Menu();
    }

    private static boolean ValidateUsername(String username){
        for(User user : UsersList)
            if(user.getUsername().equals(username)){
                return true ;
            }
        return false ;

    }

    private static int BenzCount() {
        int count = 0 ;
    for(Cars cars : CarsList)
        if(cars instanceof Benz && !cars.isRented()){
        count ++ ;
        }
    return count  ;
    }

    private static int FordCount() {
        int count = 0 ;
        for(Cars cars : CarsList)
            if(cars instanceof Ford && !cars.isRented()){
                count ++ ;
            }
        return count ;
    }

    private static void RentBenz(String username) {

        boolean check = false;
        for(Cars car : CarsList){
            if(car instanceof Benz && !car.isRented()){
                car.setRented(true);
                for(User user : UsersList){
                    if(user.getUsername().equals(username)) {
                        if (user.AddCars(car))
                            System.out.println("Benz Rented to : " + username);
                        check = true;
                        break;
                    }
                }
            }
            if(check) break;
        }
    }

    private static void RentFord(String username) {
        boolean check = false;
        for(Cars car : CarsList){
            if(car instanceof Ford && !car.isRented()){
                car.setRented(true);
                for(User user : UsersList){
                    if(user.getUsername().equals(username)) {
                        if (user.AddCars(car))
                            System.out.println("Ford Rented to : " + username);
                        check = true;
                        break;
                    }
                }
            }
            if(check) break;
        }
    }

    private static void SaveBikeToFile(){
        try {
            FileWriter file = new FileWriter("CarInfo.txt");
            for(Cars car : CarsList){
                file.write(car.getSerialNumber()+";"+car.isRented()+";\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void SaveUserToFile(){
        try {
            FileWriter file = new FileWriter("UserInfo.txt");
            for(User user : UsersList){
                StringBuilder info = new StringBuilder(user.getUsername() + ";");
                for(Cars car : user.getRentedCars()){
                    info.append(car.getSerialNumber()).append(";").append(car.isRented()).append(";");
                }
                file.write(info+"\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void ReadCarsFromFile(){
        try {
            FileReader file = new FileReader("CarInfo.txt");
            BufferedReader bf = new BufferedReader(file);
            String line;
            while((line=bf.readLine())!=null){
                StringTokenizer tokens = new StringTokenizer(line,";");
                String serialNumber = tokens.nextToken();
                if(serialNumber.equals("FO-C")){
                    Cars ford = new Ford();
                    ford.setRented(Boolean.parseBoolean(tokens.nextToken()));
                    CarsList.add(ford);
                }else{
                    Cars benz = new Benz();
                    benz.setRented(Boolean.parseBoolean(tokens.nextToken()));
                    CarsList.add(benz);
                }
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void ReadUsersFromFile(){
        try {
            FileReader file = new FileReader("UserInfo.txt");
            BufferedReader bf = new BufferedReader(file);
            String line;
            while((line=bf.readLine())!=null){
                StringTokenizer tokens = new StringTokenizer(line,";");
                User user = new User();
                user.setUsername(tokens.nextToken());
                List<Cars> usercarList = new ArrayList<>();
                while(tokens.hasMoreTokens()){
                    String serialNumber = tokens.nextToken();
                    if(serialNumber.equals("FO-C")){
                        Cars ford = new Ford();
                        ford.setRented(Boolean.parseBoolean(tokens.nextToken()));
                        CarsList.add(ford);
                    }else{
                        Cars benz = new Benz();
                        benz.setRented(Boolean.parseBoolean(tokens.nextToken()));
                        CarsList.add(benz);
                    }
                }
                user.setRentedCars(usercarList);
                UsersList.add(user);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}




