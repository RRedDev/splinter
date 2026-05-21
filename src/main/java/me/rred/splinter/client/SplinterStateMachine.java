package me.rred.splinter.client;

import me.rred.splinter.Splinter;

public class SplinterStateMachine {
    public enum State {
        IDLE,
        ACTIVE,
        EDIT
    }

    private State state = State.ACTIVE;

    public State getState() {
        return state;
    }

    public void setActive() {
        if (state == State.IDLE) {
            state = State.ACTIVE;
            Splinter.LOGGER.info("SSM: switched to ACTIVE");
            // begin listening for events
        }
    }

    public void setIdle() {
        if (state != State.IDLE) {
            state = State.IDLE;
            Splinter.LOGGER.info("SSM: switched to IDLE");
        }
        // stop listening, clear highlights
    }


    public void setEdit() {
        if (state == State.ACTIVE) return; // can't start running while making changes
        if (state == State.IDLE) {
            state = State.EDIT;
            Splinter.LOGGER.info("SSM: switched to EDIT");
            // display set UI
        }
    }






}
