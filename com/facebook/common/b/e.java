package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger jRW = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.jRW.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.jRW.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aB(result);
                }
            } catch (Exception e) {
                this.jRW.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.jRW.compareAndSet(0, 2)) {
            cBy();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void cBy() {
    }

    protected void aB(T t) {
    }
}
