package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger oBG = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.oBG.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.oBG.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aY(result);
                }
            } catch (Exception e) {
                this.oBG.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.oBG.compareAndSet(0, 2)) {
            egk();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void egk() {
    }

    protected void aY(T t) {
    }
}
