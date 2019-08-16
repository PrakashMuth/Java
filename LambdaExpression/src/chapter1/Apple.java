package chapter1;

public class Apple
{
    private String colour;
    private int Weight;

    public Apple(String colour, int weight) {
        this.colour = colour;
        Weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "colour='" + colour + '\'' +
                ", Weight=" + Weight +
                '}';
    }
}
