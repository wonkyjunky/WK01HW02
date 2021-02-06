package com.example.wk01hw02;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void password_isCorrect() {
        assertNotEquals(true, MainActivity.checkPassword("beskar_4_ever"));
    }

    @Test
    public void username_isCorrect() {
        assertEquals(true, MainActivity.checkUsername("din_djarin"));
    }

}