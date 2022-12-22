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
    private final Class<Exception> exception;
    private AutoCloseable autoCloseable;

    public LionTest(String lionSex, boolean lionHasMane, Class<Exception> exception) {
        this.lionSex = lionSex;
        this.lionHasMane = lionHasMane;
        this.exception = exception;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"Самец", true, null},
                {"Самка", false, null},
                {"Самей", false, Exception.class},
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
        if(exception != null) {
            Assert.assertThrows(exception, () -> new Lion(lionSex));
        } else {
            Lion lion = new Lion(lionSex);
            boolean expectedHasMane = lion.doesHaveMane();
            Assert.assertEquals(expectedHasMane, lionHasMane);
        }

    }

}