public interface PriceStrategy {
    double charge(int daysRented);
    int frequentRenterPoints(int daysRented);
}
