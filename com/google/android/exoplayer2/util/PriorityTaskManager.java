package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.PriorityQueue;
/* loaded from: classes6.dex */
public final class PriorityTaskManager {
    private final Object lock;
    private final PriorityQueue<Integer> mJt;
    private int mJu;

    /* loaded from: classes6.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void add(int i) {
        synchronized (this.lock) {
            this.mJt.add(Integer.valueOf(i));
            this.mJu = Math.max(this.mJu, i);
        }
    }

    public void remove(int i) {
        synchronized (this.lock) {
            this.mJt.remove(Integer.valueOf(i));
            this.mJu = this.mJt.isEmpty() ? Integer.MIN_VALUE : this.mJt.peek().intValue();
            this.lock.notifyAll();
        }
    }
}
