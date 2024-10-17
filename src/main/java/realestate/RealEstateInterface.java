package realestate;

public interface RealEstateInterface {
    void makeDiscount(int percent);
    int getTotalPrice();
    double averageSqmPerRoom();
    String toString(); // It is superfluous
}
