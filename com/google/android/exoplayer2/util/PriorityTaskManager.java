package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.PriorityQueue;
/* loaded from: classes5.dex */
public final class PriorityTaskManager {
    private final Object lock;
    private final PriorityQueue<Integer> mGM;
    private int mGN;

    /* loaded from: classes5.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void add(int i) {
        synchronized (this.lock) {
            this.mGM.add(Integer.valueOf(i));
            this.mGN = Math.max(this.mGN, i);
        }
    }

    public void remove(int i) {
        synchronized (this.lock) {
            this.mGM.remove(Integer.valueOf(i));
            this.mGN = this.mGM.isEmpty() ? Integer.MIN_VALUE : this.mGM.peek().intValue();
            this.lock.notifyAll();
        }
    }
}
