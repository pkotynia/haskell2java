import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RightTriangles {

    //ghci> let rightTriangles' = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b], a^2 + b^2 == c^2, a+b+c == 24]
    //ghci> rightTriangles'
    //[(6,8,10)]

    public static void main(String[] args) {
        System.out.println(rightTriangles(listFromRange(1, 10), listFromRange(1, 10), listFromRange(1, 10), 24));
    }

    private static List<Triangle> rightTriangles(List<Integer> list1, List<Integer> list2, List<Integer> list3, Integer perimeter) {
        return list1.stream()
                .flatMap(x -> list2.stream().flatMap(y -> list3.stream().map(z -> new Triangle(x,y,z))))
                .filter(triangle -> triangle.b <= triangle.c && triangle.a <= triangle.b)
                .filter(triangle -> Math.pow(triangle.a, 2) + Math.pow(triangle.b, 2) == Math.pow(triangle.c, 2))
                .filter(triangle -> triangle.a + triangle.b + triangle.c == perimeter)
                .collect(Collectors.toList());
    }

    private static List<Integer> listFromRange(int first, int last) {
        return IntStream.rangeClosed(first, last).boxed().collect(Collectors.toList());
    }

    record Triangle(Integer a, Integer b, Integer c) {
        public Triangle(Integer a, Integer b, Integer c) {
            this.a = a;
            this.b = b;
            this.c = c;
            System.out.println("creating tuple " + this);
        }
    };
}
