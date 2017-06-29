public class NewReleasePriceStrategy implements PriceStrategy {
    @Override
    public double charge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if (daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
