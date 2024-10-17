package realestate;

public class RealEstate implements RealEstateInterface, Comparable<RealEstate>{
    String city;
    double price; //for a square meter
    int sqm;
    double numberOfRooms;
    Genre genre;

    public RealEstate(String city, double price, int sqm,
                      double numberOfRooms, Genre genre) {
        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.numberOfRooms = numberOfRooms;
        this.genre = genre;
    }

    public RealEstate() {
    }

    @Override
    public void makeDiscount(int percent) {
        if (percent>0 && percent<=100)
        price -= price*percent/100.0;
    }

    @Override
    public int getTotalPrice() {
        double ratio = 1.0;
        switch (city) {
            case "Budapest": ratio = 1.3; break;
            case "Debrecen": ratio = 1.2; break;
            case "Nyíregyháza": ratio = 1.15; break;
        }
        return (int) Math.round(sqm * price * ratio);
    }

    @Override
    public double averageSqmPerRoom() {
        return sqm / numberOfRooms;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "city='" + city + '\'' +
                ", price=" + price +
                ", sqm=" + sqm +
                ", numberOfRooms=" + numberOfRooms +
                ", genre=" + genre +
                '}';
    }

    @Override
    public int compareTo(RealEstate other) {
        if (price<other.price) return -1;
        else if (price>other.price) return 1;
        else if (sqm<other.sqm) return -1;
        else if (sqm>other.sqm) return 1;
        else if (numberOfRooms<other.numberOfRooms) return -1;
        else if (numberOfRooms> other.numberOfRooms) return 1;
        else return 0;

    }


}

