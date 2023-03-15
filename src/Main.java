import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1,2,3,99,77,55,8);
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

        System.out.println(integers.stream()
                .sorted(order)
                .collect(Collectors.toList()));

        Integer min = integers.get(integers.size() - 1);
        Integer max = integers.get(integers.get(0));

        findEven(integers);
    }
    //Задача 1
    public static <T> void findMinMax(Stream <? extends T> stream,
                                      Comparator <? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        T min = stream
                .min(order)
                .get();
        T max = stream
                .max(order)
                .get();

        BiConsumer<T,T> biConsumer = (t, t2) -> System.out.println("min: " + t + " max: " + t2);
  }

    //Задача 2
    public static void findEven(List<Integer> list) {
        List <Integer> num = Arrays.asList();
        list = list
                .stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
