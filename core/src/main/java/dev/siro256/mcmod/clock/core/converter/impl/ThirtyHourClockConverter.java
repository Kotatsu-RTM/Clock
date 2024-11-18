package dev.siro256.mcmod.clock.core.converter.impl;

import dev.siro256.mcmod.clock.core.converter.TimeFormatConverter;
import dev.siro256.mcmod.clock.core.type.WorldTime;
import org.jetbrains.annotations.NotNull;

/**
 * 30-hour clock format converter implementation.
 */
public final class ThirtyHourClockConverter extends TimeFormatConverter {
    private static final ThirtyHourClockConverter INSTANCE = new ThirtyHourClockConverter();

    private ThirtyHourClockConverter() {
        super();
    }

    @Override
    public int getHour(@NotNull WorldTime worldTime) {
        return (int) ((worldTime.getTick() + TICK_OFFSET) / TICKS_PER_HOUR);
    }

    @NotNull
    @Override
    public String getFormattedText(@NotNull WorldTime worldTime) {
        return String.format(HOUR_MINUTE_FORMAT, getHour(worldTime), getMinute(worldTime));
    }

    /**
     * Get {@link ThirtyHourClockConverter} instance.
     * @return The instance of this class.
     */
    @NotNull
    public static ThirtyHourClockConverter getInstance() {
        return INSTANCE;
    }
}
