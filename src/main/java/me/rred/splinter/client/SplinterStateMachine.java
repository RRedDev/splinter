package me.rred.splinter.client;

public class SplinterStateMachine {
    public enum State {
        IDLE,
        ACTIVE,
        EDIT
    }

    private State state = State.IDLE;

    public State getState() {
        return state;
    }

    public void setActive() {
        if (state == State.IDLE) {
            state = State.ACTIVE;
            // begin listening for events
        }
    }

    public void setIdle() {
        if (state != State.IDLE) {
            state = State.IDLE;
        }
        // stop listening, clear highlights
    }


    public void setEdit() {
        if (state == State.ACTIVE) return; // can't start running while making changes
        if (state == State.IDLE) {
            state = State.EDIT;
            // display set UI
        }
    }






}
