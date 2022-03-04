import java.util.ArrayList;
import java.util.List;

public class User {

    private String username ;
    private List <Cars> RentedCars = new ArrayList();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List <Cars> getRentedCars() {
        return RentedCars;
    }

    public boolean AddCars(Cars Car) {
        if(RentedCars.size() > 2) {
            System.out.println("You Cannot Rent 3 Cars");
            return false;
        }
         else {
            RentedCars.add(Car);
            return true;
        }
    }

    public Cars RemoveCar(int index){
        Cars cars = RentedCars.get(index-1);
        RentedCars.remove(index-1);
        return cars;
    }

    public void setRentedCars(List<Cars> rentedcars) {
        RentedCars = rentedcars;
    }

    @Override
    public String toString() {
        String data = "";
        data += "username : "+username+" -- ";
        data += " Rented Cars : ";
        for(Cars cars : RentedCars){
            data+=cars.getSerialNumber()+",";
        }
        return data;
    }




}


