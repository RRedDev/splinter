package me.rred.splinter.client;

import me.rred.splinter.client.keyboard.KeyInputHandler;
import me.rred.splinter.client.sets.SetManager;
import me.rred.splinter.client.timer.TimerStateMachine;
import net.fabricmc.api.ClientModInitializer;

public class SplinterClient implements ClientModInitializer {
    public static TimerStateMachine tsm = new TimerStateMachine();
    public static SetManager setManager = new SetManager();

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
