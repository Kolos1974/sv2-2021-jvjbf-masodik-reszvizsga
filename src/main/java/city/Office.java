package city;

public class Office extends Building{
    private String company;
    private int numberOfTablesPerLevel;

        public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;

        if ((area<(numberOfTablesPerLevel*2)) || (area>(numberOfTablesPerLevel*5))){
            throw new IllegalArgumentException();
        }
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (this.getLevels()-1)*numberOfTablesPerLevel;
    }
}
