package dev.astro.net.utilities.timers.events;

import com.google.common.base.Optional;

import dev.astro.net.utilities.timers.Timer;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/**
 * Event called when a {@link Timer} is removed.
 */
public class TimerClearEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private Optional<UUID> userUUID;
    private Timer timer;

    public TimerClearEvent(Timer timer) {
        this.userUUID = Optional.absent();
        this.timer = timer;
    }

    public TimerClearEvent(UUID userUUID, Timer timer) {
        this.userUUID = Optional.of(userUUID);
        this.timer = timer;
    }

    /**
     * Gets the optional UUID of the user this was removed for.
     * <p>
     * This may return absent if the timer is not of a player type
     * </p>
     *
     * @return the removed user UUID or {@link Optional#absent()}
     */
    public Optional<UUID> getUserUUID() {
        return userUUID;
    }

    /**
     * Gets the {@link Timer} that was expired.
     *
     * @return the expiring timer
     */
    public Timer getTimer() {
        return timer;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
