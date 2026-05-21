package me.rred.splinter.client.handler;

import me.rred.splinter.Splinter;
import me.rred.splinter.client.SplinterClient;
import me.rred.splinter.client.SplinterStateMachine;
import me.rred.splinter.client.events.MapTrigger;
import me.rred.splinter.client.events.TriggerEvent;
import me.rred.splinter.client.timer.SplinterTimer;
import me.rred.splinter.client.timer.TimerStateMachine;
import net.minecraft.util.math.BlockPos;

public class RouteHandler {
    private TriggerEvent startTrigger = new MapTrigger(TriggerEvent.TriggerType.START);
    private TriggerEvent endTrigger = new MapTrigger(TriggerEvent.TriggerType.END);
    public static SplinterTimer timer = new SplinterTimer();

    public void tick() {
        if (SplinterClient.ssm.getState() != SplinterStateMachine.State.ACTIVE) return;
        // tick poll-based events
    }

    public void onMapTickUpdated(int tick) {
        if (tick == 0) Splinter.LOGGER.info("tick reset to 0");
        //Splinter.LOGGER.info("onMapTickUpdated called, value: {}, mode: {}", tick, SplinterClient.ssm.getState());
        if (SplinterClient.ssm.getState() != SplinterStateMachine.State.ACTIVE) return;
        // will forward active route's MapTrigger
        // Splinter.LOGGER.info("RouteHandler received map tick: {}", value);
        if (startTrigger instanceof MapTrigger mt) {
            mt.mapTick(tick);
        }
        if (endTrigger instanceof MapTrigger mt) {
            mt.mapTick(tick);
        }
        checkTriggers();
    }

    private void checkTriggers() {
        //Splinter.LOGGER.info("checking triggers - start: {}, end: {}",
        //        startTrigger.isTriggered(), endTrigger.isTriggered());
        if (startTrigger.isTriggered()) {
            SplinterClient.timer.clear();
            SplinterClient.timer.start();
            startTrigger.reset();
        }

        if (endTrigger.isTriggered()) {
            SplinterClient.timer.stop();
            long time = SplinterClient.timer.fetchElapsedTime();
            SplinterClient.setManager.addTime(time);
            endTrigger.reset();
        }
    }

    public void onBlockBroken(BlockPos pos) {
        if (SplinterClient.ssm.getState() != SplinterStateMachine.State.ACTIVE) return;
        // will forward to BlockBreakTrigger later
    }

    public void toggleTimer() {
        if (SplinterClient.timer.isRunning()) {
            SplinterClient.timer.stop();
            long time = SplinterClient.timer.fetchElapsedTime();
            SplinterClient.setManager.addTime(time);
        } else {
            SplinterClient.timer.clear();
            SplinterClient.timer.start();
        }
        startTrigger.reset();
        endTrigger.reset();
    }
}
