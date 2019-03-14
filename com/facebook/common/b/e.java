package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger jzL = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.jzL.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.jzL.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aD(result);
                }
            } catch (Exception e) {
                this.jzL.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.jzL.compareAndSet(0, 2)) {
            ctI();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void ctI() {
    }

    protected void aD(T t) {
    }
}
