package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.PriorityQueue;
/* loaded from: classes4.dex */
public final class PriorityTaskManager {
    private final Object lock;
    private final PriorityQueue<Integer> mCV;
    private int mCW;

    /* loaded from: classes4.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void add(int i) {
        synchronized (this.lock) {
            this.mCV.add(Integer.valueOf(i));
            this.mCW = Math.max(this.mCW, i);
        }
    }

    public void remove(int i) {
        synchronized (this.lock) {
            this.mCV.remove(Integer.valueOf(i));
            this.mCW = this.mCV.isEmpty() ? Integer.MIN_VALUE : this.mCV.peek().intValue();
            this.lock.notifyAll();
        }
    }
}
