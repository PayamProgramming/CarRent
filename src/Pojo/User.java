package Pojo;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username ;
    private List <Car> rentedCars = new ArrayList <>();
    private int cars ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List <Car> getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(List<Car> rentedcars) {
        rentedCars = rentedcars;
    }

    public int getCars() {
        return cars;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    //////////////// To Add Users.Car+
    public boolean AddCars(Car car) {
        if(rentedCars.size() > 2) {
            System.out.println("You Cannot Rent 3 Cars");
            return false;
        }
        else {
            rentedCars.add(car);
            cars++;
            return true;
        }
    }


    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append("username : ").append(username).append(" -- ");
        data.append(" Rented Cars : ");
        for(Car car : rentedCars){
            data.append(car.getSerialNumber()).append(",");
        }
        return data.toString();
    }




}


