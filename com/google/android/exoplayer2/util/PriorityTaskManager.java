package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.PriorityQueue;
/* loaded from: classes6.dex */
public final class PriorityTaskManager {
    private final Object lock;
    private final PriorityQueue<Integer> mHw;
    private int mHx;

    /* loaded from: classes6.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void add(int i) {
        synchronized (this.lock) {
            this.mHw.add(Integer.valueOf(i));
            this.mHx = Math.max(this.mHx, i);
        }
    }

    public void remove(int i) {
        synchronized (this.lock) {
            this.mHw.remove(Integer.valueOf(i));
            this.mHx = this.mHw.isEmpty() ? Integer.MIN_VALUE : this.mHw.peek().intValue();
            this.lock.notifyAll();
        }
    }
}
