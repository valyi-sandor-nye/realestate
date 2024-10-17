package realestate;

public class Panel extends RealEstate{
    int floor;
    boolean isInsulated;

    public Panel(String s, double v, int i, double v1, Genre newGen, int i1, boolean ins) {
        super(s,v,i,v1,newGen);
        floor = i1;
        isInsulated = ins;
    }

    @Override public String toString() {
        return "Panel{" +
                "floor=" + floor +
                ", isInsulated=" + isInsulated +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", sqm=" + sqm +
                ", numberOfRooms=" + numberOfRooms +
                ", genre=" + genre +
                '}';
    }
    @Override public int getTotalPrice() {
        double answer = super.getTotalPrice();
        if (floor >= 0 && floor <= 2) answer *= 1.05;
        if (floor == 10) answer *= 0.95;
        if (isInsulated) answer *= 1.05;
        return (int) Math.round(answer);
    }

}
