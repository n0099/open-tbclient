package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger jSa = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.jSa.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.jSa.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aB(result);
                }
            } catch (Exception e) {
                this.jSa.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.jSa.compareAndSet(0, 2)) {
            cBz();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void cBz() {
    }

    protected void aB(T t) {
    }
}
