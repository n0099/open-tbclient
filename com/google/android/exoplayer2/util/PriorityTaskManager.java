package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.PriorityQueue;
/* loaded from: classes5.dex */
public final class PriorityTaskManager {
    private final Object lock;
    private final PriorityQueue<Integer> mGR;
    private int mGS;

    /* loaded from: classes5.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void add(int i) {
        synchronized (this.lock) {
            this.mGR.add(Integer.valueOf(i));
            this.mGS = Math.max(this.mGS, i);
        }
    }

    public void remove(int i) {
        synchronized (this.lock) {
            this.mGR.remove(Integer.valueOf(i));
            this.mGS = this.mGR.isEmpty() ? Integer.MIN_VALUE : this.mGR.peek().intValue();
            this.lock.notifyAll();
        }
    }
}
