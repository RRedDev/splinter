package me.rred.splinter.client.handler;

import me.rred.splinter.Splinter;
import me.rred.splinter.client.SplinterClient;
import me.rred.splinter.client.SplinterStateMachine;
import net.minecraft.util.math.BlockPos;

public class RouteHandler {
    public void tick() {
        if (SplinterClient.ssm.getState() != SplinterStateMachine.State.ACTIVE) return;
        // tick poll-based events
    }

    public void onMapTickUpdated(int value) {
        if (SplinterClient.ssm.getState() != SplinterStateMachine.State.ACTIVE) return;
        // will forward active route's MapTrigger
        Splinter.LOGGER.info("RouteHandler received map tick: {}", value);
    }

    public void onBlockBroken(BlockPos pos) {
        if (SplinterClient.ssm.getState() != SplinterStateMachine.State.ACTIVE) return;
        // will forward to BlockBreakTrigger later
    }
}
