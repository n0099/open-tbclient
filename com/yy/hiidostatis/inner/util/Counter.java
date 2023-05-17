package com.yy.hiidostatis.inner.util;

import android.os.Handler;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes10.dex */
public class Counter implements Runnable {
    public static final Callback NONE = new Callback() { // from class: com.yy.hiidostatis.inner.util.Counter.1
        @Override // com.yy.hiidostatis.inner.util.Counter.Callback
        public void onCount(int i) {
        }
    };
    public final long INTERVAL;
    public final int STEP;
    public int counter;
    public final Handler mHandler;
    public Callback mCallback = NONE;
    public boolean mRunning = false;

    /* loaded from: classes10.dex */
    public interface Callback {
        void onCount(int i);
    }

    public int count() {
        return this.counter;
    }

    public long getInterval() {
        return this.INTERVAL;
    }

    public Counter reset() {
        return setCounter(0);
    }

    public boolean running() {
        return this.mRunning;
    }

    public Counter stop() {
        this.mHandler.removeCallbacks(this);
        this.mRunning = false;
        L.verbose(this, "counter stop ,hashCode =[%d],mRunning = %b", Integer.valueOf(hashCode()), Boolean.valueOf(this.mRunning));
        return this;
    }

    public Counter(Handler handler, int i, long j, boolean z) {
        int i2;
        this.mHandler = handler;
        this.counter = i;
        this.INTERVAL = j;
        if (z) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        this.STEP = i2;
        L.verbose(this, "create counter, from %d, interval %d, step %d", Integer.valueOf(this.counter), Long.valueOf(this.INTERVAL), Integer.valueOf(this.STEP));
    }

    @Override // java.lang.Runnable
    public void run() {
        L.verbose(this, "counter run ,hashCode =[%d],mRunning = %b", Integer.valueOf(hashCode()), Boolean.valueOf(this.mRunning));
        if (this.mRunning) {
            this.mCallback.onCount(this.counter);
            this.counter += this.STEP;
            this.mHandler.postDelayed(this, this.INTERVAL);
        }
    }

    public void setCallback(Callback callback) {
        if (callback == null) {
            callback = NONE;
        }
        this.mCallback = callback;
    }

    public Counter setCounter(int i) {
        this.counter = i;
        L.verbose(this, "set to %d", Integer.valueOf(i));
        return this;
    }

    public Counter start(long j) {
        this.mHandler.removeCallbacks(this);
        this.mRunning = true;
        this.mHandler.postDelayed(this, j);
        L.verbose(this, "counter start,hashCode =[%d],mRunning = %b", Integer.valueOf(hashCode()), Boolean.valueOf(this.mRunning));
        return this;
    }

    public Counter toggle(boolean z) {
        if (z) {
            return start(0L);
        }
        return stop();
    }
}
