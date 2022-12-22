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
public class CatTest {


    @Mock
    Feline feline;



    @Test
    public void getSound() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        Assert.assertEquals("Мяу", sound);

    }

    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> strings = Arrays.asList("Рыба", "Мясо");
        when(feline.eatMeat()).thenReturn(strings);
        Assert.assertEquals(cat.getFood(), strings);
    }
}