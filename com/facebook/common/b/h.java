package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes19.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger pbN = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.pbN.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.pbN.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aZ(result);
                }
            } catch (Exception e) {
                this.pbN.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.pbN.compareAndSet(0, 2)) {
            epN();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void epN() {
    }

    protected void aZ(T t) {
    }
}
