package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger nkU = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.nkU.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.nkU.set(3);
                try {
                    onSuccess(result);
                } finally {
                    aP(result);
                }
            } catch (Exception e) {
                this.nkU.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.nkU.compareAndSet(0, 2)) {
            dOD();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void dOD() {
    }

    protected void aP(T t) {
    }
}
