package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger nKn = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.nKn.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.nKn.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aU(result);
                }
            } catch (Exception e) {
                this.nKn.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.nKn.compareAndSet(0, 2)) {
            dWm();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dWm() {
    }

    protected void aU(T t) {
    }
}
