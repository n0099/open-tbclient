package com.kwai.video.hodor.util;

import android.util.Log;
/* loaded from: classes4.dex */
public class OnceReadyBarrier {
    private boolean mIsReady = false;
    private final Object mReadyLock = new Object();

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
                } catch (InterruptedException e) {
                    Timber.e("[waitReady] get InterruptedException, continue to wait anyway", new Object[0]);
                    e.printStackTrace();
                }
            }
        }
        Timber.i("waitReady finish", new Object[0]);
    }
}
