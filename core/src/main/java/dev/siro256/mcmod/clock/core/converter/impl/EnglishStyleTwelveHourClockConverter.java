package dev.siro256.mcmod.clock.core.converter.impl;

import dev.siro256.mcmod.clock.core.converter.TwelveHourClockConverter;
import dev.siro256.mcmod.clock.core.type.WorldTime;
import org.jetbrains.annotations.NotNull;

/**
 * English-speaking countries style 12-hour clock format converter implementation.
 */
public final class EnglishStyleTwelveHourClockConverter extends TwelveHourClockConverter {
    private static final EnglishStyleTwelveHourClockConverter INSTANCE = new EnglishStyleTwelveHourClockConverter();

    private EnglishStyleTwelveHourClockConverter() {
        super();
    }

    @Override
    public boolean isAm(@NotNull WorldTime worldTime) {
        final int tick = worldTime.getTick();
        return tick < TICKS_PER_HOUR * 6 || tick >= TICKS_PER_HOUR * 18;
    }

    @Override
    public boolean isPm(@NotNull WorldTime worldTime) {
        final int tick = worldTime.getTick();
        return tick >= TICKS_PER_HOUR * 6 && tick < TICKS_PER_HOUR * 18;
    }

    @Override
    public int getHour(@NotNull WorldTime worldTime) {
        final int zeroBasedHour = (int) ((worldTime.getTick() + TICK_OFFSET) / TICKS_PER_HOUR) % 12;
        return zeroBasedHour != 0 ? zeroBasedHour : 12;
    }

    /**
     * Get {@link EnglishStyleTwelveHourClockConverter} instance.
     * @return The instance of this class.
     */
    @NotNull
    public static EnglishStyleTwelveHourClockConverter getInstance() {
        return INSTANCE;
    }
}
