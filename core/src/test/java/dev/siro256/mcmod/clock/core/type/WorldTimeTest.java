package dev.siro256.mcmod.clock.core.type;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Enclosed.class)
class WorldTimeTest {
    @RunWith(Parameterized.class)
    public static class InstantiatePositiveTest {
        private final int testCase;

        public InstantiatePositiveTest(int testCase) {
            this.testCase = testCase;
        }

        @Parameterized.Parameters
        public static Iterable<Integer> data() {
            return Arrays.asList(0, 24_000, 12_345);
        }

        @Test
        public void instantiatePositiveTest() {
            new WorldTime(testCase);
        }

        @Test
        public void instantiateOrNullPositiveTest() {
            Assert.assertNotNull(WorldTime.instantiateOrNull(testCase));
        }
    }

    @RunWith(Parameterized.class)
    public static class InstantiateNegativeTest {
        private final int testCase;

        public InstantiateNegativeTest(int testCase) {
            this.testCase = testCase;
        }

        @Parameterized.Parameters
        public static Iterable<Integer> data() {
            return Arrays.asList(-1, 24_001);
        }

        @Test(expected = IllegalArgumentException.class)
        public void instantiateNegativeTest() {
            new WorldTime(testCase);
        }

        @Test
        public void instantiateOrNullPositiveTest() {
            Assert.assertNull(WorldTime.instantiateOrNull(testCase));
        }
    }

    public static class GetTickTest {
        @Test
        public void getTickTest() {
            int testCase = 256;
            WorldTime instance = new WorldTime(testCase);
            Assert.assertEquals(testCase, instance.getTick());
        }
    }

    public static class ToStringTest {
        @Test
        public void toStringTest() {
            int testCase = 1024;
            WorldTime instance = new WorldTime(testCase);
            Assert.assertEquals("WorldTime(" + testCase + ")", instance.toString());
        }
    }

    public static class EqualityTest {
        private static final WorldTime TEST_CASE_1 = new WorldTime(128);
        private static final WorldTime TEST_CASE_2 = new WorldTime(128);
        private static final WorldTime TEST_CASE_3 = new WorldTime(0);

        @Test
        public void equalsTest() {
            Assert.assertEquals(TEST_CASE_1, TEST_CASE_2);
            Assert.assertEquals(TEST_CASE_1.hashCode(), TEST_CASE_2.hashCode());
        }

        @Test
        public void notEqualsTest() {
            Assert.assertNotEquals(TEST_CASE_1, null);
            Assert.assertNotEquals(TEST_CASE_1, TEST_CASE_3);
        }
    }
}
