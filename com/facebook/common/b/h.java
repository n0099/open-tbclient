package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger oKZ = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.oKZ.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.oKZ.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aY(result);
                }
            } catch (Exception e) {
                this.oKZ.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.oKZ.compareAndSet(0, 2)) {
            ejZ();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void ejZ() {
    }

    protected void aY(T t) {
    }
}
