package realestate;

import java.util.TreeSet;

public class RealEstateApp {
        RealEstateAgent agent = new RealEstateAgent();
        TreeSet<RealEstate> actualStock = RealEstateAgent.stock;
        double sum_of_sqm = 0;
        double sum_of_price = 0;
        double minimum_price_till_now = Double.MAX_VALUE;
        RealEstate real_estate_with_minimum_price_till_now = null;
        double maximum_price_of_a_Budapest_property_till_now = 0;
        RealEstate most_expensive_Budapest_property_till_now = null;
        double summed_prices = 0;
        int sum_of_total_prices = 0;
        int count_of_properties = actualStock.size();
        public RealEstateApp() {
            for (RealEstate prop: actualStock) {
                sum_of_sqm += prop.sqm;
                sum_of_price += prop.price;
                if (prop.price < minimum_price_till_now) {
                    minimum_price_till_now = prop.price;
                    real_estate_with_minimum_price_till_now = prop;
                }
                if (prop.city.equalsIgnoreCase("Budapest") &&
                        prop.price > maximum_price_of_a_Budapest_property_till_now) {
                    maximum_price_of_a_Budapest_property_till_now = prop.price;
                    most_expensive_Budapest_property_till_now = prop;
                }
                summed_prices +=prop.price;
                sum_of_total_prices +=prop.getTotalPrice();
            }

        }
        double sumOfSqm() {
          return sum_of_sqm;}
        double sumOfPrices() {
            return sum_of_price;}
        double minimumPrice() {
            return minimum_price_till_now;}
        RealEstate mostExtensiveBudapestProperty(){
            return most_expensive_Budapest_property_till_now;}
        double summedPrices() {
            return summed_prices;}
        int sumOfTotalPrices() {
            return sum_of_total_prices;}


        public static void main(String[] a) {

            RealEstateApp app = new RealEstateApp();
            System.out.println("Average price for a sq meter: "
                    +(int)(app.summedPrices()/app.sumOfSqm()));
            System.out.println("The lowest price: "+app.minimumPrice());
            System.out.println("number of rooms value per sqm, of the most expensive Budapest property"+
                    app.mostExtensiveBudapestProperty().averageSqmPerRoom());
            System.out.println("The prices summed up "+app.summedPrices());
            System.out.println("list of comdominium genre flats whose "+
                    "total price exceeds the average of the total prices: ");
            for (RealEstate prop: app.actualStock) {
                if (prop.getTotalPrice() <
                        app.sumOfTotalPrices()/app.count_of_properties) {
                    System.out.println(prop);
                }
            }


        }

    }
