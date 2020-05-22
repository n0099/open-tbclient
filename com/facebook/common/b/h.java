package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger mlq = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.mlq.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.mlq.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aM(result);
                }
            } catch (Exception e) {
                this.mlq.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.mlq.compareAndSet(0, 2)) {
            dum();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dum() {
    }

    protected void aM(T t) {
    }
}
