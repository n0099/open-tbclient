package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger lDX = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.lDX.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.lDX.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aP(result);
                }
            } catch (Exception e) {
                this.lDX.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.lDX.compareAndSet(0, 2)) {
            dim();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dim() {
    }

    protected void aP(T t) {
    }
}
