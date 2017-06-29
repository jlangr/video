public class PriceStrategyFactory {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    public PriceStrategy create(int code) {
        switch (code) {
            case CHILDRENS:
                return new ChildrensPriceStrategy();
            case REGULAR:
                return new RegularPriceStrategy();
            case NEW_RELEASE:
                return new NewReleasePriceStrategy();
        }
        return null;
    }
}
