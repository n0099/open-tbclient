package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger ijY = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.ijY.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.ijY.set(3);
                try {
                    onSuccess(result);
                } finally {
                    an(result);
                }
            } catch (Exception e) {
                this.ijY.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.ijY.compareAndSet(0, 2)) {
            bUx();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void bUx() {
    }

    protected void an(T t) {
    }
}
