package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger lHA = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.lHA.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.lHA.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aP(result);
                }
            } catch (Exception e) {
                this.lHA.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.lHA.compareAndSet(0, 2)) {
            djp();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void djp() {
    }

    protected void aP(T t) {
    }
}
