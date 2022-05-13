import java.util.ArrayList;
import java.util.List;

public class User {

    private String username ;
    private List <Cars> RentedCars = new ArrayList <>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List <Cars> getRentedCars() {
        return RentedCars;
    }

    //////////////// To Add Cars+
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

    public void setRentedCars(List<Cars> rentedcars) {
        RentedCars = rentedcars;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append("username : ").append(username).append(" -- ");
        data.append(" Rented Cars : ");
        for(Cars cars : RentedCars){
            data.append(cars.getSerialNumber()).append(",");
        }
        return data.toString();
    }




}


