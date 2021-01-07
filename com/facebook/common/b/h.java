package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger psZ = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.psZ.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.psZ.set(3);
                try {
                    onSuccess(result);
                } finally {
                    ba(result);
                }
            } catch (Exception e) {
                this.psZ.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.psZ.compareAndSet(0, 2)) {
            etW();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void etW() {
    }

    protected void ba(T t) {
    }
}
