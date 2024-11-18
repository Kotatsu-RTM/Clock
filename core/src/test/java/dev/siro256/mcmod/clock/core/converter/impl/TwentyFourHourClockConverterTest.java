package dev.siro256.mcmod.clock.core.converter.impl;

import dev.siro256.mcmod.clock.core.type.WorldTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TwentyFourHourClockConverterTest {
    private final TestCase testCase;

    public TwentyFourHourClockConverterTest(TestCase testCase) {
        this.testCase = testCase;
    }

    @Parameterized.Parameters
    public static Iterable<TestCase> data() {
        return Arrays.asList(
                new TestCase(0, 6, 0, "06:00"),
                new TestCase(5_999, 11, 59, "11:59"),
                new TestCase(6_000, 12, 0, "12:00"),
                new TestCase(6_999, 12, 59, "12:59"),
                new TestCase(7_000, 13, 0, "13:00"),
                new TestCase(12_345, 18, 20, "18:20"),
                new TestCase(17_999, 23, 59, "23:59"),
                new TestCase(18_000, 0, 0, "00:00"),
                new TestCase(18_999, 0, 59, "00:59"),
                new TestCase(19_000, 1, 0, "01:00"),
                new TestCase(21_381, 3, 22, "03:22"),
                new TestCase(23_999, 5, 59, "05:59")
        );
    }

    @Test
    public void getHourTest() {
        Assert.assertEquals(
                testCase.expectedHour,
                TwentyFourHourClockConverter.getInstance().getHour(testCase.worldTime)
        );
    }

    @Test
    public void getMinuteTest() {
        Assert.assertEquals(
                testCase.expectedMinute,
                TwentyFourHourClockConverter.getInstance().getMinute(testCase.worldTime)
        );
    }

    @Test
    public void getFormattedTextTest() {
        Assert.assertEquals(
                testCase.expectedFormattedText,
                TwentyFourHourClockConverter.getInstance().getFormattedText(testCase.worldTime)
        );
    }

    private static class TestCase {
        private final WorldTime worldTime;
        private final int expectedHour;
        private final int expectedMinute;
        private final String expectedFormattedText;

        private TestCase(int tick, int expectedHour, int expectedMinute, String expectedFormattedText) {
            this.worldTime = new WorldTime(tick);
            this.expectedHour = expectedHour;
            this.expectedMinute = expectedMinute;
            this.expectedFormattedText = expectedFormattedText;
        }
    }
}
