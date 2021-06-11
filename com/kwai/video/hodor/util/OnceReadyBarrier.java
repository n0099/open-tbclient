package com.kwai.video.hodor.util;

import android.util.Log;
/* loaded from: classes7.dex */
public class OnceReadyBarrier {
    public boolean mIsReady = false;
    public final Object mReadyLock = new Object();

    public void setReady() {
        synchronized (this.mReadyLock) {
            this.mIsReady = true;
            this.mReadyLock.notifyAll();
        }
        Timber.d("setReady", new Object[0]);
    }

    public void waitReady() {
        while (!this.mIsReady) {
            synchronized (this.mReadyLock) {
                try {
                    Timber.d("waitReady to wait, " + Log.getStackTraceString(new Throwable()), new Object[0]);
                    this.mReadyLock.wait();
                    Timber.d("waitReady finish wait", new Object[0]);
                } catch (InterruptedException e2) {
                    Timber.e("[waitReady] get InterruptedException, continue to wait anyway", new Object[0]);
                    e2.printStackTrace();
                }
            }
        }
        Timber.i("waitReady finish", new Object[0]);
    }
}
