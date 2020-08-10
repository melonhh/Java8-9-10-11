package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        Comparator<Apple> lambda = (Apple o1, Apple o2) -> o1.getWeight() - o2.getWeight();

        List<Apple> apples = new ArrayList<>();

        apples.add(new Apple(3, "red"));
        apples.add(new Apple(2, "blue"));
        apples.add(new Apple(4, "abc"));

        apples.sort(lambda);

        apples.stream().forEach(System.out::println);

    }
}
