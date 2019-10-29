package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger kaQ = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.kaQ.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.kaQ.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aw(result);
                }
            } catch (Exception e) {
                this.kaQ.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.kaQ.compareAndSet(0, 2)) {
            cCH();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void cCH() {
    }

    protected void aw(T t) {
    }
}
