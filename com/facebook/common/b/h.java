package com.facebook.common.b;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
public abstract class h<T> implements Runnable {
    protected final AtomicInteger poy = new AtomicInteger(0);

    protected abstract T getResult() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        if (this.poy.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.poy.set(3);
                try {
                    onSuccess(result);
                } finally {
                    ba(result);
                }
            } catch (Exception e) {
                this.poy.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.poy.compareAndSet(0, 2)) {
            eqc();
        }
    }

    protected void onSuccess(T t) {
    }

    protected void onFailure(Exception exc) {
    }

    protected void eqc() {
    }

    protected void ba(T t) {
    }
}
