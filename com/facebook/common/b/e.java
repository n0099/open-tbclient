package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger hYt = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.hYt.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.hYt.set(3);
                try {
                    onSuccess(result);
                } finally {
                    am(result);
                }
            } catch (Exception e) {
                this.hYt.set(4);
                j(e);
            }
        }
    }

    public void cancel() {
        if (this.hYt.compareAndSet(0, 2)) {
            bQT();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void j(Exception exc) {
    }

    protected void bQT() {
    }

    protected void am(T t) {
    }
}
