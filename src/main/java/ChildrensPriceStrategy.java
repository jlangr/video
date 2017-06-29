public class ChildrensPriceStrategy implements PriceStrategy {
    @Override
    public double charge(int daysRented) {
        double charge = 1.5;
        if (daysRented > 3)
            charge += (daysRented - 3) * 1.5;
        return charge;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
