package com.polcodex.haskell;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.math.BigInteger.*;

public class Factorial {

    public static void main(String[] args) {
        //factorial :: (Integral a) => a -> a
        //factorial 0 = 1
        //factorial n = n * factorial (n - 1)

        System.out.println(factorial(100));
        System.out.println(factorialRecursion(BigInteger.valueOf(100)));
    }

    static BigInteger factorial(Integer n) {
        return Stream
                .iterate(ONE, i -> i.add(ONE))
                .limit(n)
                .reduce(ONE, BigInteger::multiply);
    }

    static BigInteger factorialRecursion(BigInteger n) {
        if (n.compareTo(TWO) <= 0) {
            return n;
        }
        return n.multiply(factorialRecursion(n.subtract(ONE)));
    }
}
