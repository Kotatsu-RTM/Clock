package dev.siro256.mcmod.clock.core.type;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * This class defines world time.<br>
 * The world time constraints are:
 * <ul>
 *     <li>Value can be zero or a positive integer.</li>
 *     <li>Values range from 0 until 24,000 (exclude end value).</li>
 * </ul>
 */
public final class WorldTime {
    private final int tick;

    /**
     * Just constructor. May cause {@link IllegalArgumentException}
     * @param tick World time in tick.
     */
    public WorldTime(int tick) {
        if (tick < 0 || tick > 24_000) {
            throw new IllegalArgumentException(
                    "The argument \"" + tick + "\" is not valid. " +
                            "The value must be in range 0 to 24,000 (exclude end value)."
            );
        }

        this.tick = tick;
    }

    /**
     * Get the tick value.
     * @return The tick value.
     */
    public int getTick() {
        return tick;
    }

    // Auto Implemented by IntelliJ
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldTime worldTime = (WorldTime) o;
        return tick == worldTime.tick;
    }

    // Auto Implemented by IntelliJ
    @Override
    public int hashCode() {
        return Objects.hashCode(tick);
    }

    @Override
    public String toString() {
        return "WorldTime(" + tick + ")";
    }

    /**
     * Instantiate {@link WorldTime} and return the instance if succeeded.
     */
    @Nullable
    public static WorldTime instantiateOrNull(int tick) {
        try {
            return new WorldTime(tick);
        } catch (IllegalArgumentException exception) {
            return null;
        }
    }
}
