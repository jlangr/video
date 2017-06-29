import java.util.ArrayList;
import java.util.List;

public class RentalCollection {
    private List<Rental> rentals = new ArrayList<>();
    private double totalAmount = 0;
    private int totalFrequentRenterPoints = 0;

    public void add(Rental rental) {
        rentals.add(rental);

        // optimization!
        totalAmount += rental.charge();
        totalFrequentRenterPoints += rental.getFrequentRenterPoints();
    }

    public List<Rental> rentals() {
        return rentals;
    }

    public int totalFrequentRenterPoints() {
        return totalFrequentRenterPoints;
    }

    public double totalAmount() {
        return totalAmount;
    }
}
