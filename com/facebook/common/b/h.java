package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger nkC = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.nkC.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.nkC.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aP(result);
                }
            } catch (Exception e) {
                this.nkC.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.nkC.compareAndSet(0, 2)) {
            dOu();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dOu() {
    }

    protected void aP(T t) {
    }
}
