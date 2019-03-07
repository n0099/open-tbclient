package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger jzA = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.jzA.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.jzA.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aC(result);
                }
            } catch (Exception e) {
                this.jzA.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.jzA.compareAndSet(0, 2)) {
            ctv();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void ctv() {
    }

    protected void aC(T t) {
    }
}
