package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(Parameterized.class)
public class LionTest {

    private final String lionSex;
    private final boolean lionHasMane;

    private AutoCloseable autoCloseable;

    public LionTest(String lionSex, boolean lionHasMane) {
        this.lionSex = lionSex;
        this.lionHasMane = lionHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void after() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void doesHaveMane() throws Exception {

            Lion lion = new Lion(lionSex, null);
            boolean expectedHasMane = lion.doesHaveMane();
            Assert.assertEquals(expectedHasMane, lionHasMane);

    }

    @Test
    public  void doesHaveManeException() {
        Assert.assertThrows(Exception.class,() -> new Lion("Самей", null));
    }

}