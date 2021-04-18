package com.polcodex.haskell;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class BMI {
    //bmiTell :: (RealFloat a) => a -> a -> String
    //bmiTell weight height
    //    | bmi <= 18.5 = "You're underweight, you emo, you!"
    //    | bmi <= 25.0 = "You're supposedly normal. Pffft, I bet you're ugly!"
    //    | bmi <= 30.0 = "You're fat! Lose some weight, fatty!"
    //    | otherwise   = "You're a whale, congratulations!"
    //    where bmi = weight / height ^ 2

    public static void main(String[] args) {
        System.out.println(calculateBmi(80.0, 1.70, weight -> height -> weight / Math.pow(height,2)));
    }

    //declaring method that is passing function to functions in JAVA is a challenge in context of formatting long lines :)
    public static String calculateBmi(Double weight, Double height, Function<Double, Function<Double, Double>> bmiFunc) {
        return Optional
                .ofNullable(getBmiMap().get(findRange(calculateBmiFactor(weight, height, bmiFunc))))
                .orElse("You're a whale, congratulations!");
    }

    //Curring in JAVA - why not.
    private static Double calculateBmiFactor(Double weight, Double height, Function<Double, Function<Double, Double>> bmiFunc) {
        return bmiFunc.apply(weight).apply(height);
    }

    private static Double findRange(Double bmi) {
        return getBmiMap()
                .keySet()
                .stream()
                .sorted()
                .reduce(0.0, (acc, el) -> acc < bmi && bmi < el ? el : acc);
    }

    private static Map<Double, String> getBmiMap() {
        return Map.of(18.5, "You're underweight, you emo, you!",
                25.0, "You're supposedly normal. Pffft, I bet you're ugly!",
                30.0, "You're fat! Lose some weight, fatty!");
    }
}
