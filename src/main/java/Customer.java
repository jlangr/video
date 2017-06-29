public class Customer {
    private String name;
    private RentalCollection rentalCollection = new RentalCollection();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentalCollection.add(rental);
    }

    public String statement() {
        return new TextStatement(name, rentalCollection).toString();
    }
}