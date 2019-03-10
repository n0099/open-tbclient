package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger jzT = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.jzT.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.jzT.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aD(result);
                }
            } catch (Exception e) {
                this.jzT.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.jzT.compareAndSet(0, 2)) {
            ctF();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void ctF() {
    }

    protected void aD(T t) {
    }
}
