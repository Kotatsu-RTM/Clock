package dev.siro256.mcmod.clock.core.converter.impl;

import dev.siro256.mcmod.clock.core.type.WorldTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class JapaneseLawStyleTwelveHourClockConverterTest {
    private final TestCase testCase;

    public JapaneseLawStyleTwelveHourClockConverterTest(TestCase testCase) {
        this.testCase = testCase;
    }

    @Parameterized.Parameters
    public static Iterable<TestCase> data() {
        return Arrays.asList(
                new TestCase(0, 6, 0, true, false, "06:00 AM"),
                new TestCase(5_999, 11, 59, true, false, "11:59 AM"),
                new TestCase(6_000, 12, 0, true, false, "12:00 AM"),
                new TestCase(6_999, 12, 59, true, false, "12:59 AM"),
                new TestCase(7_000, 1, 0, false, true, "01:00 PM"),
                new TestCase(12_345, 6, 20, false, true, "06:20 PM"),
                new TestCase(17_999, 11, 59, false, true, "11:59 PM"),
                new TestCase(18_000, 0, 0, true, true, "00:00 AM"),
                new TestCase(18_999, 0, 59, true, true, "00:59 AM"),
                new TestCase(19_000, 1, 0, true, false, "01:00 AM"),
                new TestCase(21_381, 3, 22, true, false, "03:22 AM"),
                new TestCase(23_999, 5, 59, true, false, "05:59 AM")
        );
    }

    @Test
    public void getHourTest() {
        Assert.assertEquals(
                testCase.expectedHour,
                JapaneseLawStyleTwelveHourClockConverter.getInstance().getHour(testCase.worldTime)
        );
    }

    @Test
    public void getMinuteTest() {
        Assert.assertEquals(
                testCase.expectedMinute,
                JapaneseLawStyleTwelveHourClockConverter.getInstance().getMinute(testCase.worldTime)
        );
    }

    @Test
    public void isAmTest() {
        Assert.assertEquals(
                testCase.expectedIsAm,
                JapaneseLawStyleTwelveHourClockConverter.getInstance().isAm(testCase.worldTime)
        );
    }

    @Test
    public void isPmTest() {
        Assert.assertEquals(
                testCase.expectedIsPm,
                JapaneseLawStyleTwelveHourClockConverter.getInstance().isPm(testCase.worldTime)
        );
    }

    @Test
    public void getFormattedTextTest() {
        Assert.assertEquals(
                testCase.expectedFormattedText,
                JapaneseLawStyleTwelveHourClockConverter.getInstance().getFormattedText(testCase.worldTime)
        );
    }

    private static class TestCase {
        private final WorldTime worldTime;
        private final int expectedHour;
        private final int expectedMinute;
        private final boolean expectedIsAm;
        private final boolean expectedIsPm;
        private final String expectedFormattedText;

        private TestCase(
                int tick,
                int expectedHour, int expectedMinute,
                boolean expectedIsAm, boolean expectedIsPm,
                String expectedFormattedText
        ) {
            this.worldTime = new WorldTime(tick);
            this.expectedHour = expectedHour;
            this.expectedMinute = expectedMinute;
            this.expectedIsAm = expectedIsAm;
            this.expectedIsPm = expectedIsPm;
            this.expectedFormattedText = expectedFormattedText;
        }
    }
}
