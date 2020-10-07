package com.challenger.challenge.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainStep1Test {

    private MainStep1 step1;

    @BeforeEach
    public void init() {
        step1 = new MainStep1();
    }

    @Test
    public void range1And20() {
        assertEquals("1 2 CMAS 4 systems CMAS 7 8 CMAS systems 11 CMAS 13 14 CMASsystemsCMASsystems 16 17 CMAS 19 systems.", step1.print(1, 20));
    }

    @Test
    public void range1And5() {
        assertEquals("1 2 CMAS 4 systems.", step1.print(1, 5));
    }

    @Test
    public void range1And2() {
        assertEquals("1 2.", step1.print(1, 2));
    }

    @Test
    public void incorrectRange() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> step1.print(2, 1));
        assertEquals("The range informed was wrong.", exception.getMessage());
    }

}
