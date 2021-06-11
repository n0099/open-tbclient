package com.yy.hiidostatis.inner.util;

import android.os.Handler;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes7.dex */
public class Counter implements Runnable {
    public static final Callback NONE = new Callback() { // from class: com.yy.hiidostatis.inner.util.Counter.1
        @Override // com.yy.hiidostatis.inner.util.Counter.Callback
        public void onCount(int i2) {
        }
    };
    public final long INTERVAL;
    public final int STEP;
    public int counter;
    public final Handler mHandler;
    public Callback mCallback = NONE;
    public boolean mRunning = false;

    /* loaded from: classes7.dex */
    public interface Callback {
        void onCount(int i2);
    }

    public Counter(Handler handler, int i2, long j, boolean z) {
        this.mHandler = handler;
        this.counter = i2;
        this.INTERVAL = j;
        this.STEP = z ? 1 : -1;
        L.verbose(this, "create counter, from %d, interval %d, step %d", Integer.valueOf(this.counter), Long.valueOf(this.INTERVAL), Integer.valueOf(this.STEP));
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

    @Override // java.lang.Runnable
    public void run() {
        L.verbose(this, "counter run ,hashCode =[%d],mRunning = %b", Integer.valueOf(hashCode()), Boolean.valueOf(this.mRunning));
        if (this.mRunning) {
            this.mCallback.onCount(this.counter);
            this.counter += this.STEP;
            this.mHandler.postDelayed(this, this.INTERVAL);
        }
    }

    public boolean running() {
        return this.mRunning;
    }

    public void setCallback(Callback callback) {
        if (callback == null) {
            callback = NONE;
        }
        this.mCallback = callback;
    }

    public Counter setCounter(int i2) {
        this.counter = i2;
        L.verbose(this, "set to %d", Integer.valueOf(i2));
        return this;
    }

    public Counter start(long j) {
        this.mHandler.removeCallbacks(this);
        this.mRunning = true;
        this.mHandler.postDelayed(this, j);
        L.verbose(this, "counter start,hashCode =[%d],mRunning = %b", Integer.valueOf(hashCode()), Boolean.valueOf(this.mRunning));
        return this;
    }

    public Counter stop() {
        this.mHandler.removeCallbacks(this);
        this.mRunning = false;
        L.verbose(this, "counter stop ,hashCode =[%d],mRunning = %b", Integer.valueOf(hashCode()), Boolean.valueOf(this.mRunning));
        return this;
    }

    public Counter toggle(boolean z) {
        return z ? start(0L) : stop();
    }
}
