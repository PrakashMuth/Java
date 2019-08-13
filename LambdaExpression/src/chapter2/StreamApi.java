package chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi
{
    public static void main(String args[])
    {
        final List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 400, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
        //stream by name
        List<String> highCalloriesName=menu.stream()
                .filter(dish -> dish.getCalories() > 400)
                .map(Dish::getName)
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(highCalloriesName);

        //stream by length
        List<Integer> highCalloriesNamelength=menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(highCalloriesNamelength);

        List<Integer> numbers=Arrays.asList(1,5,6,7,2,9,10);
        //int sum 1+5+6+7+2+9+10
        Optional<Integer> product=numbers.stream()
                .reduce((a,b) -> a + b );
        //int max
        Optional<Integer> max=numbers.stream()
                .reduce(Integer::max);
        System.out.println("111" + product + "222" + max);

        Optional<Integer> min=numbers.stream()
                .reduce(Integer::min);
        System.out.println("min" + min + "min");

        //filter
        List<Integer> num=Arrays.asList(1,2,3,6,3,2,1,8,4);
        num.stream()
                .filter(i -> i%2 == 0)
                .distinct()
                .forEach(System.out::print);

        //filter vs takefilter java9
         Stream.of(1,2,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1)
                .filter(integer -> integer < 4)
                .forEach(System.out::println);
         //takefilter
        Stream.of(1,2,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1)
                .dropWhile(integer -> integer < 4)
                .forEach(System.out::println);

        //wordlength using map
       List<String> words=Arrays.asList("modern","in","java","action");
       List<Integer> wordlength=words.stream()
               .map(String::length)
               .collect(Collectors.toList());
       System.out.println(wordlength);
    }
}
