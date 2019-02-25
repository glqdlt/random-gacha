package com.glqdlt.ex.randomgacha;

import java.util.concurrent.Callable;

/**
 * @author Jhun
 * 2019-02-25
 */
public class GachaCallable implements Callable<Boolean> {

    private final double per;

    public GachaCallable(double per) {
        this.per = per;
    }

    @Override
    public Boolean call() {
        double ran = Math.random();
        return ran < per;
    }
}
