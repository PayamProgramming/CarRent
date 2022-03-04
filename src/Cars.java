

public class Cars {

    private boolean IsRented ;
    private String SerialNumber ;

    public Cars() {
        if(this instanceof Ford) generateSerialNumber("FO-C");
        else generateSerialNumber("BE-C");
    }

    private void generateSerialNumber(String Code) {
        SerialNumber = Code;
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

    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "IsRented=" + IsRented +
                ", SerialNumber='" + SerialNumber + '\'' +
                '}';
    }
}
