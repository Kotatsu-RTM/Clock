package dev.siro256.mcmod.clock.core.converter;

import dev.siro256.mcmod.clock.core.type.WorldTime;
import org.jetbrains.annotations.NotNull;

/**
 * This abstract class specifies what is needed for 12-hour clock format converters.
 */
public abstract class TwelveHourClockConverter extends TimeFormatConverter {
    /**
     * Gets whether the world time is AM or not.
     * @param worldTime The world time.
     * @return Whether the world time is AM or not.
     */
    public abstract boolean isAm(@NotNull WorldTime worldTime);

    /**
     * Gets whether the world time is PM or not.
     * @param worldTime The world time.
     * @return Whether the world time is PM or not.
     */
    public abstract boolean isPm(@NotNull WorldTime worldTime);

    @NotNull
    @Override
    public final String getFormattedText(@NotNull WorldTime worldTime) {
        final String suffix = isAm(worldTime) ? " AM" : " PM";
        return String.format(HOUR_MINUTE_FORMAT + suffix, getHour(worldTime), getMinute(worldTime));
    }
}
