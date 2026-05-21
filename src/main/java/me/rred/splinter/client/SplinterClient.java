package me.rred.splinter.client;

import me.rred.splinter.Splinter;
import me.rred.splinter.client.events.MapTrigger;
import me.rred.splinter.client.events.TriggerEvent;
import me.rred.splinter.client.handler.RouteHandler;
import me.rred.splinter.client.keyboard.KeyInputHandler;
import me.rred.splinter.client.sets.SetManager;
import me.rred.splinter.client.timer.SplinterTimer;
import me.rred.splinter.client.timer.TimerStateMachine;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardPlayerScore;

public class SplinterClient implements ClientModInitializer {
    //public static TimerStateMachine tsm = new TimerStateMachine();
    public static SplinterTimer timer = new SplinterTimer();
    public static SplinterStateMachine ssm = new SplinterStateMachine();
    public static SetManager setManager = new SetManager();
    public static RouteHandler routeHandler = new RouteHandler();

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;
            routeHandler.tick();
        });
    }
}
