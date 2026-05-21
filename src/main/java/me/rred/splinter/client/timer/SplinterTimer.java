package me.rred.splinter.client.timer;

import me.rred.splinter.client.SplinterClient;
import org.lwjgl.system.CallbackI;

public class SplinterTimer {
    private enum State {IDLE, RUNNING, STOPPED}
    private State state = State.IDLE;

    private long startTime = -1;
    private long endTime = -1;

    public void start() {
        startTime = System.currentTimeMillis();
        endTime = -1;
        state = State.RUNNING;
    }

    public void stop() {
        if (state == State.RUNNING) {
            endTime = System.currentTimeMillis();
            state = State.STOPPED;
        }
    }

    public void clear() {
        startTime = -1;
        endTime = -1;
        state = State.IDLE;
    }

    public long fetchElapsedTime() {
        if (startTime == -1) {
            return 0;
        }
        if (isRunning()) {
            return System.currentTimeMillis() - startTime;
        }
        return endTime - startTime;
    }

    public boolean isRunning() { return state == State.RUNNING; }
    public boolean isStopped() { return state == State.STOPPED; }
}
