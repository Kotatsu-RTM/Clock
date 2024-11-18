package dev.siro256.mcmod.clock.core.converter.impl;

import dev.siro256.mcmod.clock.core.converter.TimeFormatConverter;
import dev.siro256.mcmod.clock.core.type.WorldTime;
import org.jetbrains.annotations.NotNull;

/**
 * 24-hour clock format converter implementation.
 */
public final class TwentyFourHourClockConverter extends TimeFormatConverter {
    private static final TwentyFourHourClockConverter INSTANCE = new TwentyFourHourClockConverter();

    private TwentyFourHourClockConverter() {
        super();
    }

    @Override
    public int getHour(@NotNull WorldTime worldTime) {
        return (int) ((worldTime.getTick() + TICK_OFFSET) / TICKS_PER_HOUR) % 24;
    }

    @NotNull
    @Override
    public String getFormattedText(@NotNull WorldTime worldTime) {
        return String.format(HOUR_MINUTE_FORMAT, getHour(worldTime), getMinute(worldTime));
    }

    /**
     * Get {@link TwentyFourHourClockConverter} instance.
     * @return The instance of this class.
     */
    @NotNull
    public static TwentyFourHourClockConverter getInstance() {
        return INSTANCE;
    }
}
