package shipsStreamExample;

import java.util.Objects;

public class Ship {
    private String shipsType;
    private int gt;

    public Ship(String shipsType, int gt) {
        this.shipsType = shipsType;
        this.gt = gt;
    }

    public String getShipsType() {
        return shipsType;
    }

    public void setShipsType(String shipsType) {
        this.shipsType = shipsType;
    }

    public int getGt() {
        return gt;
    }

    public void setGt(int gt) {
        this.gt = gt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return gt == ship.gt && shipsType.equals(ship.shipsType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipsType, gt);
    }

    @Override
    public String toString() {
        return "shipsType = " + shipsType + ", GT = " + gt;
    }
}
