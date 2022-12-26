package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int setKittensCount;
    private final int getSetKittensCount;

    public FelineTest(int setKittensCount, int getSetKittensCount) {
        this.setKittensCount = setKittensCount;
        this.getSetKittensCount = getSetKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
        };
    }

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> strings = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals(strings, feline.eatMeat());
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        Assert.assertEquals("Кошачьи", family);
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        Assert.assertEquals(kittens, 1);
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int countKittens = feline.getKittens(setKittensCount);
        Assert.assertEquals("Значения должны совпадать", countKittens, getSetKittensCount);
    }
}