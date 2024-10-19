package realestate;

public class RealEstate implements RealEstateInterface, Comparable<RealEstate>{
    protected String city;
    protected double price; //for a square meter
    protected int sqm;
    protected double numberOfRooms;
    protected Genre genre;

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
           price -= percent;
    }

    @Override
    public int getTotalPrice() {
        double ratio = 1.0;
        switch (city) {
            case "Budapest": ratio = 1.3; break;
            case "Debrecen": ratio = 1.2; break;
            case "Nyíregyháza": ratio = 1.15; break;
            default: break;
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




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSqm() {
        return sqm;
    }

    public void setSqm(int sqm) {
        this.sqm = sqm;
    }

    public double getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(double numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

