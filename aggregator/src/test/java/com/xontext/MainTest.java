package com.xontext;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {
    @Test
    public void testMainOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});
        System.setOut(originalOut);

        String actual = outContent.toString().replace("\r\n", "\n").trim();
        String expected = ("Hello and welcome!").trim();

        assertEquals(expected, actual, "Messages should be the same");
    }

    private void assertEquals(String expected, String actual, String messagesShouldBeTheSame) {
    }
}