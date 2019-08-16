package chapter2.practice;

public class Transactions
{
    private final Traders traders;
    private final int year;
    private final int value;

    public Transactions(Traders traders, int year, int value) {
        this.traders = traders;
        this.year = year;
        this.value = value;
    }

    public Traders getTraders() {
        return traders;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "traders=" + traders +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
