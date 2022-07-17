package Pojo;

public class Car {

    private boolean IsRented ;
    private String SerialNumber ;

    public Car() {
        if(this instanceof Ford) generateSerialNumber("FO-C");
        else generateSerialNumber("BE-C");
    }

    /////////////To Generate A SerialNumber
    private void generateSerialNumber(String serialnumber) {
        SerialNumber = serialnumber;
    }


    public boolean isRented() {
        return IsRented;
    }

    public void setRented(boolean rented) {
        IsRented = rented;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    @Override
    public String toString() {
        return "Users.Car{" +
                "IsRented=" + IsRented +
                ", SerialNumber='" + SerialNumber + '\'' +
                '}';
    }
}
