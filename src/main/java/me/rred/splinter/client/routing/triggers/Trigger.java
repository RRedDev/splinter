package me.rred.splinter.client.routing.triggers;

public abstract class Trigger {

    public enum TriggerType {MAP, BLOCK_BREAK, POSITION}
    public enum TriggerSlot { START, END }

    protected boolean triggered = false; // state
    protected TriggerSlot triggerSlot;

    public Trigger(TriggerSlot triggerSlot) {
        this.triggerSlot = triggerSlot;
    }

    public abstract TriggerType getType();

    public abstract Trigger copy();

    // called by RouteHandler each tick for poll-based events;
    public void tick() {}

    // called by mixins for push-based events
    public void onFired() {
        triggered = true;
    }

    public boolean isTriggered() {
        return triggered;
    }

    public void reset() {
        triggered = false;
    }

    public TriggerSlot getTriggerSlot() {
        return triggerSlot;
    }

    public boolean slotIsStart(Trigger trigger) {
        return trigger.getTriggerSlot() == TriggerSlot.START;
    }

    public abstract boolean equals(Object obj);
}
