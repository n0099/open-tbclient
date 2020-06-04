package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger mmA = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.mmA.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.mmA.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aM(result);
                }
            } catch (Exception e) {
                this.mmA.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.mmA.compareAndSet(0, 2)) {
            duA();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void duA() {
    }

    protected void aM(T t) {
    }
}
