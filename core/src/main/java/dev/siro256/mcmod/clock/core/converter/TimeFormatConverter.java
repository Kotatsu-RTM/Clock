package dev.siro256.mcmod.clock.core.converter;

import dev.siro256.mcmod.clock.core.type.WorldTime;
import org.jetbrains.annotations.NotNull;

/**
 * This abstract class specifies what is needed for world time format converters.<br>
 * Also: <a href="https://minecraft.fandom.com/wiki/Daylight_cycle">Daylight cycle - Minecraft Wiki.</a>
 */
public abstract class TimeFormatConverter {
    /**
     * ticks in second * seconds in hour * 20 minutes (day length in real world)
     */
    protected static final int TICKS_PER_DAY = 20 * 60 * 20;
    /**
     * ticks per day / 24 hours
     */
    protected static final float TICKS_PER_HOUR = TICKS_PER_DAY / 24.0f;
    /**
     * ticks per hour / 60 seconds
     */
    protected static final float TICKS_PER_MINUTE = TICKS_PER_HOUR / 60.0f;
    /**
     * Tick 0 is 06:00 AM
     */
    protected static final float TICK_OFFSET = TICKS_PER_HOUR * 6;
    /**
     * HH:mm style format.Ex. <code>06:00</code>, <code>11:59</code>
     */
    protected static final String HOUR_MINUTE_FORMAT = "%02d:%02d";

    /**
     * Get hour number of world time in this format.<br>
     * @param worldTime The world time.
     * @return Number of hours in this format.
     */
    public abstract int getHour(@NotNull WorldTime worldTime);

    /**
     * Get minute number of world time.
     * @param worldTime The world time.
     * @return Number of minutes.
     */
    public final int getMinute(@NotNull WorldTime worldTime) {
        return (int) (worldTime.getTick() / TICKS_PER_MINUTE) % 60;
    }

    /**
     * Get formatted time text.
     * @param worldTime The world time.
     * @return Formatted time text.
     */
    @NotNull
    public abstract String getFormattedText(@NotNull WorldTime worldTime);
}
