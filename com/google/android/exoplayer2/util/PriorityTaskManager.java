package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.PriorityQueue;
/* loaded from: classes6.dex */
public final class PriorityTaskManager {
    private final Object lock;
    private final PriorityQueue<Integer> mHy;
    private int mHz;

    /* loaded from: classes6.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void add(int i) {
        synchronized (this.lock) {
            this.mHy.add(Integer.valueOf(i));
            this.mHz = Math.max(this.mHz, i);
        }
    }

    public void remove(int i) {
        synchronized (this.lock) {
            this.mHy.remove(Integer.valueOf(i));
            this.mHz = this.mHy.isEmpty() ? Integer.MIN_VALUE : this.mHy.peek().intValue();
            this.lock.notifyAll();
        }
    }
}
