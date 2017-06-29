public class RegularPriceStrategy implements PriceStrategy {
    @Override
    public double charge(int daysRented) {
        double charge = 2;
        if (daysRented > 2)
            charge += (daysRented - 2) * 1.5;
        return charge;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
