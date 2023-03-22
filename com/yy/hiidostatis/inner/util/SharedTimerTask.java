package com.yy.hiidostatis.inner.util;
/* loaded from: classes9.dex */
public abstract class SharedTimerTask implements Runnable {
    public static final int CANCELLED = 3;
    public static final int EXECUTED = 2;
    public static final int SCHEDULED = 1;
    public static final int VIRGIN = 0;
    public long nextExecutionTime;
    public long period;
    public final Object lock = new Object();
    public int state = 0;

    public boolean cancel() {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (this.state != 1) {
                z = false;
            }
            this.state = 3;
        }
        return z;
    }

    public long scheduledExecutionTime() {
        long j;
        synchronized (this.lock) {
            j = this.nextExecutionTime;
        }
        return j;
    }
}
