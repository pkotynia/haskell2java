package com.polcodex.haskell;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class BMITest {

    @ParameterizedTest
    @CsvSource(value = {"50.0:You're underweight, you emo, you!",
            "70.0:You're supposedly normal. Pffft, I bet you're ugly!",
            "80.0:You're fat! Lose some weight, fatty!",
            "100.0:You're a whale, congratulations!"}, delimiter = ':')
    void shouldCalculateBmi(Double input, String result) {
        //given
        //funny thing - var is not compiling, I guess type inference is not able to catch up
        //var bmiFunc = weight -> height -> weight / Math.pow(height,2);
        Function<Double, Function<Double, Double>> bmiFunc = weight -> height -> weight / Math.pow(height,2);
        var bmi  = new BMI();

        //when
        var res = bmi.calculateBmi(input,1.70, bmiFunc);

        //then
        assertThat(res).isEqualTo(result);
    }

}