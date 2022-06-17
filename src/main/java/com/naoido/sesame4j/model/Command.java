package com.naoido.sesame4j.model;

public enum Command {
    TOGGLE(88),
    LOCK(82),
    UNLOCK(83);

    private final int cmd;

    Command(int cmd) {
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return String.valueOf(this.cmd);
    }
}
