import java.util.List;
import java.util.stream.Collectors;

public class Zip {

    private record Pair<T,Y>(T fst, Y snd) {}

    public static void main(String[] args) {
        //zip [1,2,3,4,5] [5,6,7,8,9]
        //[(1,5),(2,5),(3,5),(4,5),(5,5)]

        zip(List.of(1,2,3), List.of(5,6,7,8,9));

        //zip [5,3,2,6,2,7,2,5,4,6,6] ["im","a","turtle"]
        //[(5,"im"),(3,"a"),(2,"turtle")]

        zip(List.of(5,3,2,6,2,7,2,5,4,6,6), List.of("im","a","turtle"));
    }

    private static <T,Y> void zip(List<T> list1, List<Y> list2) {
        // Dirty hack with iterator, alternatively external lib like Vavr or Guava
        var iterator = list2.iterator();
        System.out.println(list1.stream()
                .filter(x -> iterator.hasNext())
                .map(x -> new Pair<T, Y>(x, iterator.next()))
                .collect(Collectors.toList()));
    }
}