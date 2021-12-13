package city;

import java.util.List;

public class City {
    private String name;
    private long area;
    private List<Building> buildings;

    public City(String name, long area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return area;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building){
        if (area>=(areaOfAllBuilding()+building.getArea())) {
            this.buildings.add(building);
        }
        throw new IllegalArgumentException();
    }

    public long areaOfAllBuilding(){
  //  public long getFullArea(){
        long result = 0;
        for (Building element: buildings){
            result += element.getArea();
        }

        return result;
    }


}
