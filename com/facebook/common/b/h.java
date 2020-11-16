package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger oMD = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.oMD.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.oMD.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aZ(result);
                }
            } catch (Exception e) {
                this.oMD.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.oMD.compareAndSet(0, 2)) {
            ejX();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void ejX() {
    }

    protected void aZ(T t) {
    }
}
