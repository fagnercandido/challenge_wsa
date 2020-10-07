package com.challenger.challenge.step3;

import com.challenger.challenge.step1.MainStep1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainStep3Test {

    private MainStep3 step3;

    @BeforeEach
    public void init() {
        step3 = new MainStep3();
    }

    @Test
    public void range1And20() {
        assertEquals("1 2 CMAS 4 systems CMAS 7 8 CMAS systems 11 CMAS 13 14 CMASsystemsCMASsystems 16 17 CMAS 19 systems.", step3.print(1, 20));
    }

    @Test
    public void range1And5() {
        assertEquals("1 2 CMAS 4 systems.", step3.print(1, 5));
    }

    @Test
    public void range1And2() {
        assertEquals("1 2.", step3.print(1, 2));
    }

    @Test
    public void incorrectRange() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> step3.print(2, 1));
        assertEquals("The range informed was wrong.", exception.getMessage());
    }

    @Test
    public void report() {
        step3.print(1, 20);
        System.out.println(step3.report());
    }

}
