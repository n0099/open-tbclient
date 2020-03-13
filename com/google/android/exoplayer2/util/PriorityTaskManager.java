package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.PriorityQueue;
/* loaded from: classes6.dex */
public final class PriorityTaskManager {
    private final Object lock;
    private final PriorityQueue<Integer> mHJ;
    private int mHK;

    /* loaded from: classes6.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void add(int i) {
        synchronized (this.lock) {
            this.mHJ.add(Integer.valueOf(i));
            this.mHK = Math.max(this.mHK, i);
        }
    }

    public void remove(int i) {
        synchronized (this.lock) {
            this.mHJ.remove(Integer.valueOf(i));
            this.mHK = this.mHJ.isEmpty() ? Integer.MIN_VALUE : this.mHJ.peek().intValue();
            this.lock.notifyAll();
        }
    }
}
