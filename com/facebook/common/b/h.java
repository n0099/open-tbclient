package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger lKa = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.lKa.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.lKa.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aR(result);
                }
            } catch (Exception e) {
                this.lKa.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.lKa.compareAndSet(0, 2)) {
            dlc();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dlc() {
    }

    protected void aR(T t) {
    }
}
