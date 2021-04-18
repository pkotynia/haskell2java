package com.polcodex.haskell;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListsMultiply {

    public static void main(String[] args) {
        //ghci> [ x*y | x <- [2,5,10], y <- [8,10,11]]
        //[16,20,22,40,50,55,80,100,110]

        System.out.println(multiplyLists(List.of(2, 5, 10), List.of(8, 10, 11), (x1, y1) -> x1 * y1));

        //ghci> let nouns = ["hobo","frog","pope"]
        //ghci> let adjectives = ["lazy","grouchy","scheming"]
        //ghci> [adjective ++ " " ++ noun | adjective <- adjectives, noun <- nouns]
        //["lazy hobo","lazy frog","lazy pope","grouchy hobo","grouchy frog",
        //"grouchy pope","scheming hobo","scheming frog","scheming pope"]

        System.out.println(multiplyLists(List.of("hobo", "frog", "pope"), List.of("lazy", "grouchy", "scheming"), (x, y) -> y + " " + x));

    }

    private static <T> List<T> multiplyLists(List<T> list1, List<T> list2, BiFunction<T, T, T> merge) {
        return list1.stream()
                .flatMap(x -> list2.stream().map(y -> merge.apply(x,y)))
                .collect(Collectors.toList());
    }

}
