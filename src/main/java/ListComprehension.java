import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListComprehension {

    public static void main(String[] args) {
        //ghci> [x*2 | x <- [1..10]]
        //[2,4,6,8,10,12,14,16,18,20]
        System.out.println("[x*2 | x <- [1..10]");
        System.out.println(IntStream.rangeClosed(1, 10)
                .map(x -> 2 * x)
                .boxed()
                .collect(Collectors.toList()));

        //ghci> [x*2 | x <- [1..10], x >= 6]
        //[12,14,16,18,20]
        System.out.println("[x*2 | x <- [1..10], x >= 6]");
        System.out.println(IntStream.rangeClosed(1, 10)
                .filter(x -> x >= 6)
                .map(x -> 2 * x)
                .boxed()
                .collect(Collectors.toList()));

        //ghci> [ x | x <- [50..100], x `mod` 7 == 3]
        //[52,59,66,73,80,87,94]
        System.out.println("[ x | x <- [50..100], x `mod` 7 == 3]");
        System.out.println(IntStream.rangeClosed(50, 100)
                .filter(x -> x%7 == 3)
                .boxed()
                .collect(Collectors.toList()));

        //boomBangs xs = [ if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]
        //ghci> boomBangs [7..13]
        //["BOOM!","BOOM!","BANG!","BANG!"]
        System.out.println("boomBangs xs = [ if x < 10 then \"BOOM!\" else \"BANG!\" | x <- xs, odd x]");
        System.out.println("boomBangs [7..13]");
        System.out.println(IntStream.rangeClosed(7, 13)
                .filter(x -> x%2 != 0)
                .boxed()
                .map(x -> x < 10 ? "BOOM" : "BANG")
                .collect(Collectors.toList()));
    }
}
