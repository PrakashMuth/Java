package chapter2.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Solutions {
    public static void main(String args[]) {
        Traders s1 = new Traders("s1", "coimbatore");
        Traders s2 = new Traders("s2", "chennai");
        Traders s3 = new Traders("s3", "coimbatore");
        Traders s4 = new Traders("s4", "madurai");
        Traders s5 = new Traders("s4", "coimbatore");

        List<Transactions> transactions = Arrays.asList(
                new Transactions(s1, 2011, 300),
                new Transactions(s1, 2012, 1000),
                new Transactions(s2, 2011, 800),
                new Transactions(s3, 2011, 710),
                new Transactions(s4, 2012, 300),
                new Transactions(s5, 2011, 550)
        );

        //1.find all transactions in 2011 and sort by value
        List<Transactions> findtransactions2011 = transactions
                .stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transactions::getValue))
                .collect(Collectors.toList());
        System.out.println("findtransactions2011" + findtransactions2011);

        //2.unique cities in trader work
        List<String> uniquecity = transactions
                .stream()
                .map(t -> t.getTraders().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("uniquecity" + uniquecity);

        //3.find coimbatore sort by name
        List<Traders> name = transactions
                .stream()
                .map(Transactions::getTraders)
                .filter(traders -> traders.getCity().equals("coimbatore"))
                .sorted(Comparator.comparing(Traders::getName))
                .collect(Collectors.toList());
        System.out.println("find coimbatore sort by name" + name);

        //4.Return a string of all traders’ names sorted alphabetically
        String tradername = transactions
                .stream()
                .map(t -> t.getTraders().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println("tradername" + tradername);

        //5.any match
        boolean trname = transactions
                .stream()
                .anyMatch(t -> t.getTraders().getCity().equals("coimbatore"));
        System.out.println(trname);

        //6.Print the values of all transactions from the traders living in Coimbatore
        transactions
                .stream()
                .filter(t -> t.getTraders().getCity().equals("coimbatore"))
                .map(Transactions::getValue)
                .forEach(System.out::println);
        //7.What’s the highest value of all the transactions
        Optional<Integer> max = transactions
                .stream()
                .map(Transactions::getValue)
                .reduce(Integer::max);
        System.out.println(max);

        //7.What’s the smallest value of all the transactions
        Optional<Integer> min = transactions
                .stream()
                .map(Transactions::getValue)
                .reduce(Integer::min);

        Optional<Integer> tempmin = transactions
                .stream()
                .map(Transactions::getValue)
                .reduce(Integer::sum);
        System.out.println(tempmin);
    }
}
