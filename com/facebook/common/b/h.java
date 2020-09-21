package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger nuU = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.nuU.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.nuU.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aR(result);
                }
            } catch (Exception e) {
                this.nuU.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.nuU.compareAndSet(0, 2)) {
            dSB();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dSB() {
    }

    protected void aR(T t) {
    }
}
