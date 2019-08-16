package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy
{
    public static void main(String args[])
    {
          List<Dish> menu = Arrays.asList(
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

          //1.group by groupDishByName
        Map<Dish.Type,List<Dish>> groupDishByName=menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println("groupDishByName" + groupDishByName + "\n");
        //2.filter and groupDishByName
        Map<Dish.Type,List<Dish>> groupDishByNamefilter=menu
                .stream()
                .filter(m -> m.isVegetarian())
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println("FiltergroupDishByName" + groupDishByNamefilter);
        //3.filter and groupDishByName
        Map<Dish.Type,List<Dish>> filtergroupDishByName=menu
                .stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.filtering(d -> d.isVegetarian(),Collectors.toList())));
        System.out.println("filtergroupDishByName" + filtergroupDishByName);

        //4.mapping mapgroupDishByName
        Map<Boolean, Map<String, List<Dish>>> mapgroupDishByName=menu
                .stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian
                                        ,Collectors.groupingBy(Dish::getName)));
        System.out.println("mapgroupDishByName" + mapgroupDishByName);
    }
}
