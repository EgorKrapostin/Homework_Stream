import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 99, 77, 55, 8);
        Comparator<Integer> order = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        BiConsumer<Integer, Integer> minMaxConsumer = (t, t2) -> System.out.println("min: " + t + " max: " + t2);

        findMinMax(integers.stream(),order, minMaxConsumer);
        findEven(integers);
    }

    //Задача 1
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> intList = stream
                .sorted(order)
                .collect(Collectors.toList());

        T min = intList.get(0);
        T max = intList.get(intList.size() - 1);

        minMaxConsumer.accept(min, max);
    }

    //Задача 2
    public static void findEven(List<Integer> list) {
        list = list
                .stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
