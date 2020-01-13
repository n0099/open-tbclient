package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger lHv = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.lHv.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.lHv.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aP(result);
                }
            } catch (Exception e) {
                this.lHv.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.lHv.compareAndSet(0, 2)) {
            djn();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void djn() {
    }

    protected void aP(T t) {
    }
}
