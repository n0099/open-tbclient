package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger jZZ = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.jZZ.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.jZZ.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aw(result);
                }
            } catch (Exception e) {
                this.jZZ.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.jZZ.compareAndSet(0, 2)) {
            cCF();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void cCF() {
    }

    protected void aw(T t) {
    }
}
