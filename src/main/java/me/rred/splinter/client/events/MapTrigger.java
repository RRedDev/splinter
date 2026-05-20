package me.rred.splinter.client.events;

import me.rred.splinter.Splinter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;

import javax.swing.*;

public class MapTrigger extends TriggerEvent{
    private String objective;
    private String player;
    private int prevTick = -1;

    public MapTrigger(TriggerType triggerType) {
        super(triggerType);
    }

    @Override
    public void tick() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null || client.player == null) return;

        Scoreboard scoreboard = client.world.getScoreboard();
        ScoreboardObjective objective = scoreboard.getObjective("TimerTemp");
        if (objective == null) {
            Splinter.LOGGER.info("TimerTemp objective not found");
            return;
        }

        scoreboard.getAllPlayerScores(objective).forEach(score -> {
            Splinter.LOGGER.info("TimerTemp - player: {}, score: {}",
                    score.getPlayerName(), score.getScore());
        });
    }

    //

}
