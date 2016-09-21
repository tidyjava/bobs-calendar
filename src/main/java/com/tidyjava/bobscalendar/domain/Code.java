package com.tidyjava.bobscalendar.domain;

public class Code {
    private final boolean messy;

    public static Code totalMess() {
        return new Code(true);
    }

    public static Code beauty() {
        return new Code(false);
    }

    private Code(boolean messy) {
        this.messy = messy;
    }

    public boolean isMessy() {
        return messy;
    }
}
