package dev.siro256.mcmod.clock.core.converter.impl;

import dev.siro256.mcmod.clock.core.converter.TwelveHourClockConverter;
import dev.siro256.mcmod.clock.core.type.WorldTime;
import org.jetbrains.annotations.NotNull;

/**
 * JAPAN CLOCK & WATCH ASSOCIATION style 12-hour clock format converter implementation.
 */
public final class JcwaStyleTwelveHourClockConverter extends TwelveHourClockConverter {
    private static final JcwaStyleTwelveHourClockConverter INSTANCE = new JcwaStyleTwelveHourClockConverter();

    private JcwaStyleTwelveHourClockConverter() {
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
        return (int) ((worldTime.getTick() + TICK_OFFSET) / TICKS_PER_HOUR) % 12;
    }

    /**
     * Get {@link JcwaStyleTwelveHourClockConverter} instance.
     * @return The instance of this class.
     */
    @NotNull
    public static JcwaStyleTwelveHourClockConverter getInstance() {
        return INSTANCE;
    }
}
