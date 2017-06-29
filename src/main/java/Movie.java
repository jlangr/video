public class Movie {
    private String title;
    private PriceStrategy priceStrategy;

    public Movie(String title, int priceCode) {
        this.title = title;
        priceStrategy = new PriceStrategyFactory().create(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public double charge(int daysRented) {
        return priceStrategy.charge(daysRented);
    }

    public int frequentRenterPoints(int daysRented) {
        return priceStrategy.frequentRenterPoints(daysRented);
    }
}