package chapter1;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class FilteringApple
{
    public static void main(String args[])
    {
        List<Apple> apples= Arrays.asList(
                new Apple("green",80),
                new Apple("blue",120),
                new Apple("green",60)
        );

        apples.stream()
                .filter(apple -> apple.getColour().equals("green"))
                .forEach(apple -> System.out.println(apple.getWeight()));
    }
}
