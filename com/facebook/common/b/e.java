package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger jzf = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.jzf.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.jzf.set(3);
                try {
                    onSuccess(result);
                } finally {
                    az(result);
                }
            } catch (Exception e) {
                this.jzf.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.jzf.compareAndSet(0, 2)) {
            ctB();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void ctB() {
    }

    protected void az(T t) {
    }
}
