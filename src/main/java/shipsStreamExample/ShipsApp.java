package shipsStreamExample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShipsApp {
    public static void main(String[] args) {
        List<Ship> shipList = new ArrayList<>();
        shipList.add(new Ship("container ship", 41357));
        shipList.add(new Ship("container ship", 153148));
        shipList.add(new Ship("container ship", 153148)); //distinct() -remove duplicates
        shipList.add(new Ship("errv", 125));
        shipList.add(new Ship("OSV", 2295));

        System.out.println(shipList);

        shipList = shipList.stream().distinct().collect(Collectors.toList());

        System.out.println(shipList);

        List<Ship> shipMoreThan10_000GT = shipList.stream().
                filter(ship -> ship.getGt()>10000).collect(Collectors.toList());

        System.out.println("List of ships: " + shipMoreThan10_000GT);
    }
}
