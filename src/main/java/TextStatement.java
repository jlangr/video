public class TextStatement {
    private String name;
    private RentalCollection rentalCollection;

    public TextStatement(String name, RentalCollection rentalCollection) {
        this.name = name;
        this.rentalCollection = rentalCollection;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String result = header();
        for (Rental rental: rentalCollection.rentals())
            result += detail(rental);
        result += totalFooter();
        result += frequentRenterPointsFooter();
        return result;
    }

    private String detail(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.charge()) + "\n";
    }

    private String frequentRenterPointsFooter() {
        return "You earned " + String.valueOf(rentalCollection.totalFrequentRenterPoints()) + " frequent renter points\n";
    }

    private String totalFooter() {
        return "You owed " + String.valueOf(rentalCollection.totalAmount()) + "\n";
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }
}
