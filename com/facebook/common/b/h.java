package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger mIC = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.mIC.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.mIC.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aN(result);
                }
            } catch (Exception e) {
                this.mIC.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.mIC.compareAndSet(0, 2)) {
            dzh();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dzh() {
    }

    protected void aN(T t) {
    }
}
