package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger lIu = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.lIu.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.lIu.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aR(result);
                }
            } catch (Exception e) {
                this.lIu.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.lIu.compareAndSet(0, 2)) {
            dkF();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dkF() {
    }

    protected void aR(T t) {
    }
}
