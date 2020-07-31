package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger mQF = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.mQF.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.mQF.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aN(result);
                }
            } catch (Exception e) {
                this.mQF.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.mQF.compareAndSet(0, 2)) {
            dCt();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dCt() {
    }

    protected void aN(T t) {
    }
}
