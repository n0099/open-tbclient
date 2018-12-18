package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class e<T> implements Runnable {
    protected final AtomicInteger ifG = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.ifG.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.ifG.set(3);
                try {
                    onSuccess(result);
                } finally {
                    an(result);
                }
            } catch (Exception e) {
                this.ifG.set(4);
                j(e);
            }
        }
    }

    public void cancel() {
        if (this.ifG.compareAndSet(0, 2)) {
            bSY();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void j(Exception exc) {
    }

    protected void bSY() {
    }

    protected void an(T t) {
    }
}
