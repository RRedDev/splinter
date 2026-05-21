package me.rred.splinter.client.events;

import me.rred.splinter.Splinter;
import me.rred.splinter.client.SplinterClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;

import javax.swing.*;

public class MapTrigger extends TriggerEvent{
    private String objective;
    private String player;
    private int prevTick = 0;

    public MapTrigger(TriggerType triggerType) {
        super(triggerType);
    }

    public void mapTick(int tick) {
        triggered = (triggerType == TriggerType.START && prevTick == 0 && tick > 0
             || triggerType == TriggerType.END && prevTick > 0 && tick == 0);
        // if map timer starts, trigger start trigger.
        // if map timer ends, trigger end trigger
        prevTick = tick;
    }

    @Override
    public void reset() {
        super.reset();
    }


}
