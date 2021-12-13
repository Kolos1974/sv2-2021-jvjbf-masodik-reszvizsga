package city;

public class Address {
    private String street;
    private int buildingNumber;
    /*
        A házszám elvileg lehetne 2/b is. Ekkor String-et kellene használnunk.
     */

    public Address(String street, int buildingNumber) {
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }
}
