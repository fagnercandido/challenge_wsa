package com.challenger.challenge.step2;

import com.challenger.challenge.step1.MainStep1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainStep2Test {

    private MainStep2 step2;

    @BeforeEach
    public void init() {
        step2 = new MainStep2();
    }

    @Test
    public void range1And20() {
        assertEquals("1 2 good 4 systems good 7 8 good systems 11 good 13 14 goodsystemsCMASsystems 16 17 good 19 systems.", step2.print(1, 20));
    }

    @Test
    public void range1And5() {
        assertEquals("1 2 good 4 systems.", step2.print(1, 5));
    }

    @Test
    public void range1And2() {
        assertEquals("1 2.", step2.print(1, 2));
    }

    @Test
    public void incorrectRange() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> step2.print(2, 1));
        assertEquals("The range informed was wrong.", exception.getMessage());
    }

}
