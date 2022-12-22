package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionMockTest {

    @Mock
    Feline feline;

    @Test
    public void getKittens() {
        Lion lion = new Lion(feline);
        when(feline.getKittens()).thenReturn(1);
        int kittens = lion.getKittens();
        Assert.assertEquals(kittens, 1);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(feline);
        List<String> strings = Arrays.asList("Рыба", "Мясо");
        when(feline.getFood("Хищник")).thenReturn(strings);
        Assert.assertEquals(lion.getFood(), strings);

    }
}