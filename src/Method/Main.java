package Method;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu();
    }

    static void Menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Menu-->");
        System.out.println("1.Available Cars");
        System.out.println("2.Rented Cars");
        System.out.println("3.Load Data");
        System.out.println("4.Rent Cars");
        System.out.println("5.Add New Car");
        System.out.println("6.Add New User");
        System.out.println("7.Cars List");
        System.out.println("8.Users List");
        System.out.println("9.Exit & Save");
        System.out.println("Choose The Number You Want : ");
        int num = in.nextInt();
        switch (num) {
            case 1:
                Method.Methods.AvailableCars();
                break;
            case 2:
                Method.Methods.RentedCars();
                break;
            case 3:
                Method.Methods.LoadData();
                break;
            case 4:
                Method.Methods.RentCars();
                break;
            case 5:
                Method.Methods.AddCar();
                break;
            case 6:
                Method.Methods.AddUser();
                break;
            case 7:
                Method.Methods.CarsList();
                break;
            case 8:
                Method.Methods.UsersList();
                break;
            case 9:
                Method.Methods.Exit();
                break;
            default:
                break;
        }
    }


}




