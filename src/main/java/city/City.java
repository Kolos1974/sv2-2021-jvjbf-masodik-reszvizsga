package city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long area) {
        this.name = name;
        this.fullArea = area;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        if (fullArea >= (areaOfAllBuilding() + building.getArea())) {
            this.buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than "+this.getFullArea());
        }
    }

    public long areaOfAllBuilding() {
        long result = 0;
        for (Building element : buildings) {
            result += element.getArea();
        }

        return result;
    }

    public Building findHighestBuilding(){
        Building result = buildings.get(0);
        for (Building element: buildings){
            if (result.getLevels()<element.getLevels()){
                result = element;
            }
        }
        return result;
    }

    public List<Building> findBuildingsByStreet(String street){
        List<Building> result = new ArrayList<>();
        for (Building element: buildings){
            if (street.equals(element.getAddress().getStreet())){
                result.add(element);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople){
        for (Building element : buildings){
            if (element.calculateNumberOfPeopleCanFit()>numberOfPeople){
                return true;
            }
        }
        return false;
    }

}
