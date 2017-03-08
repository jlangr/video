
import java.util.*;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = header();
        for (Rental rental: rentals) result += detailRow(rental);
        result += totalAmountFooter();
        result += totalPointsFooter();
        return result;
    }

    private String totalPointsFooter() {
        return "You earned " + String.valueOf(calculateTotalFreqRenterPoints()) + " frequent renter points\n";
    }

    private String totalAmountFooter() {
        return "You owed " + String.valueOf(calculateTotalPrice()) + "\n";
    }

    private int calculateTotalFreqRenterPoints() {
        return rentals.stream().mapToInt(this::calculateFrequentRenterPoints).sum();
    }

    private double calculateTotalPrice() {
        return rentals.stream().mapToDouble(this::calculatePrice).sum();
    }

    private String detailRow(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(calculatePrice(rental)) + "\n";
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    private int calculateFrequentRenterPoints(Rental rental) {
        int frequentRenterPoints = 1;
        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private double calculatePrice(Rental rental) {
        double price = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                price += 2;
                if (rental.getDaysRented() > 2)
                    price += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                price += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                price += 1.5;
                if (rental.getDaysRented() > 3)
                    price += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return price;
    }
}