package me.rred.splinter.client.routing;

import me.rred.splinter.client.routing.triggers.MapTrigger;
import me.rred.splinter.client.routing.triggers.Trigger;

public class Route {
    private Trigger startTrigger;
    private Trigger endTrigger;

    public Route(Route other) {
        this.startTrigger = other.startTrigger.copy();
        this.endTrigger = other.endTrigger.copy();
    }

    public Route() {
        startTrigger = new MapTrigger(Trigger.TriggerSlot.START);
        endTrigger = new MapTrigger(Trigger.TriggerSlot.END);
    }

    public Trigger getStartTrigger() {
        return startTrigger;
    }

    public Trigger getEndTrigger() {
        return endTrigger;
    }

    public void setStartTrigger(Trigger trigger) {
        startTrigger = trigger;
    }

    public void setEndTrigger(Trigger trigger) {
        endTrigger = trigger;
    }

}
