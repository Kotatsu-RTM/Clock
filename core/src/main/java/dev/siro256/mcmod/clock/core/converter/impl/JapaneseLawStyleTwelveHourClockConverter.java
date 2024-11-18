package dev.siro256.mcmod.clock.core.converter.impl;

import dev.siro256.mcmod.clock.core.converter.TwelveHourClockConverter;
import dev.siro256.mcmod.clock.core.type.WorldTime;
import org.jetbrains.annotations.NotNull;

/**
 * <a href="https://laws.e-gov.go.jp/law/105DF0000000337">Japanese Law</a> style
 * 12-hour clock format converter implementation.
 */
public final class JapaneseLawStyleTwelveHourClockConverter extends TwelveHourClockConverter {
    private static final JapaneseLawStyleTwelveHourClockConverter INSTANCE =
            new JapaneseLawStyleTwelveHourClockConverter();

    private JapaneseLawStyleTwelveHourClockConverter() {
        super();
    }

    @Override
    public boolean isAm(@NotNull WorldTime worldTime) {
        final int tick = worldTime.getTick();
        return tick < TICKS_PER_HOUR * 7 || tick >= TICKS_PER_HOUR * 18;
    }

    @Override
    public boolean isPm(@NotNull WorldTime worldTime) {
        final int tick = worldTime.getTick();
        return tick >= TICKS_PER_HOUR * 7 && tick < TICKS_PER_HOUR * 19;
    }

    @Override
    public int getHour(@NotNull WorldTime worldTime) {
        final int zeroBasedHour = (int) ((worldTime.getTick() + TICK_OFFSET) / TICKS_PER_HOUR) % 12;
        return zeroBasedHour != 0 ? zeroBasedHour : isAm(worldTime) && isPm(worldTime) ? 0 : 12;
    }

    /**
     * Get {@link JapaneseLawStyleTwelveHourClockConverter} instance.
     * @return The instance of this class.
     */
    @NotNull
    public static JapaneseLawStyleTwelveHourClockConverter getInstance() {
        return INSTANCE;
    }
}
